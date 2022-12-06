<%@page import="java.util.ArrayList"%>
<%@page import="vo.CartVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	ArrayList<CartVO> cartList = (ArrayList<CartVO>)request.getAttribute("cartList");
	int totalMoney = (int)request.getAttribute("totalMoney");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#cartListArea{
	width: 620px;
	margin : auto;
	border: 1px solid red;
}
table{
	width: 600px;
	margin: auto;
	text-align: center;
}
h1{
	text-align: center;
}
#tr_title{
	background: skyblue;
}
.cartProductImage{
	width: 70px;
	height: 70px;
}
.upDownImage{
	width:15px;
	height:15px;
	border : none;
}

</style>
<script>
	function checkQty(dogId, qty){
		if(qty != 1){
			location.href = "dogCartQtyDown.dog?dogId=" + dogId;
		}
	}
	function checkAll(){
		var allCheck = document.getElementById("allCheck");
		var delete1 = document.myForm.delete1;
		
		//checkbox�� üũ���� ���� ������ �ִ� �Ӽ��� checked��
		if(delete1.length == undefined){
			delete1.checked = allCheck.checked;
		}
		else{
			for(i = 0; i < delete1.length; i++){
				delete1[i].checked = allCheck.checked;
			}
		}
		
	}
</script>
</head>
<body>
	<section id = "cartListArea">
		<%
			if(cartList == null || cartList.size() == 0){
		%>
			<h1>��ٱ��Ͽ� ��� ��ǰ�� �����ϴ�.</h1>
		<%
			} else{
		%>
			<h1>��ٱ��� ��� <a href = "dogList.dog">���ΰ���ϱ�</a></h1>
			<form action="dogCartRemove.dog" method = "POST" name = "myForm">
				<table>
					<tr id = "tr_title">
						<td>
							<input type = "checkbox" id = "allCheck" onclick = "checkAll()" />
						</td>
						<td>
							��ȣ
						</td>
						<td>
							��ǰ�̹���
						</td>
						<td>
							��ǰ��
						</td>
						<td>
							����
						</td>
						<td>
							����
						</td>
						<td>
							<input type = "submit" value = "����">
						</td>
					</tr>
					
					<%
						int num = 1;
						for(int i = 0; i<cartList.size(); i++){
					%>
						<tr>
						<td>
							<input type = "checkbox" name = "delete1" value = "<%=cartList.get(i).getDogId()%>"/>
						</td>
						<td>
							<%=num++ %>
						</td>
						<td>
							<img src = "images/<%=cartList.get(i).getDogImage() %>.jpg"
							class = "cartProductImage"/>
						</td>
						<td>
							<%=cartList.get(i).getDogKind() %>
						</td>
						<td>
							<%=cartList.get(i).getDogPrice() %>
						</td>
						<td>
							<a href = "dogCartQtyUp.dog?dogId=<%=cartList.get(i).getDogId()%>"><img src = "images/up.jpg" class="upDownImage">
							</a><br>
							<%= cartList.get(i).getQty() %>��<br>
							<a href = "javascript:checkQty(<%=cartList.get(i).getDogId()%>,<%=cartList.get(i).getQty()%>)">
							<img src = "images/down.jpg" class="upDownImage"/></a>
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<%
						}
					%>
					<tr>
						<td colspan = "7" style = "font-size:xx-Large; text-align:right">
							�Ѱ����ݾ�: <%=totalMoney%>��
						</td>
					</tr>
				</table>
			</form>
		<%
			}
		%>				
	</section>
</body>
</html>