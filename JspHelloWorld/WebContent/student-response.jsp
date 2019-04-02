<html>
<head>
<title>Student confirmation page</title>
</head>
<body>
	The following student was successfully registered:
	<%= request.getParameter("firstname") %> <%= request.getParameter("lastname") %>
</body>
</html>