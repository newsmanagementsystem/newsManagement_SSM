
//页面加载完毕后执行
$(document).ready(function(){
    //用户名输入框绑定事件
    $("#loginbtn").click(function(){
        if(check()==-1){
            alert("请输入用户名!");
            return false;
        }else if(check()==-2){
            alert("请输入密码!");
            return false;
        }else{
            //得到输入框的值
            var $name = $("#username").val();
            var $pass = $("#password").val();
            //光标离开，ajax发送请求
            $.ajax({
                url:"/user/login",
                type:"post",
                async:true,
                data:{"userName":$name,
                    "userPassword":$pass },
                dataType:"json",
                success:function(res){
                    if(res.userName==""){
                        layer.msg('此用户不存在！', {
                            time: 2000, //2s后自动关闭
                        });
                        $("#username").val("");
                        $("#password").val("");
                        return false;
                    }
                    else if($pass==res.userPassword){
                        //判断是否为管理员
                        if(res.userFlag==1){
                            window.location.href='/admin/admin.jsp';
                            layer.msg('管理员'+$name+'登录成功！', {
                                time: 2000, //2s后自动关闭
                            });
                            return false;
                        }else{
                            layer.msg('普通用户'+$name+'登录成功！', {
                                time: 2000, //2s后自动关闭
                            });
                            location.reload();
                            return ;//普通用户在当前页面
                        }
                    }else{
                        layer.msg('密码错误！', {
                            time: 2000, //2s后自动关闭
                        });
                        $("#password").val("");
                        return ;
                    }
                    //alert("1111111111111111111111111111111");
                },
                error:function(data){
                    alert("请求错误");
                    return ;
                }
            });
            return false;
        }
    });
});

function check(){

    if(login.username.value==""){
        login.username.focus();
        return -1;
    }else if(login.password.value==""){
        login.password.focus();
        return -2;
    }else{
        return true;
    }
}
