<html>
<head>
<title>Student confirmation page</title>
</head>
<body>
	The following student was successfully registered:
	<%= request.getParameter("firstname") %> <%= request.getParameter("lastname")%><br><br>
	Student's country is ${param.country} 
</body>
</html>