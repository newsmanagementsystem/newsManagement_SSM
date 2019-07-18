<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中国</title>
<style type="text/css">
#title {
	text-align: center;
	margin: 20% 28%;
}
p {
	font-size: 30px;
	font-weight: bold;
}
#sureButton{
	width: 100px;
	height: 40px;
	font-size: 15px;
	background-color: #00FF7F;
}
</style>
</head>
<body>
	<div id="title">
		<p>第7组新闻发布系统</p>
		<form action="/index/main" method="get">
			<input id="sureButton" type="submit" value="点击进入" />
		</form>
	</div>
	
</body>
</html>