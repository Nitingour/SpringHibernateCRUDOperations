<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
<div class="container">
  <h2>Login form</h2>
  
  <%
   String m=(String)request.getAttribute("msg");
  if(m!=null)
  {
	%>  
	  <div class="alert alert-danger alert-dismissible">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong><%=m %></strong> 
  </div>
<%	  
  } 
	   
  %>
 
  
  
  <div class="col-sm-3">
  <form action="CheckLogin" method="post" >
    <div class="form-group">
      <label for="email">LoginID:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter loginid" name="uid">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
  </form>
  </div>
</div>

</body>
</html>