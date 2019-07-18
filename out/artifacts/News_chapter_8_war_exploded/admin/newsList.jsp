<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑主题--管理后台</title>
<!-- 引入样式文件 -->
<link href="./css/admin.css" rel="stylesheet" type="text/css" />
<link href="./css/index.css" rel="stylesheet" type="text/css" />
<!-- 引入js -->
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/layui/layui.all.js"></script>

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

		<!-- 插入中间部分 -->
		<div id="opt_area">
			<ul class="classlist">
				<c:forEach items="${pB.list}" var="news">
					<li><p style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;width: 320px"><a>${news.newsTitle}</a></p>
					<p >创建时间:${news.newsModifydate}</p>
					<span> <p style="width: 80px">作者：${news.newsAuthor}</p>
						&#160;&#160;&#160;&#160; <a href="/news/newsModify?nid=${news.newsId}">修改</a>
						&#160;&#160;&#160;&#160; &nbsp; <a href="/news/deleteNews?nid=${news.newsId}">删除</a> </span> </li>
				</c:forEach>
			</ul>

			<tr>
				<td colspan="100" align="left">
					<div id="page">
						<input type="hidden" id="hidecP" name="currentPage" value="${pB.currentPage }" />
						第${pB.currentPage } /  ${pB.totalPage }页
						&nbsp;&nbsp;&nbsp;
						每页显示${pB.pageSize }条
						&nbsp;&nbsp;&nbsp;
						总共${pB.totalCount }条
						&nbsp;&nbsp;&nbsp;
						<c:if test="${pB.currentPage !=1 }">
							<a href="/news/listNews?currentPage=1">首页</a>
							| <a href="/news/listNews?currentPage=${pB.currentPage -1 }">上一页</a>
						</c:if>
						<c:forEach var="i" begin="1" end="${pB.totalPage }">
							<c:if test="${pB.currentPage != i }">
								<a href="/news/listNews?currentPage=${i }">${i }</a>
							</c:if>
							<c:if test="${pB.currentPage == i }">
								${i }
							</c:if>
						</c:forEach>
						<c:if test="${pB.currentPage != pB.totalPage }">
							<a href="/news/listNews?currentPage=${pB.totalPage }">尾页</a>
							| <a href="/news/listNews?currentPage=${pB.currentPage +1 }">下一页</a>
						</c:if>
					</div>
				</td>
			</tr>
		</div>
		<div id="footer">
			<%@ include file="console_element/bottom.html"%>
		</div>
	</div>
</body>
<script type="text/javascript">

</script>
</html>
