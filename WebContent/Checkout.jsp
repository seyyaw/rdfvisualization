<%@page language="java" contentType="text/html"%>
<%@page session="true"
	import="java.util.*,org.okkam.rdfviewer.examples.Book"%>
<html>
<head>
<title>E-Bookshop Checkout</title>
<style type="text/css">
body {
	background-color: cyan;
	font-size
	=10pt;
}

H1 {
	font-size: 20pt;
}

table {
	background-color: white;
}
</style>
</head>
<body>
	<H1>Your online Bookshop - Checkout</H1>
	<hr />
	<p />
	<table border="1" cellpadding="2">
		<tr>
			<td>TITLE</td>
			<td align="right">PRICE</td>
			<td align="right">QUANTITY</td>
		</tr>
		<%
			Vector shoplist = (Vector) session.getValue("ebookshop.cart");
			for (int i = 0; i < shoplist.size(); i++) {
				Book anOrder = (Book) shoplist.elementAt(i);
		%>
		<tr>
			<td><%=anOrder.getTitle()%></td>
			<td align="right">$<%=anOrder.getPrice()%></td>
			<td align="right"><%=anOrder.getQuantity()%></td>
		</tr>
		<%
			}
			session.invalidate();
		%>
		<tr>
			<td>TOTALS</td>
			<td align="right">$<%=(String) request.getAttribute("dollars")%></td>
			<td align="right"><%=(String) request.getAttribute("books")%></td>
		</tr>
	</table>
	<p />
	<a href="eshop">Buy more!</a>
</body>
</html>