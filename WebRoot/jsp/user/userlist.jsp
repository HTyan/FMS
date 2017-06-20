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
				<td width="10%">编号</td>
				<td width="16%">登录名</td>
				<td width="16%">姓名</td>
				<td width="16%">电话</td>
				<td width="16%">年龄</td>
				<td width="16%">性别</td>
				<td width="10%">操作</td>
			</tr>
			<%
					List list = (ArrayList) request.getAttribute("ulist");
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							User m = (User) list.get(i);
				%>
			<tr align="center">
				<td><%=i + 1%></td>
				<td><%=m.getLoginname()%></td>
				<td><%=m.getUsername()%></td>
				<td><%=m.getTel()%></td>
				<td><%=m.getAge()%></td>
				<td><%=m.getGender()%></td>
				<td align="center"><a
					href="UserSevlet?uid=<%=m.getUid()%>&method=del">删除</a></td>
			</tr>
			<%
					}
					} else {
				%>
			<tr>
				<td colspan="4" style="height: 150px; text-align: center">
					尚没有添加用户信息！</td>
			</tr>
			<%
					}
				%>
		</table>
		<br> <br> <br>
		<form id="myform" method="post" action="UserSevlet?method=save">
			<table width="40%" border="1" cellpadding="0" cellspacing="0"
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
	</center>
</body>
</html>
