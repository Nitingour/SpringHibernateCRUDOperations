<!DOCTYPE html>
<html lang="en">



<%@include file="header.jsp" %>
<body background="isdafmages/india.png">





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
 
<div class="container" >
  <h3>Employee Form</h3>

<div class="col-sm-6">
  <form action="EmpInsert" method="post" >
   <!--  <div class="form-group">
      <label for="email">EID:</label>
      <input type="text" class="form-control" id="email" placeholder="Enter loginid" name="eid" required />
    </div> -->
    <div class="form-group">
      <label for="pwd">Name:</label>
      <input type="text" class="form-control" id="pwd" placeholder="Enter name" name="ename" required>
    </div>
    
     <div class="form-group">
      <label for="pwd">EmailId:</label>
      <input type="email" class="form-control" id="pwd" placeholder="Enter email" name="email" required>
    </div>
    
     <div class="form-group">
      <label for="pwd">Salary:</label>
      <input type="number" class="form-control" id="pwd" placeholder="Enter Salary" name="salary">
    </div>
    
     <div class="form-group">
      <label for="pwd">Address:</label>
      <textarea  class="form-control" placeholder="Enter address" name="address"></textarea>
    </div>
    
      <div class="form-group">
      <label for="pwd">Joining Date:</label>
      <input type="date" class="form-control" id="pwd" placeholder="Enter password" name="joiningdate">
    </div>
    
    <button type="submit" class="btn btn-primary btn-md">Save</button>
  </form>
  <div>
  </div>
</div>

</body>
</html>


