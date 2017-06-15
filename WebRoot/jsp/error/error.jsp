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

<title>My JSP 'error.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<TABLE cellSpacing=0 cellPadding=0 width=540 align=center border=0>
		<TBODY>
			<TR>
				<TD vAlign=top height=270>
					<DIV align=center>
						<BR> <IMG height=211 src="images/error.gif" width=329>
						<BR> <BR>
						<TABLE cellSpacing=0 cellPadding=0 width="80%" border=0>
							<TBODY>
								<TR>
									<TD><FONT class=p2>&nbsp;&nbsp;&nbsp; <FONT
											color=#ff0000><IMG height=13 src="images/emessage.gif"
												width=12>&nbsp;很抱歉，系统出现异常！</FONT>
									</FONT></TD>
								</TR>
								<TR>
									<TD height=5></TD>
								</TR>
								<TR>
									<TD>
										<P>
											<FONT color=#000000><BR>请与管理员联系或者进行其它操作...</FONT>
										</P>
									</TD>
								</TR>
								<TR>
									<TD height=15></TD>
								</TR>
							</TBODY>
						</TABLE>
					</DIV>
				</TD>
			</TR>
			<TR>
				<TD height=10></TD>
			<TR>
				<TD align=middle>
					<CENTER>
						<TABLE cellSpacing=0 cellPadding=0 width=480 border=0>
							<TBODY>
								<TR>
									<TD width=6><IMG height=26 src="images/left.gif" width=7>
									</TD>
									<TD background=images/bg1.gif>
										<DIV align=center>
											<FONT class=p6><A href="jsp/common/main.jsp"
												target="mainFrame">返回首页</A>
												&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; <A
												href="javascript:history.go(-1)">返回出错页</A>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
												<A href="LoginServlet?method=logout" target="_top">退出系统</A>
											</FONT>
										</DIV>
									</TD>
									<TD width=7><IMG src="images/right.gif"></TD>
								</TR>
							</TBODY>
						</TABLE>
					</CENTER>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</body>
</html>
