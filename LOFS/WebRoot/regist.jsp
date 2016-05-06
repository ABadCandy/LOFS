<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
			.s1{
				font-style:italic;
				font-size:15px;
			}
    
</style>
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>

	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
				<div id="rightheader">
					<p>
						<c1:date/>
					<br/>
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">体育直播</a>
					</h1>
				</div>
				<div id="navigation">
				</div>
			</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="regist.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<% 
									String exist=(String)request.getAttribute("exist");
								%>
								<%
									String name_err=(String)request.getAttribute("name_err");
								%>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" id="username" name="username"/>
									
								</td>
								
								<td style="font-size:15px;color:red;">
								<%=exist==null?"":exist%>
								<%=name_err==null?"":name_err%>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
							<%
									String psw1_err=(String)request.getAttribute("psw1_err");
								%>
								<%
									String psw2_err=(String)request.getAttribute("psw2_err");
								%>
								<td valign="middle" align="right">
									密码:
								</td>
								
							  	<td valign="middle" align="left"> 
									<input type="password" class="inputgri"id="psw" name="pwd" />
															</td> 
															<td style="font-size:15px;color:red;">
																<%=psw1_err==null?"":psw1_err%>
									<%=psw2_err==null?"":psw2_err%>
															</td>
							</tr>
								<tr>
							<%
									String psw_err=(String)request.getAttribute("psw_err");
								%>
								
								<td valign="middle" align="right">
									确认密码:
								</td>
								
							  	<td valign="middle" align="left"> 
									<input type="password" class="inputgri" name="psw" />
															</td> 
															<td style="font-size:15px;color:red;">
																<%=psw_err==null?"":psw_err%>
															</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="gendar" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="gendar" value="f"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									电话:
								</td>
								<td valign="middle" align="left">
									<input type="text" name="phone" id="tel" class="inputgri"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码:</td>
								<td valign="middle" align="left">
								<input type="text" class="inputgri" id="number" name="number"/>
								<span id="number_msg" class="s1"></span>
								</td>
								<%
									String checkcode_err=(String)request.getAttribute("checkcode_err");
								%>
								<td style="font-size:15px;color:red;">
								<%=checkcode_err==null?"":checkcode_err%>
								</td>
							</tr>
							<tr>
								<td colspan="2" valign="middle" align="center">
									<img id="num" src="checkCode" /></td>
							</tr>
							<tr>
								<td colspan="2" valign="middle" align="center">
									<a href="javascript:;" onclick="document.getElementById('num').src = 'checkCode?'+(new Date()).getTime()">看不清？换一张</a>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确认 &raquo;" />
						</p>
					</form>
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
