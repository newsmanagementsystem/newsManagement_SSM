<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入JSTL标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 设置文件路径 -->
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>新闻中国</title>
  <link href="/css/main.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="<%=basePath%>css/index.css" />
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
          用户：<b>${sessionScope.login }</b>&nbsp;&nbsp;&nbsp;&nbsp;欢迎登陆！&nbsp;&nbsp;<a href="/user/logout">退出</a>
        </p>
      </c:otherwise>
    </c:choose>

  </div>
  <c:choose>
    <c:when test="${empty sessionScope.login }">
      <div id="register" class="register">
        <input type="button" class="login_sub" value="注册"
               onclick="location.href='/regis.jsp'" /> <img
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
      <ul class="class_date">
        <!-- 循环输出新闻主题 -->
        <c:choose>
          <c:when test="${themeList == null }">
            <p>当前暂无新闻分类</p>
          </c:when>
          <c:when test="${empty themeList }">
            <p>当前暂无新闻主题</p>
          </c:when>
          <c:otherwise>
            <c:forEach items="${themeList }" var="aTheme"
                       varStatus="aThemeStatus">
              <c:if test="${aThemeStatus.count % 10 == 1 }">
                <li id='class_month'>
              </c:if>
              <a href="<%= path %>/index/newsList?themeID=${aTheme.themeID }"><b>${aTheme.themeName }</b></a>
              <c:if test="${aThemeStatus.count % 10 == 0 }">
                </li>
              </c:if>
              <c:set var="totalNum" value="${aThemeStatus.count }"></c:set>
            </c:forEach>
            <c:if test="${totalNum % 10 != 0 }">
              </li>
            </c:if>
          </c:otherwise>
        </c:choose>
      </ul>
      <ul class="classlist">
        <!-- 循环输出新闻列表 -->
        <c:choose>
          <c:when test="${newsList == null }">
            <p>当前暂无新闻</p>
          </c:when>
          <c:when test="${empty newsList }">
            <p>当前暂无新闻</p>
          </c:when>
          <c:otherwise>
            <c:forEach items="${newsList }" var="aNew"
                       varStatus="aNewStatus">
              <li><a href="<%= path %>/index/readNewsId?newsId=${aNew.newsId}">${aNew.newsTitle }</a><span>${aNew.newsModifydate }</span></li>
              <c:if test="${aNewStatus.count % 5 == 0 }">
                <li class='space'></li>
              </c:if>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
    <%@ include file="index_rightbar.jsp"%>
  </div>
</div>
<%@ include file="index_bottom.html"%>
<%--<img src="/pic/test.png" alt="加载失败">--%>
</body>
</html>