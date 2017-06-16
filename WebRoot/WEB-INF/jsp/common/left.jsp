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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML>
<HEAD>
<base href="<%=basePath%>">
<title>财务管理系统平台</title>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="js/tree_themes/SimpleTree.css" />
<script type="text/javascript" src="js/jquery-1.6.min.js">
</script>
<script type="text/javascript" src="js/SimpleTree.js">
</script>
<script type="text/javascript">
$(function() {
	$(".st_tree").SimpleTree();
});
</script>
</HEAD>
<BODY
	style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(images/bg.gif); BACKGROUND-REPEAT: repeat-x">
	<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
		<TBODY>
			<TR>
				<TD width=10 height=29><IMG src="images/bg_left_tl.gif">
				</TD>
				<TD
					style="FONT-SIZE: 18px; BACKGROUND-IMAGE: url(images/bg_left_tc.gif); COLOR: WHITE; FONT-FAMILY: system; text-align: center;">
					账务管理系统</TD>
				<TD width=10><IMG src="images/bg_left_tr.gif"></TD>
			</TR>
			<TR>
				<TD style="BACKGROUND-IMAGE: url(images/bg_left_ls.gif)"></TD>
				<TD
					style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white"
					vAlign=top>
					<div class="st_tree" style="min-height: 400px">

						<!-- 一级标题：end -->
						<ul>
							<li>公司信息管理</li>
							<!-- 二级标题：start -->
							<ul show="true">
								<li><a href="CompanyServlet?method=query" target=mainFrame>
										公司信息管理</a></li>

							</ul>
							<!-- 二级标题：end -->
						</ul>
						<ul>
							<li>单据录入模块</li>
							<!-- 二级标题：start -->
							<ul show="true">
								<li><a href="FinanceServlet?method=queryC" target=mainFrame>单据录入模块
								</a></li>
								<li><a href="FinanceServlet?method=queryD" target=mainFrame>货款管理模块
								</a></li>

							</ul>
							<!-- 二级标题：end -->
						</ul>
						<ul>
							<li>账务分析模块</li>
							<!-- 二级标题：start -->
							<ul show="true">
								<li><a href="FinanceServlet?method=query" target=mainFrame>账务分析模块</a>
								</li>

							</ul>
							<!-- 二级标题：end -->
						</ul>

						<ul>
							<li>期末处理模块</li>
							<!-- 二级标题：start -->
							<ul show="true">
								<li><a href="FinanceServlet?method=report" target=mainFrame>报表管理管理</a>
								</li>

							</ul>
							<!-- 二级标题：end -->
						</ul>
						<!-- 其它 -->
						<%
								if ("superAdmin".equalsIgnoreCase(user.getRole())) {
							%>
						<ul>
							<li>用户信息管理</li>
							<!-- 二级标题：start -->
							<ul show="true">
								<li><a href="UserSevlet?method=query" target=mainFrame>用户信息管理
								</a></li>

							</ul>
							<!-- 二级标题：end -->
						</ul>

						<%
								}
							%>
					</div>

				</TD>
				<TD style="BACKGROUND-IMAGE: url(images/bg_left_rs.gif)"></TD>
			</TR>
			<TR>
				<TD width=10><IMG src="images/bg_left_bl.gif"></TD>
				<TD style="BACKGROUND-IMAGE: url(images/bg_left_bc.gif)"></TD>
				<TD width=10><IMG src="images/bg_left_br.gif"></TD>
			</TR>
		</TBODY>
	</TABLE>
</BODY>
</HTML>
