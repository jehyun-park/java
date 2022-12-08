<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#registFormArea{
		width : 800px;
		margin : auto;
		border : 1px solid brown;
	}	
	h1{
		text-align: center;
		border-bottom: 3px double red;
	}
	table{
		width : 780px;
		text-align: center;
	}
	.td_left{
		width : 200px;
	}
	.td_right{
		width : 580px;
	}
</style>

</head>
<body>
	<section id = "registFormArea">
		<h1>새상품등록</h1>
		<form action="dogRegist.dog" name="myForm" method="POST" encType = "multipart/form-data">
		<table>
			<tr>
				<td class = "td_left"><label for = "dogKind">개품종 : </label></td>
				<td class = "td_right">
				<input type = "text" id = "dogKind" name = "dogKind"/>
				
				</td>
			</tr>
			<tr>
				<td class = "td_left"><label for = "dogPrice">개상품가격 : </label></td>
				<td class = "td_right"><input type = "NUMBER" id = "dogPrice" name = "dogPrice"/></td>
			</tr>
			<tr>
				<td class = "td_left"><label for = "dogImage">개상품이미지 : </label></td>
				<td class = "td_right"><input type = "file" id = "dogImage" name = "dogImage"/></td>
			</tr>
			<tr>
				<td class = "td_left"><label for = "dogCountry">개상품 원산지 : </label></td>
				<td class = "td_right"><input type = "text" id = "dogCountry" name = "dogCountry"/>
				</td>
			</tr>
			<tr>
				<td class = "td_left"><label for = "dogHeight">개상품신장 : </label></td>
				<td class = "td_right"><input type = "number" id = "dogHeight" name = "dogHeight"></td>
			</tr>
			<tr>
				<td class = "td_left"><label for = "dogWeight">개상품체중 : </label></td>
				<td class = "td_right"><input type = "number" id = "dogWeight" name = "dogWeight"></td>
			</tr>
			<tr>
				<td class = "td_left"><label for = "dogContent">개상품 설명: </label></td>
				<td class = "td_right"><textarea rows = "20" cols = "40"></textarea>  ></td>
			</tr>
			<tr>
				<td>
				
				</td>
			
			</tr>
			
			
			
			<tr>
				<td colspan = "2" style = "text-align:center">
					<input type = "submit" value = "상품등록"/>
				</td>
			</tr>
		</table>
		</form>
	</section>

</body>
</html>