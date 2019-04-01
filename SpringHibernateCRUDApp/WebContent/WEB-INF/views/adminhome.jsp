<!DOCTYPE html>
<html lang="en">

<%@include file="header.jsp" %>
<body >



<div class="container-fluid" style="margin-top:80px">
  <%
       String u=(String)session.getAttribute("loginuser");
        out.println(u);
        %>
  <h3>Welcome at Admin Home</h3>
</div>

</body>
</html>


