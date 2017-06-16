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

<title>企业信息管理</title>
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
	$('#cname,#addr').validatebox( {
		required : true,
		missingMessage : '输入项不能为空!'

	});
	
	$('#xy').numberbox( {
		required : false,
		missingMessage : '输入必须是数字!',
		precision : 2
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
		<h2>企业信息管理</h2>
		<form id="myform1" method="post" action="CompanyServlet?method=query">
			<table width="50%" border="0">
				<tr align="center">
					<td>企业名称: <input type="text" name="cname" id="ccname"
						size="25"> &nbsp;&nbsp; <input type="submit" id="btn1"
						value="查询" />
					</td>
				</tr>

			</table>
		</form>
		<table width="60%" border="1" cellpadding="0" cellspacing="0"
			style="border-collapse: collapse; border-color: blue;">
			<tr class="line_g hover_bg" align="center" bgcolor="lightblue">
				<td width="5%">编号</td>
				<td width="15%">企业名</td>
				<td width="15%">企业性质</td>
				<td width="15%">企业地址</td>
				<td width="15%">信用额度(RMB)</td>
				<td width="15%">可用额度(RMB)</td>
				<td width="10%">操作</td>
			</tr>
			<%
					List list = (ArrayList) request.getAttribute("list");
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							Company c = (Company) list.get(i);
				%>
			<tr align="center">
				<td><%=i + 1%></td>
				<td><%=c.getCname() %></td>
				<td><%=c.getType() %></td>
				<td><%=c.getAddr() %></td>
				<td><%=c.getCxy() %></td>
				<td><%=c.getXy() %></td>
				<td align="center"><a
					href="CompanyServlet?cid=<%=c.getCid() %>&method=del">删除</a></td>
			</tr>
			<%
					}
					} else {
				%>
			<tr>
				<td colspan="7" style="height: 150px; text-align: center">
					尚没有添加企业信息！</td>
			</tr>
			<%
					}
				%>
		</table>
		<br> <br> <br>
		<form id="myform" method="post" action="CompanyServlet?method=save">
			<table width="40%" border="1" cellpadding="0" cellspacing="0"
				style="border-collapse: collapse; border-color: blue;">
				<tr class="line_g hover_bg" align="center" bgcolor="lightblue">
					<th colspan="2">企业信息新增</th>

				</tr>
				<tr>
					<td align="right">企业名称:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="cname" id="cname"
						size="21" />
					</td>
				</tr>
				<tr>
					<td align="right">企业类型:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <select name="type">
							<option value="国企">-----国企-----</option>
							<option value="外企">-----外企-----</option>
							<option value="个企">-----个企-----</option>
							<option value="事业单位">---事业单位---</option>
							<option value="股份制">----股份制----</option>
					</select>
					</td>
				</tr>
				<tr>
					<td align="right">企业地址:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="addr" id="addr"
						size="40" />
					</td>
				</tr>
				<tr>
					<td align="right">信用额度:&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp; <input type="text" name="xy" id="xy"
						size="40" />
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
