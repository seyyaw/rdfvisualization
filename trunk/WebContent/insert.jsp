<%@ page language="java" import="java.sql.*" errorPage="" %>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js">
</script>
<script type="text/javascript" >
$(function() {
$(".update_button").click(function() {

var boxval = $("#content").val();
var dataString = 'content='+ boxval;

if(boxval=='')
{
alert("Please Enter Some Text");
}
else
{
$("#flash").show();
$("#flash").fadeIn(400).html('<img src="image/test.gif" align="absmiddle"> 
<span class="loading">Loading Comment...</span>');

$.ajax({
type: "POST",
url: "demo.jsp",
data: dataString,
cache: false,
success: function(html){
$("ol#update").prepend(html);
$("ol#update li:first").slideDown("slow");
$("#content").value('');
$("#content").focus(); $("#flash").hide();
}
});
} return false;
});
});
</script>
<div>
<form method="post" name="form" action="">
<h3>What are you doing?</h3>
<textarea cols="30" rows="2" name="content" id="content" maxlength="145" >
</textarea><br />
<input type="submit" value="Update" name="submit" class="update_button"/>
</form>
</div>
<div id="flash"></div>
<ol id="update" class="timeline">
</ol>