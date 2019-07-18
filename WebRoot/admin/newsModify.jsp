<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>编辑新闻--管理后台</title>
    <link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 添加新闻导航栏 -->
<div>
    <%-- <%@ include file="admin/console_element/top.jsp" %>--%>
    <iframe src="<%=basePath %>admin/console_element/top.jsp" scrolling="no" frameborder="0" width="100%"></iframe>
</div>
<div id="admin_bar">
    <div id="status">管理员： 登录  &#160;&#160;&#160;&#160;<a href="#">login out</a></div>
    <div id="channel"> </div>
</div>
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
        <h1 id="opt_type"> 编辑新闻： </h1>
        <form action="/news/updateNews?nid=${news.newsId}"
              method="post"  onsubmit="return check()">
            <p>
                <label> 主题 </label>
                <select name="ntid">
                    <c:forEach items="${requestScope.themeList}" var="topic">
                        <c:choose>
                            <c:when test="${news.themeId == topic.themeID}">
                                <option value="${topic.themeID}" selected="selected">${topic.themeName}</option>
                            </c:when>
                            <c:otherwise><option value='${topic.themeID}'>${topic.themeName}</option></c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label> 标题 </label>
                <input name="ntitle" id="ntitle" type="text" class="opt_input" value="${news.newsTitle}"/>
            </p>
            <p>
                <label> 作者 </label>
                <input name="nauthor" id="nauthor" type="text" class="opt_input" value="${news.newsAuthor}"/>
            </p>
            <p>
                <label> 摘要 </label>
                <textarea name="nsummary" id="nsummary" cols="40" rows="3">${news.newsSummary}</textarea>
            </p>
            <p>
                <label> 内容 </label>
                <textarea name="ncontent" id="ncontent" cols="70" rows="10">${news.newsContent}</textarea>
            </p>
            <p>
                <label> 上传图片 </label>
                <input name="file" id="file" type="file" class="opt_input" />
            </p>
            <input type="submit" value="提交" class="opt_sub" />
            <input type="reset" value="重置" class="opt_sub" />
        </form>

    </div>
</div>
<%--
	request.removeAttribute("news");
	request.removeAttribute("topics");
--%>
<%@ include file="console_element/bottom.html" %>
</body>

<script type="text/javascript">
    function check(){
        var ntitle = document.getElementById("ntitle");
        var nauthor = document.getElementById("nauthor");
        var nsummary = document.getElementById("nsummary");
        var ncontent = document.getElementById("ncontent");

        if(ntitle.value == ""){
            alert("标题不能为空！！");
            ntitle.focus();
            return false;
        }else if(nauthor.value == ""){
            alert("作者不能为空！！");
            nauthor.focus();
            return false;
        }else if(nsummary.value == ""){
            alert("摘要不能为空！！");
            nsummary.focus();
            return false;
        }else if(ncontent.value == ""){
            alert("内容不能为空！！");
            ncontent.focus();
            return false;
        }
        return true;
    }
</script>
</html>