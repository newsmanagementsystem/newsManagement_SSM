<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加主题--管理后台</title>
<!-- 引入样式文件 -->
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<link href="../css/index.css" rel="stylesheet" type="text/css" />
<!-- 引入JS文件 -->
<script src="../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../js/layui/layui.all.js"></script>

</head>
<body>
	<div id="main">
		<!-- 引入页首 -->
		<div>
			<%@ include file="console_element/top.jsp"%>
		</div>
		<div id="opt_list">
			<iframe src="console_element/left.jsp" scrolling="no"
				frameborder="0" width="160px" height="300px"></iframe>
		</div>
		<div id="opt_area">
			<h1 id="opt_type">添加主题：</h1>
			<form action="/theme/addTheme" method="post" onsubmit="return check()">
				<p>
					<label> 主题名称 </label>
                    <input name="themeName" type="text" class="opt_input" id="themeName" />
				</p>
				<input id="submitButton" type="submit" value="提交" class="opt_sub" />
                <input type="reset" value="重置" class="opt_sub" />
			</form>
		</div>
		<div id="footer">
			<%@ include file="console_element/bottom.html"%>
		</div>
	</div>
</body>
<script>
    function check(){
        var themeName = document.getElementById("themeName");
        if(themeName.value == ""){
            layer.msg('主题名称不能为空！', {
                time: 2000
            });
            themeName.focus();
            return false;
        }
        return true;
    }
    // $(document).ready(function(){
    //     $("#submitButton").click(function(){
    //         if (check()) {
    //             alert("---------------------true----------------");
    //             var themeName = document.getElementById("themeName");
    //             $.ajax({
    //                 url: "/theme/addTheme",
    //                 type:"post",
    //                 async:true,
    //                 data:{
    //                     "themeName":themeName
    //                 },
    //                 dataType:"json",
    //                 success:function(result){
    //                     var count=result.data;
    //                     //console.log(res);
    //                     if(count>0){
    //                         layer.msg('添加成功！', {
    //                             time: 2000, //2s后自动关闭
    //                         });
    //                         window.location.href='admin/themeList';
    //                         return;
    //                     }
    //                     else  {
    //                         layer.msg('添加失败！', {
    //                             time: 2000, //2s后自动关闭
    //                         });
    //                     }
    //                 }
    //             });
    //         }
    //     });
    // });
</script>
</html>