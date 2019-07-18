<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>添加新闻--管理后台</title>
  <link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="main">
  <!-- 引入页首 -->
  <div>
    <%@ include file="/admin/console_element/top.jsp"%>
  </div>
  <!-- 插入左边栏 -->
  <div id="opt_list">
    <iframe src="/admin/console_element/left.jsp" scrolling="no"
            frameborder="0" width="160px" height="300px"></iframe>
  </div>

  <div id="opt_area">
    <h1 id="opt_type"> 添加新闻： </h1>
    <form action="/news/addNews" method="post" >
      <p>
        <label> 主题 </label>
        <select name="ntid">
          <c:forEach items="${requestScope.themeList}" var="topic">
            <option value="${topic.themeID}">${topic.themeName}</option>
          </c:forEach>
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" class="opt_input" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" class="opt_input" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" cols="40" rows="3"></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" cols="70" rows="10"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input" />
      </p>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
    </form>
  </div>
</div>
<div id="footer">
  <%@ include file="console_element/bottom.html" %>
</div>
</body>
</html>
