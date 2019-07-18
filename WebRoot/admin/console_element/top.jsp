<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/css/admin.css" rel="stylesheet" type="text/css" />
	<link href="/css/index.css" rel="stylesheet" type="text/css" />
	<!-- 引入脚本文件 -->
	<script src="/js/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="/js/wySilder.min.js" type="text/javascript"></script>
	<script src="/js/silder.js"></script>
</head>
<body>
<div id="header">
	<div id="welcome">
		欢迎管理员<%=session.getAttribute("login")%>使用新闻管理系统！&nbsp;&nbsp;<a href="/user/logout">退出</a>
	</div>
	<div id="silder" class="js-silder">
		<div class="silder-scroll">
			<div class="silder-main">
				<div class="silder-main-img">
					<img src="/images/d2.png" alt="">
				</div>
				<div class="silder-main-img">
					<img src="/images/d1.png" alt="">
				</div>
			</div>
		</div>
	</div>
</div>
<div id="admin_bar">
	<div id="status"></div>
	<div id="channel"> </div>
</div>

</body>
</html>
