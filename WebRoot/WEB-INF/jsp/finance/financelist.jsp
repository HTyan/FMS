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

<title>财务预警管理</title>
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
	$('#ftime,#ytime').datebox( {
		//missingMessage : '日期不能为空!',
			required : false
		});

});
</script>
</head>
<body>
	<center>
		<h2>财务预敬管理</h2>
		<form id="myform1" method="post" action="FinanceServlet?method=query">
			<table width="80%" border="0">
				<tr align="center">
					<td>企业名称: <select name="cid">
							<option value="<%=0%>">--全部--</option>
							<%
									List ulist = (ArrayList) request.getAttribute("clist");
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
					</select> &nbsp;&nbsp; 开始日期： <input type="text" name="ftime" id="ftime"
						size="21" /> &nbsp;&nbsp; 结束日期： <input type="text" name="ytime"
						id="ytime" size="21" /> &nbsp;&nbsp; <input type="submit"
						id="btn1" value="查询" />
					</td>
				</tr>

			</table>
		</form>
		<table width="80%" border="1" cellpadding="0" cellspacing="0"
			style="border-collapse: collapse; border-color: blue;">
			<tr class="line_g hover_bg" align="center" bgcolor="lightblue">
				<td width="10%">单号</td>
				<td width="20%">单号名称</td>
				<td width="10%">应收费用</td>
				<td width="10%">实收费用</td>
				<td width="10%">账单日期</td>
				<td width="10%">预警日期</td>
				<td width="10%">状态</td>
			</tr>
			<%
					List list = (ArrayList) request.getAttribute("list");
					if (list != null && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							FinanceInfo f = (FinanceInfo) list.get(i);
				%>
			<tr align="center" <%if(f.getFlag()==1){%> bgcolor="pink" <%} %>>
				<td><%=f.getCno()%></td>
				<td><%=f.getFname()%></td>
				<td><%=f.getYishou()%></td>
				<td><%=f.getSishou()%></td>
				<td><%=f.getFtime()%></td>
				<td><%=f.getYtime()%></td>
				<td>
					<%
							if (f.getFlag() == 0) {
						%> <IMG src="images/120.png"> <%
							} else {
						%> <IMG src="images/119.png"> <%
							}
						%>
				</td>
			</tr>
			<%
					}
					} else {
				%>
			<tr>
				<td colspan="4" style="height: 150px; text-align: center">
					尚没有费用信息！</td>
			</tr>
			<%
					}
				%>
		</table>

	</center>
</body>
</html>
