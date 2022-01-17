<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网吧后台管理系统</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/pintuer.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css">
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<body style="background-color: #f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1>
		<img src="<%=request.getContextPath() %>/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l">
			<a class="button button-little bg-green" href="" > 前台首页</a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="button button-little bg-red" href="<%=request.getContextPath()%>/index.jsp">退出登录</a>
  </div>
</div>

<div class="leftnav">

  <div class="leftnav-title">
		<strong><span class="icon-list"></span>菜单列表</strong>
  </div>
  
  <h2>
		<span class="icon-user"></span>会员管理</h2>
  <ul>
    <li><a href="" target="right">会员添加</a></li>
    <li><a href="" target="right">会员删除</a></li>
    <li><a href="" target="right">会员修改</a></li>
    <li><a href="" target="right">会员查询</a></li>
  </ul> 
    
  <h2>
		<span class="icon-user"></span>电脑管理</h2>
  <ul>
    <li><a href="" target="right">添加电脑</a></li>
    <li><a href="" target="right">删除电脑</a></li>
    <li><a href="" target="right">修改电脑</a></li>
    <li><a href="" target="right">查询电脑</a></li>
  </ul> 
  
  <h2>
		<span class="icon-user"></span>上网管理</h2>
  <ul>
    <li><a href="" target="right">会员上机</a></li>
    <li><a href=""  target="right">会员下机</a></li>
	<li><a href=""  target="right">余额查询</a></li>
	<li><a href=""  target="right">费用结算</a></li>
  </ul> 
</div>
<script type="text/javascript">
	$(function() {
		$(".leftnav h2").click(function() {
			$(this).next().slideToggle(200);
			$(this).toggleClass("on");
		})
		$(".leftnav ul li a").click(function() {
			$("#a_leader_txt").text($(this).text());
			$(".leftnav ul li a").removeClass("on");
			$(this).addClass("on");
		})
	});
</script>
<ul class="bread">
  <li><a href="<%=request.getContextPath()%>/manage/manager/infor.jsp" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="<%=request.getContextPath()%>/manage/manager/infor.jsp" name="right"
			width="100%" height="100%"></iframe>
</div>
</body>
</body>

</html>