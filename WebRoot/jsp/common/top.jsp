<%@ page language="java" import="java.util.*,com.dyc.po.User"
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
<HTML>
<HEAD>
<base href="<%=basePath%>">

<title>账务管理系统平台</title>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
* {
	FONT-SIZE: 12px;
	COLOR: white
}

#logo {
	COLOR: white
}

#logo A {
	COLOR: white
}

FORM {
	MARGIN: 0px
}
</STYLE>
<SCRIPT src="js/Clock.js" type=text/javascript></SCRIPT>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY
	style="BACKGROUND-IMAGE: url(images/bg.gif); MARGIN: 0px; BACKGROUND-REPEAT: repeat-x">
	<form id="form1">
		<DIV id=logo
			style="BACKGROUND-IMAGE: url(images/logo.png); BACKGROUND-REPEAT: no-repeat">
			<DIV
				style="PADDING-RIGHT: 50px; BACKGROUND-POSITION: right 50%; DISPLAY: block; PADDING-LEFT: 0px; BACKGROUND-IMAGE: url(images/bg_banner_menu.gif); PADDING-BOTTOM: 0px; PADDING-TOP: 3px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 30px; TEXT-ALIGN: right">

				修改密码 <IMG src="images/menu_seprator.gif" align=absMiddle> 返回首页
				<IMG src="images/menu_seprator.gif" align=absMiddle> <A
					id=HyperLink3 href="LoginServlet?method=logout" target="_top">退出系统</A>
			</DIV>
			<DIV style="DISPLAY: block; HEIGHT: 54px"></DIV>
			<DIV
				style="BACKGROUND-IMAGE: url(images/bg_nav.gif); BACKGROUND-REPEAT: repeat-x; HEIGHT: 30px">
				<TABLE cellSpacing=0 cellPadding=0 width="100%">
					<TBODY>
						<TR>
							<TD>
								<DIV>
									<IMG src="images/nav_pre.gif" align=absMiddle> 欢迎&nbsp<%=user.getRole()%>:<%=user.getLoginname()%>
									<SPAN id=lblBra>&nbsp;登录</SPAN>

								</DIV>
							</TD>
							<TD align=right width="70%"><SPAN
								style="PADDING-RIGHT: 50px"><A
									href="javascript:history.go(-1);"><IMG
										src="images/nav_back.gif" align=absMiddle border=0>后退</A> <A
									href="javascript:history.go(1);"><IMG
										src="images/nav_forward.gif" align=absMiddle border=0>前进</A>
									<A href="http://fanyi.baidu.com/#auto/zh/" target=mainFrame><IMG
										src="images/nav_help.gif" align=absMiddle border=0>在线翻译</A>
									<IMG src="images/menu_seprator.gif" align=absMiddle> <SPAN
									id=clock></SPAN> </SPAN></TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</DIV>
		<SCRIPT type=text/javascript>
    var clock = new Clock();
    clock.display(document.getElementById("clock"));
</SCRIPT>
	</form>
</BODY>
</HTML>
