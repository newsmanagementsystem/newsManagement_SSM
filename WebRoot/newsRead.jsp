<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中国</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/css/index.css" />
<script src="/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="/js/wySilder.min.js" type="text/javascript"></script>
<script src="/js/silder.js"></script>
<script src="/js/login.js"></script>
<script src="/js/layui/layui.all.js"></script>
<script>
	function exit(){
		window.open("/index.jsp", "_top");
	}
</script>
</head>
<body>
	<div id="header">
		<div id="top_login">
			<!-- 根据登陆情况显示信息 -->
			<c:choose>
				<c:when test="${empty sessionScope.login }">
					<form id="login" method="post">
						<label>登录名</label> <input type="text" name="username"
							id="username" value="" class="login_input" /> <label>密&#160;&#160;码</label>
						<input type="password" name="password" id="password" value=""
							class="login_input" /> <input type="button" id="loginbtn"
							class="login_sub" value="登录" />
					</form>
				</c:when>
				<c:otherwise>
					<p id="welcomeInfo">
						用户：<b>${sessionScope.login }</b>&nbsp;&nbsp;&nbsp;&nbsp;欢迎登陆！&nbsp;&nbsp;<a
							href="/user/logout">退出</a>
					</p>
				</c:otherwise>
			</c:choose>

		</div>
		<c:choose>
			<c:when test="${empty sessionScope.login }">
				<div id="register" class="register">
					<input type="button" class="login_sub" value="注册"
						onclick="location.href='regis.jsp'" /> <img
						src="/images/friend_logo.gif" alt="Google" id="friend_logo" />
				</div>
			</c:when>
		</c:choose>

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
	<div id="container">
		<%@ include file="index_sidebar.jsp"%>
		<div class="main">
			<div class="class_type">
				<img src="/images/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content">
				<ul class="classlist">
					<table width="80%" align="center" >
						<tr width="100%">
							<td colspan="2" align="center">${news.newsTitle}</td>
						</tr>
						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td align="center">作者：${news.newsAuthor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
							<td align="left">发布时间：
									${news.newsCreatedate} </td><!--pattern="yyyy-MM-dd HH:mm:ss"-->
						</tr>
						<tr>
							<td colspan="2" align="center"></td>
						</tr>
						<tr>
							<td colspan="2">${news.newsContent}</td>
						</tr>

						<tr>
							<td colspan="2"><hr /></td>
						</tr>
						<tr>
							<td colspan="2"><img src="${news.newsPicpath}" alt="图片未加载" width="370"></td>

						</tr>
					</table>
				</ul>
			</div>
			<%@ include file="index_rightbar.jsp"%>
		</div>
	</div>
</body>
</html>