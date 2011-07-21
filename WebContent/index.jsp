<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="controller" method="get"> 
				<!-- Name: <input type="text" name="pname"><br>  -->
				Display The content of Triple Store.
				<br>  <input type="submit" value="visualize">
		<table border="1">
			<tr>
				<td><strong>subject</strong></td>
				<td><strong>property</strong></td>
				<td><strong>object</strong></td>
			</tr>
			<tr>
				<td>${DataView.subject}</td>
				<td>${DataView.property}</td>
				<td>${DataView.object}</td>
			</tr>
		</table>
	</form>
</body>
</html>