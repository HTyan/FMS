/**
 * Ajax 刷新页面, oldReplacedCompId属性必须存在, 且以该属性为id查找出来的dom节点必须在body标签内, 不能在body标签上, 
 * 如果调用的方法 load/submitForm/loadAsJson中存在ajaxLoaderDom参数，则oldReplacedCompId属性无效(即不须存在)
 * 运行机制：
 *   将原页面中 id为oldReplacedCompId的节点 或 ajaxLoaderDom节点 内的内容 替换为 请求所返回页面内 id 为 newReplacedCompId的内容
 * 	 1.) 所对应的action必须返回的是一个页面
 * 	 2.) newReplacedCompId: 
 *       a.) 如果存在, 以该属性为id的dom节点必须在body标签内, 不能在body标签上
 *       b.) 如果不存在, 则替换新返回页面的所有内容
 *   3.) 默认将 要替换的内容用遮罩层盖住，可用 ajaxLoaderDomFunc 自定义要盖住的地方
 *   
 * @param jsFuncAfterLoad: ajax调用完后执行的js方法, loadAsJson方法必备
 * @param isReplaceHtmlContent: 默认为true, 当调用 load 或 submitForm 时使用该属性才有意义    
 * @param ajaxLoaderDomFunc: js方法，用于处理遮罩层的生成方式，如将默认要盖住的地方的父节点给盖住
 *   改方法支持一个参数，即要盖住的节点
 * @param otherParams: 其他参数, 以下是支持参数：
 *      {
 *      	timeOut: 30000 //单位： 毫秒
 *      }
 */
function AjaxContext(oldReplacedCompId, newReplacedCompId, jsFuncAfterLoad, isReplaceHtmlContent, ajaxLoaderDomFunc, otherParams) {
	this.oldReplacedCompId = oldReplacedCompId;
	this.newReplacedCompId = newReplacedCompId;
	this.jsFuncAfterLoad = jsFuncAfterLoad;
	this.isReplaceHtmlContent = isDefined(isReplaceHtmlContent) ? isReplaceHtmlContent : true;
	this.createdTime = new Date().getTime();
	this.ajaxLoaderDomFunc = ajaxLoaderDomFunc;
	this.otherParams = otherParams;
	
	/**
	 * ajax调用, 通过传递参数
	 * @param url  即action, 如 /admin/organization_list.action
	 * @param params  参数, 如 {name: 'hello', type: 'type'}
	 * @param ajaxLoaderDom 如果设置该值, 加载数据时会让该dom节点内的所有内容变灰, 
	 * 		如果未设置该值, 默认会让oldReplacedCompId对应的dom节点内的内容变灰,
	 *      注意, ajaxLoaderDom必须为jquery查询出来的对象
	 * 
	 * 当然, url中也可带参数, 如 /admin/organization_list.action?name='hello'
	 */
	this.load = function(url, params, ajaxLoaderDom) {
		this._ajaxCall(url, params, ajaxLoaderDom);
	};
	
	/**
	 * ajax调用, 通过递交整个表单
	 * @param ajaxLoaderDom 如果设置该值, 加载数据时会让该dom节点内的所有内容变灰, 
	 * 		如果未设置该值, 默认会让oldReplacedCompId对应的dom节点内的内容变灰,
	 *      注意, ajaxLoaderDom必须为jquery查询出来的对象
	 * @param otherJqueryParams 表单提交时额外提交的参数，格式为 json 或 json组成的array $.param转化生成的结果
	 */
	this.submitForm = function(eleForm, ajaxLoaderDom, otherJqueryParams) {
		var params = null;
		if (isDefined(otherJqueryParams)) {
			params = eleForm.serialize() + "&" + otherJqueryParams;
		} else {
			params = eleForm.serialize();
		}
		
		this._ajaxCall(eleForm.attr("action"), params, ajaxLoaderDom);
	};
	
	/**
	 * ajax调用, 通过传递参数, 并调用后台返回的json刷新数据
	 * @param url  即action, 如 /admin/organization_list.action
	 * @param params  参数, 如 {name: 'hello', type: 'type'}
	 * @param ajaxLoaderDom 如果设置该值, 加载数据时会让该dom节点内的所有内容变灰,
	 * 		如果未设置该值, 默认会让oldReplacedCompId对应的dom节点内的内容变灰,
	 * 		注意, ajaxLoaderDom必须为jquery查询出来的对象
	 */
	this.loadAsJson = function(url, params, ajaxLoaderDom) {
		this.isReplaceHtmlContent = false;
		this._ajaxCall(url, params, ajaxLoaderDom, "json");
	};
	
	this._ajaxCall = function(url, params, ajaxLoaderDom, dataType) {
		var currentAjaxContext = this._prepareLoading(ajaxLoaderDom);
		
		var timeOut = null;
		if (isDefined(this._getOtherParam("useDefaultTimeOut"))) {
			var DEFAULT_TIME_OUT = 30000; //30秒超时时间
			timeOut = DEFAULT_TIME_OUT;
		} else {
			timeOut = this._getOtherParam("timeOut");
		}
		
		if (isLatestAjaxContext(this)) {
			var ajaxOptions = {
				type: "POST",
			    dataType: isDefined(dataType) ? dataType : "text",
				url: setUrlNowTime(url),
				data: params,
				cache: false,
				success: function(msg){
					currentAjaxContext._callbackFun(msg);
				},
				error: function(xmlHttpRequest, textStatus, errorThrown) {
					if (textStatus == "timeout") {
						$.dialog.alert(getLocaleMessage("ajax.timeout"));
					} else {
					}
					currentAjaxContext._hideAjaxLoader();
				}
			};
			
			if (isDefined(timeOut)) {
				ajaxOptions.timeout = timeOut;
			}
			
			$.ajax(ajaxOptions);
		}
	};
	
	this._prepareLoading = function(ajaxLoaderDom) {
		setLatestAjaxContext(this);
		this._showAjaxLoader(ajaxLoaderDom);
		return this;
	};
	
	this._showAjaxLoader = function(ajaxLoaderDom) {
		if (isLatestAjaxContext(this)) {
			this.oldReplacedComp = $("#" + this.oldReplacedCompId);
			var eleAjaxOverlay = $(".ajax_overlay");
			if (eleAjaxOverlay.length == 0 || eleAjaxOverlay.hasClass("fn-hide")) {
				eleAjaxOverlay.remove();
				
				eleAjaxOverlay = $("<div></div>").addClass("ajax_overlay");
				$("body").append(eleAjaxOverlay);
				
				var eleAjaxLoaderDom = this._getAjaxLoaderDom(ajaxLoaderDom);
				eleAjaxOverlay.removeClass("fn-hide");
			}
		}
	};
	
	this._hideAjaxLoader = function() {
		if (isLatestAjaxContext(this)) {
			$(".ajax_overlay").addClass("hidden");
		}
	};
	
	this._callbackFun = function(data) {
		if (isLatestAjaxContext(this)) {
			//数组第一个对象为 html dom对象, 其他对象为script节点
			var eleData = $("<div>" + data + "</div>");
			
		    this._replaceHtmlContent(eleData);
			this._invokePageJavascript(eleData);
			
			if (isLatestAjaxContext(this) && typeof jsFuncAfterLoad == "function") {
				jsFuncAfterLoad(data);
			}
			
			fixTabKeyInFireFox();
			this._hideAjaxLoader();
		}
	};
	
	this._replaceHtmlContent = function(eleData) {
		if (isLatestAjaxContext(this)) {
			if (isDefined(this.isReplaceHtmlContent) && this.isReplaceHtmlContent) {
				var eleDomData = eleData[0];
				this.oldReplacedComp.empty();
				
				if (this._isReplaceAll()) {
					this.oldReplacedComp.html(eleDomData);
					this._adjustPasswordFields(eleData);
				} else {
					var eleReplacedData = $("#" + this.newReplacedCompId, eleDomData);
					if (typeof eleReplacedData == undefined || 
							eleReplacedData == null || 
							eleReplacedData.length != 1) {
						//alert(getLocaleMessage("dialog.dom.error",[newReplacedCompId]));
						this.oldReplacedComp.html(eleDomData);
						this._adjustPasswordFields(eleData);
					} else {
						this.oldReplacedComp.html(eleReplacedData[0].innerHTML);
						this._adjustPasswordFields(eleReplacedData);
					}
				}
			}
		}
	};
	
	/**
	 * 调用新页面的javascript
	 */
	this._invokePageJavascript = function(eleData) {
		if (isLatestAjaxContext(this)) {
			var JS_INDEX = 1;
			var INDEX_NOT_FOUND = -1;
			for (var i = JS_INDEX; i < eleData.length; i++) {
				if (eleData[i].src.indexOf("common.js") == INDEX_NOT_FOUND) {
					this.oldReplacedComp.append(eleData[i]);
				}
			}
		}
	};
	
	this._isReplaceAll = function() {
		return newReplacedCompId == null || typeof newReplacedCompId == "undefined";
	};
	
	this._adjustPasswordFields = function(targetReplacedComp) {
		var elePasswords = $("[type='password']", targetReplacedComp);
		$("[type='password']", this.oldReplacedComp).each(
			function(index) {
				$(this).val(elePasswords[index].value);
			}
		);
	};
	
	this._getAjaxLoaderDom = function(ajaxLoaderDom) {
		var result = ajaxLoaderDom;
		if (!isDefined(result)) {
			result = (typeof this.ajaxLoaderDomFunc == "function") ? ajaxLoaderDomFunc(this.oldReplacedComp) : this.oldReplacedComp;
		}
		return result;
	};
	
	this._getOtherParam = function(key, defaultValue) {
		var result = null;
		if (isDefined(this.otherParams)) {
			result = this.otherParams[key];
		}
		
		if (isDefined(defaultValue) && !isDefined(result)) {
			result = defaultValue;
		}
		return result;
	};
}









function setLatestAjaxContext(ajaxContext) {
	g_latestAjaxContext = ajaxContext;
}

function isLatestAjaxContext(ajaxContext) {
	var result = true;
	if (typeof g_latestAjaxContext != "undefined" && g_latestAjaxContext != null) {
		result = g_latestAjaxContext.createdTime == ajaxContext.createdTime;
	}
	return result;
}

$.ajaxSetup({
    contentType:"application/x-www-form-urlencoded;charset=utf-8",
    complete:function(XMLHttpRequest,textStatus){
    	var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，   
        if(sessionstatus=="timeout"){
        	//如果超时就处理 ，显示超时页面
           $("body").html(XMLHttpRequest.responseText);    
        }    
    }    
});  

function isDefined(ele) {
	return ele != null && typeof ele != "undefined";
}

//在每个url后面加上时间，防止缓存问题
function setUrlNowTime(url){
	if(null==url || url==""){
		return "";
	}
	if(url.indexOf('?')>0){
		url += "&temp="+ new Date().getTime();
	}else{
		url += "?temp="+new Date().getTime();
	}
	return url;
}

/**
 * 火狐下UL按tab键盘会聚焦的问题修复
 *
 */
function fixTabKeyInFireFox(){
	$("form ul").attr("tabindex","-1");
}
