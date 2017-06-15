<%@ page language="java" import="java.util.*,com.dyc.po.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
	} //重新登录
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>货款录入</title>
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
$(function() {

	//字符验证组件 
	$('#cno').validatebox( {
		required : true,
		missingMessage : '输入项不能为空!'

	});

	$('#ys').numberbox( {
		required : false,
		missingMessage : '输入必须是数字!',
		precision : 2
	});

	$('#ftime,#ytime').datebox( {
		//missingMessage : '日期不能为空!',
			required : false
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
</script>
</head>
<body>
	<center>
		<h2>
			货款录入管理&nbsp;&nbsp;&nbsp;&nbsp;<%
				if ("success".equals(request.getAttribute("result"))) {
			%><font color="red">添加成功！</font>
			<%
					} else if (request.getAttribute("result") != null) {
				%><font color="red"><%=request.getAttribute("result")%>！</font>
			<%
					}
				%>
		</h2>
		<form id="myform" method="post" action="FinanceServlet?method=update">
			<table width="50%" border="1" cellpadding="0" cellspacing="0"
				style="border-collapse: collapse; border-color: blue;">
				<tr class="line_g hover_bg" align="center" bgcolor="lightblue">
					<th colspan="2">&nbsp;</th>
				</tr>
				<tr class="line_g hover_bg" bgcolor="lightblue">
					<td align="right">所属公司:&nbsp;&nbsp;</td>
					<td><select name="cid">
							<%
									List ulist = (ArrayList) request.getAttribute("list");
									if (ulist != null && ulist.size() > 0) {
										for (int i = 0; i < ulist.size(); i++) {
											Company c = (Company) ulist.get(i);
								%>
							<option value="<%=c.getCid()%>">--<%=c.getCname()%>--
							</option>
							<%
									}
									}
								%>
					</select></td>
				</tr>
				<tr>
					<td align="right">单据编号:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="cno" id="cno"
						size="21" />
					</td>
				</tr>

				<tr>
					<td align="right">实收费用:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="ss" id="ss"
						size="21" />
					</td>
				</tr>
				<tr class="line_g hover_bg" bgcolor="lightblue">
					<td align="right">账单日期:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="ftime" id="ftime"
						size="21" />
					</td>
				</tr>
				<tr>
					<td align="right">预警日期:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="ytime" id="ytime"
						size="21" />
					</td>
				</tr>
				<tr class="line_g hover_bg" bgcolor="lightblue">
					<td align="right">备注:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="des" id="des"
						size="40" />
					</td>
				</tr>
				<tr align="center" class="line_g hover_bg" align="center"
					bgcolor="lightblue">
					<td colspan="2"><input type="submit" id="btn" value="新增" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
