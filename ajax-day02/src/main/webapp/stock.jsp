<%@page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<style>
		#d1 {
			
			width:480px;
			height:450;
			background-color:black;
			margin-left:350px;
			margin-top:20px;
			text-align:center;
			font-weight:bold;
		}
		
		#d2 {
			border:1px solid white;
			color:yellow;
			background-color:red;
			height:32px;
		}
		
		td {
			border:1px solid white;
		}
		table {
			color:white;
			font-style:italic;
			
			font-size:24px;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
	<script type="text/javascript">
		$(function(){
			//页面加载完成之后,每隔一段时间,执行quoto
			setInterval(quoto,5000);
			
		}); 
		
		function quoto() {
			//利用jquery提供的方法($.ajax)来向服务器发送异步请求
			$.ajax({
				"url":"quoto.do",//请求地址
				"type":"get",//请求类型(get,post)
				//"data":"uname=sally & age=22"//请求参数
				"dataType":"json",//服务器向浏览器返回的数据的类型(text,json,xml,html,script)
				"success":function(obj) {
					//处理服务器返回的数据
					/*
						obj是服务器返回的数据
						如果服务器返回的是json字符串,会自动转换成对应的javascript对象
					*/
					//更新表格
					$('#tb1').empty();
					for(i=0; i<obj.length; i++) {
						var s = obj[i];
						//向tbody中追加内容
						$('#tb1').append(
								'<tr><td>'+s.code
								+'</td><td>'+s.name
								+'</td><td>'+s.price
								+'</td></tr>');
					}
				},
				"error":function() {
					//服务器出错,在这儿处理
				}
			});
			
		}
	</script>
</head>
<body style="font-size:30px;">
	<div id="d1">
		<div id="d2">实时行情</div>
		<div id="d3">
			<table width="100%">
				<thead>
					<tr>
						<td>代码</td>
						<td>名称</td>
						<td>价格</td>
					</tr>
				</thead>
				<tbody id="tb1">
					
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>