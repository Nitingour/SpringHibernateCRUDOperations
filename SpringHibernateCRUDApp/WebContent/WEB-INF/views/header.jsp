

<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">EMS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="home">Home</a></li>
      <li><a href="newemp">Create New Emp Account</a></li>
      <li><a href="ViewEmp">View All Emp Account</a></li>
        <li><a href="#">Welcome, 
        <%
        response.addHeader("pragma","no-cache");
        response.addHeader("cache-control","no-store");
        response.addHeader("expire","0");
        
       String user=(String)session.getAttribute("loginuser");
      if(user==null)
      {
    	  response.sendRedirect("index.jsp");
      }
        out.println(user); 
        %>
        
        </a></li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>
    