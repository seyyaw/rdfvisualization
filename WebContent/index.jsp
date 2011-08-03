<%@page import="org.okkam.rdfviewer.view.DataView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wel-come to the TripleStore visualization System.</title>
<style type="text/css">
body {
    margin: 0;
    padding: 0;
    height:100%;
}
div#header {
    clear: both;
    height: 50px;
    background-color: aqua;
    padding: 10px;
    left:200; 
}
div#left {
    position:absolute;
	left:0;
	top:70px;
	padding:0;
	width:200px;
	height:100%; /* works only if parent container is assigned a height value */
	color:#333;
	background:#eaeaea;
	border:1px solid #333; 
}
div#right {
    position:absolute;
 	right:0;
 	top:70px;
 	padding:0;
	width:200px;
	height:100%; /* works only if parent container is assigned a height value */
	color:#333;
	background:#eaeaea;
	border:1px solid #333; 
}
div#middle {
margin-left:220px;
margin-right:220px;
margin-bottom:20px;
color:#333;
background:#ffc;
border:1px solid #333;
padding:0 10px; 
}
div#footer {
    clear: both;
    background-color: #ffc;
}
</style>
</head>
<body>
		<div id="header">
		<h2>Display The content of Triple Store.</h2>
		</div>
		
	<!--	<div id="left">
		This is left
		</div>
		
	 	<div id="right">
		this is right
		</div> -->
		<div id="middle">
		<form action="controller" method="get"> 
				<!-- Name: <input type="text" name="pname"><br>  -->
				
		<br>  <input type="submit" value="visualize">
		<table border="10">
		<col style="background-color: #6374AB; color: #ffffff" />
		<col span="1" style="background-color: #07B133; color: #ffffff;" />
		<col span="2" style="background-color: #F7B133; color: #ffffff;" />
		<% DataView dataview[]=(DataView[])request.getAttribute("DataView");
		if(dataview!=null){//out.println(dataview.length);
		%>
		<tr>
				<td><strong>subject</strong></td>
				<td><strong>property</strong></td>
				<td><strong>object</strong></td>
			</tr> 
		<%
		for (int i=0;i<dataview.length;i++){
			//out.print(dataview[i].getSubject());
			//dataview[i].getSubject()
		%>
			<%// for (int i = 0; i < dataview.length; i++) { %>
			<tr>
				<td> <% out.print(dataview[i].getSubject());%></td>
				<td><% out.print(dataview[i].getProperty());%></td>
				<td> <% out.print(dataview[i].getObject());%></td>
			</tr>
			<%
			}}
			%>
		</table>
	</form>
	</div>
	<div id="footer">
		Designed by OKKAM s.r.i
	<br>Copyright (C) 2011. OKKAM S.r.l. All rights reserved
	</div>
</body>
</html>