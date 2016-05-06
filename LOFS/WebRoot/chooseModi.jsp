<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<style>
			
			#table1{
					border-spacing:0 8px;
			}
		</style>
		<script src="js/prototype-1.6.0.3.js"></script>
		<script>
			var arr = new Array();
			arr[0] = [new Option('--城市--','-1')];
			arr[1] = [new Option('--选择城市--','-1'),
			new Option('上饶','1'),
			new Option('南昌','2'),
			new Option('九江','3'),
			new Option('鹰潭','4'),
			new Option('赣州','5')];
			arr[2] = [new Option('--选择城市--','-1'),
			new Option('杭州','11'),
			new Option('玉环','12'),
			new Option('金花','13'),
			new Option('台州','14'),
			new Option('永康','13')];
			arr[3] = [new Option('--选择城市--','-1'),
			new Option('深圳','21'),
			new Option('广州','22'),
			new Option('汕头','23'),
			new Option('南雄','24')];
			
			function c(index){
				var city = document.getElementById('city');
				city.innerHTML = '';
				for(var i=0;i<arr[index].length;i++){
					city.options[i] = arr[index][i];
				}
			}
		</script>
	</head>
	<body onload="document['form1']['note'].focus();">
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
						详细资料修改
					</h1>
					<form action="chooseModi.do" method="post" name="form1">
						<table id="table1">
							<tr>
								<td>
									年龄:
								</td>
								<td>
									<select name="stature" style="width:155px;">
										<option value="0">10-20</option>
										<option value="1">20-30</option>
										<option value="2">30-40</option>
										<option value="3">40以上</option>
									</select>
								</td>
							</tr>
							
							
							<tr>
								<td>
									所在地区:
								</td>
								<td>
									<select id="p1" name="province" style="width:120px;" onchange="c(this.selectedIndex);">
										<option value="-1">--请选择省份--</option>
										<option value="0">江西</option>
										<option value="1">浙江</option>
										<option value="2">广东</option>
									</select>
									<select id="city" name="city" style="width:120px;">
										<option value="-1">--请选择城市--</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<input type="submit" value="提交" />
								</td>
							</tr>
						</table>
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
