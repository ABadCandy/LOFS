<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>jiaoyou</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
			a{	
				color:blue;
				text-decoration:none;
				font-size:15px;
			}
			a:hover{
				color:red;
				text-decoration:underline;
				font-size:15px;
			}
			.msg{
				width:500px;
				font-size:15px;
				font-weight:900;
				background-color:#FFEC8B;
				border:1px dotted #FF34B3;
			}
			
			#sxmsg{
				width:200px;
				font-size:15px;
				font-weight:900;
				background-color:#FFEC8B;
				border:1px dotted #FF34B3;
			}
			
			#lwmsg{
				width:200px;
				font-size:15px;
				font-weight:900;
				background-color:#FFEC8B;
				border:1px dotted #FF34B3;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
		<script>
/*			$(function(){
						
						setInterval(function(){
								$.ajax({
										url:"receive",
										type:"post",
										data:{'receiverId':${user.id}},
										dataType:'json',
										success:function(data,status){
											for(i=0;i<data.length;i++){
												var obj = data[i];
												$('#m1').append("<div class='msg'></div>");
												$('.msg').html("用户" + obj.sendName + " 给您打了一个招呼:" + obj.content).slideDown(1200);
												$('.msg').click(function(){
													$(this).remove();
												});
										}//end for
										}
									});//end ajax
						},10000);
						
						$('#sx').click(function(){
							$(this).after("<div id='sxmsg'></div>");
							$('#sxmsg').html('暂时没有邮件').fadeOut(2000);
						});
						
						$('#lw').click(function(){
							$(this).after("<div id='lwmsg'></div>");
							$('#lwmsg').html('暂时没有礼物').fadeOut(2000);
						});
				});
	*/	</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
	<div id="rightheader">
		<p>
		<br/>
		</p>
	</div>
	<div id="topheader">
		<h1 id="title">
			<a href="#">欢迎${user.username}来到“体育赛事直播”平台</a>
		</h1>
	</div>
	<div id="navigation">
	</div>
</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						<img src="img/sx.gif"/><a id="sx" href="javascript:;" onclick="sx();">已发贴</a>
					</h1>
					<h1>
						<img src="img/lwx.gif"/><a id="lw" href="javascript:;" onclick="lw();">消息</a>
					</h1>
					<h1>
						已有用户
					</h1>
					<div id="m1"></div>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								用户名
							</td>
							<td>
								性别
							</td>
							<td>
								年龄
							</td>
							<td>
								
							</td>
						</tr>
						<c:forEach var="user" items="${users}" varStatus="status">
							<tr class="row${status.index%2+1}">
								<td>${user.id}</td>
								<td>${user.username}</td>
								<td>
								<c:choose>
									<c:when test="${user.gendar=='m'}">男</c:when>
									<c:when test="${user.gendar=='f'}">女</c:when>
									<c:otherwise>保密</c:otherwise>
								</c:choose>
								</td>
								<td>${user.age}</td>
								<td><a href="detail.do?id=${user.id}">详细</a></td>
							</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="退出系统" onclick="location='logout.do'"/>
					</p>
				</div>
			</div>
			<div id="footer">
	<div id="footer_bg">
			Copyright (C) 体育直播 2004-2008, All Rights Reserved
			京ICP证041189号
	</div>
</div>
		</div>
	</body>
</html>
