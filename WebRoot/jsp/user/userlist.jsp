<%@ page language="java" import="java.util.*,com.etc.fms.user.entity.User"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
--%>
<%--
	List<User> list = (List<User>)session.getAttribute("list");
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <base href="<%=basePath%>"> --%>

<title>用户管理</title>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js">
</script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/icon.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery.easyui.min.js">
</script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js">
</script>
<script type="text/javascript">
	var url;
	$(function() {
		//字符验证组件 
		$('#loginname,#username,#password,#tel').validatebox( {
			required : true,
			missingMessage : '输入项不能为空!'

		});
		$('#age').numberbox( {
			required : true,
			missingMessage : '输入必须是数字!',
			precision : 0
		});
		$('#btn').click(function() {
			if (!$('#myform').form('validate')) {
				$.messager.show( {
					title : '提示信息',
					msg : '验证没有通过,不能提交表单!'
				});
				return false; //当表单验证不通过的时候 必须要return false 
			}

		});
	});
	//这里添加窗口
	function openAddUserDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "用户新增");
		//处理增加操作的url地址 控制器的访问路径
		//url = "${pageContext.request.contextPath}/testapi/add";
	}
	
	//这个方法具体添加(也可能是修改)动作
	function saveUser() {
		$("#fm").form("submit", {
			url : url,
			onSubmit : function() {
				return $(this).form("validate");
			},
			success : function(result) {
				console.log("result :" + result);
				//这个方法的判断 最好再优化一下;
				if (result=="true") {
					$.messager.alert("系统提示", "保存成功");
					resetValue();
					$("#dlg").dialog("close");
					//重新加载数据到datagrid
					$("#dg").datagrid("reload");
				} else {
					$.messager.alert("系统提示", "保存失败");
					return;
				}
			}
		});
	}

	//弹出修改用户的对话框
	function openUserModifyDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "编辑用户信息");
		$("#loginname").val(row.loginname);
		$("#username").val(row.username); //这里要一致
		$("#password").val(row.password);
		$("#age").val(row.age);
		$("#tel").val(row.tel);
		$("#gender").combobox("setValue", row.gender);
		//个url就是我们呀欧完成修改的那个控制器中url地址
		url = "${pageContext.request.contextPath}/testapi/update/" + row.id;
	}
	
	//重置 表单元素还原到初始化状态
	function resetValue() {
		$("#loginname").val("");
		$("#username").val("");
		$("#password").val("");
		$("#age").combobox("setValue", "");
		$("#tel").datebox("setValue", "");
	}

	//关闭窗口
	function closeUserDialog() {
		$("#dlg").dialog("close");
		resetValue();
	}
</script>
</head>
<body>
	<center>
		<h2>用户信息管理</h2>
		<form id="myform1" method="post" action="UserSevlet?method=query">
			<table width="50%" border="0">
				<tr align="center">
					<td>登录名: <input type="text" name="loginname" id="usssername"
						size="25"> &nbsp;&nbsp; 姓名: <input type="text"
						name="username" id="lll" size="25"> &nbsp;&nbsp; <input
						type="submit" id="btn1" value="查询" />
					</td>
				</tr>

			</table>
		</form>
		<table width="60%" border="1" cellpadding="0" cellspacing="0"
			style="border-collapse: collapse; border-color: blue;">
			<tr class="line_g hover_bg" align="center" bgcolor="lightblue">
				<td width="10%">用户昵称</td>
				<td width="16%">用户名</td>
				<td width="11%">年龄</td>
				<td width="11%">性别</td>
				<td width="18%">电话</td>
				<td width="11%">职位</td>
				<td width="33%">操作</td>
			</tr>
			<c:forEach items="${list}" var="user">
			<tr>
				<td width="10%">${user.loginname} </td>
				<td width="16%">${user.username} </td>
				<td width="11%">${user.age}</td>
				<td width="11%">${user.gender}</td>
				<td width="18%">${user.tel}</td>
				<td width="11%">${user.role}</td>
				<td align="center">
				<a href="javascript:openAddUserDialog()" class="easyui-linkbutton"
				iconCls="icon-add">添加</a>
				<a href="deleteUser?uid=${user.uid}" class="easyui-linkbutton"
				iconCls="icon-remove">删除</a>
				<a href="javascript:openAddUserDialog()" class="easyui-linkbutton"
				iconCls="icon-edit">修改</a>
				</td>
			</tr>
			</c:forEach>
	
		
		</table>
		<div id="dlg" class="easyui-dialog" style="width: 345px;height:280px;padding: 10px 20px" 
		closed="true" >
		<form id="myform" method="post" action="UserSevlet?method=save">
			<table border="1" cellpadding="0" cellspacing="0"
				style="border-collapse: collapse; border-color: blue;">
				<tr class="line_g hover_bg" align="center" bgcolor="lightblue">
					<th colspan="2">用户信息新增</th>

				</tr>
				<tr>
					<td align="right">登录名:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="loginname"
						id="loginname" size="21" />
					</td>
				</tr>
				<tr>
					<td align="right">用户名:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="username"
						id="username" size="21" />
					</td>
				</tr>
				<tr>
					<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="password" name="password"
						id="password" size="23" />
					</td>
				</tr>
				<tr>
					<td align="right">年&nbsp;&nbsp;&nbsp;&nbsp;龄:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="age" id="age"
						size="21" />
					</td>
				</tr>
				<tr>
					<td align="right">电&nbsp;&nbsp;&nbsp;&nbsp;话:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="tel" id="tel"
						size="21" />
					</td>
				</tr>
				<tr>
					<td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="radio" name="gender" value="男"
						checked="checked" /> 男 &nbsp;&nbsp; <input type="radio"
						name="gender" value="女" /> 女
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><input type="submit" id="btn" value="新增" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
		</div>
	</center>
</body>
</html>
