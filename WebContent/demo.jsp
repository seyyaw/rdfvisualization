<%@ page language="java" import="java.sql.*" errorPage="" %>

<%
String content=request.getParameter("content");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con =
DriverManager.getConnection
("mysql:jdbc://localhost:3306/egglabs","root","root");
Statement st = con.createStatement();
int i=st.executeUpdate
 ("insert into messages(msg)values('"+content+"')"); 
ResultSet rs=st.executeQuery
 ("select * from messages order by msg_id desc");

if(rs.next())
{
while(rs.next())
{
String msg=rs.getString("msg");
%>
<li>
<div align="left">
<span ><%= msg %> </span>
</div>
</li>
<%
}
}
else{
out.println("No Records Found");}
}

catch(Exception e){
Exception ex = e;
out.println("Mysql Database Connection Not Found");
}
%>