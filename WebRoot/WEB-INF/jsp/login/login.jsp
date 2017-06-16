<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="images/favicon.ico">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	$('#loginname,#password').validatebox( {
		required : true,
		missingMessage : '输入项不能为空!'

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
		<br /> <br />
		<%
				if (request.getAttribute("res") != null) {
			%>
		<font color="red"><%=request.getAttribute("res")%></font>
		<%
				}
			%>
		<br /> <br />
		<table border="1" bordercolor="#D2E9FF" width="625px"
			bgcolor="#F5F5F5"
			style="BORDER-LEFT-WIDTH: 0px; BORDER-COLLAPSE: collapse; BORDER-RIGHT-WIDTH: 0px;">
			<tr>
				<td height="126" background="images/logo.jpg" align="center"></td>
			</tr>
			<tr>
				<td align="center">
					<form action="LoginServlet" id="myform" method="post">
						<table height="205px" width="360px" bgcolor="#FFFAF0"
							style="margin-top: 40px; margin-bottom: 40px">
							<tr height="60">
								<th align="center" colspan="2" style="font: 22px;">
									往来款系统登录中心</th>
							</tr>
							<tr>
								<td align="right">用户名:&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp; <input type="text" name="loginname"
									id="loginname" size="21" /> <input type="hidden" name="method"
									value="login">
								</td>
							</tr>
							<tr>
								<td align="right">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;</td>
								<td>&nbsp;&nbsp; <input type="password" name="password"
									id="password" size="23" />
								</td>
							</tr>
							<!--<tr>
									<td align="right">
										角&nbsp;&nbsp;&nbsp;&nbsp;色:&nbsp;&nbsp;
									</td>
									<td>
										&nbsp;&nbsp;
										<select name="role">
											<option value="student">
												==学生==
											</option>
											<option value="teacher">
												==老师==
											</option>
										</select>
									</td>
								</tr>
								-->
							<tr>
								<td align="center" colspan="2"><input type="submit"
									value="登 录" id="btn" /> &nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" value="重 置" /></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
			<tr style="font-style: italic; font-size: 15px;">
				<td height="40" bgcolor="#FFFAF0" align="center"><font
					size="2px" color="blue">[友情提示]请用IE8、IE9显示效果最佳</font> <br></td>
			</tr>
		</table>
	</center>
</body>
</html>
