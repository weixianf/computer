<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
		<script type="text/javascript" src="bootstrap-3.4.1-dist/js/bootstrap.js"></script>
		<link rel="stylesheet" href="bootstrap-3.4.1-dist/css/bootstrap.css" />
<script>
   
var str = '';
	 $(document).ready(function(){
		        var arr = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'];
		       str = '';
		        for(var i = 0 ; i < 4 ; i ++ ){
		            str += ''+arr[Math.floor(Math.random() * arr.length)];
		        }
		     var  value=document.getElementById("idtwo");
		     value.innerHTML=str;
		     
		}
	 
	 );
	 function onclickone(){
	var	 code=document.getElementById("code");

	if(code.value==str){
		alert("输入正确");
	}
	else {
		alert("验证码输入错误请重新输入");
		event.preventDefault();
		
	}
	 }
</script>
<style type="text/css">
#idtwo{
 width:100px; 
 height:47px;
 margin-left:155px;
 margin-top:-69px
}
button:last-child{width:100px;height:50px};
</style>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="<%=request.getContextPath() %>/manage/manager.do?method=query" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="name" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" id="code" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <div id="idone"  >  
                            <button id="idtwo" type="button"   name="yanzheng" class="btn btn-info"></button>
                                </div>                   
                        </div>
                    </div>
                </div>
                <div style="padding:30px;">
                <input type="submit" class="button button-block bg-main text-big input-big" value="登录" onclick="onclickone()">
                </div>
            </div>
            </form>          
        </div>
    </div>
</div>
</body>
</html>