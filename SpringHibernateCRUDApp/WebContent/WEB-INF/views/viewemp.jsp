
<%@include file="header.jsp" %>
<%@page import="java.util.ArrayList,com.myapp.beans.EmployeeBean" %>
<div class="container">
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
<h1>Employee Details</h1>
<table class="table table-hover">
<tr><th>EID</th><th>Name</th><th>Salary</th><th>EmailID</th><th>Address</th><th>Joining Date</th></tr>
<%
ArrayList<EmployeeBean> list=( ArrayList<EmployeeBean>)request.getAttribute("LIST");
for(EmployeeBean e:list)
{
	%>
	<tr>
  <td>    <%=e.getEid() %> </td>
  <td> <%=e.getEname() %> </td>
  <td> <%=e.getSalary() %></td>
  <td> <%=e.getEmail()%></td>
  <td> <%=e.getAddress() %></td>
  <td> <%=e.getJoiningdate() %></td>
   <td> <a href="DelEmp?empid=<%=e.getEid() %>" class="glyphicon glyphicon-remove-circle"  
     onClick="return confirm('Do you really want ot delete?')"></a>
    <a href="UpEmp?empid=<%=e.getEid() %>" class=" glyphicon glyphicon-edit"  
     ></a>
     </td>
   </tr>
<%
}
	
%>
</table></div>