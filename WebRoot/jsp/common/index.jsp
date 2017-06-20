<%@ page language="java" import="java.util.*,com.dyc.po.User"
	pageEncoding="utf-8"%>
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

		<title>财务管理系统平台</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</HEAD>
	<FRAMESET id=index border=0 frameSpacing=0 rows=120,* frameBorder=no>
		<FRAME id=topFrame name=topFrame src="jsp/common/top.jsp" noResize
			scrolling=no>
		<FRAMESET border=0 frameSpacing=0 frameBorder=no cols=20%,*>

			<FRAME id=leftFrame name=leftFrame src="jsp/common/left.jsp" noResize
				style="overflow: auto;">

			<FRAME id=mainFrame name=mainFrame src="jsp/common/main.jsp" noResize>
		</FRAMESET>
	</FRAMESET>
	<noframes></noframes>
</HTML>

