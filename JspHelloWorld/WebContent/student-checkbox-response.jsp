<html>
<head>
<title>Student confirmation page</title>
</head>
<body>
	The following student was successfully registered:
	<%= request.getParameter("firstname") %> <%= request.getParameter("lastname") %>
	<br><br>
	
	<!-- Display list of favorite languages using JSP scriplet -->
	
	<%
	    String[] langArr = request.getParameterValues("favoriteLanguage");
	    
	    if (langArr == null)
            out.println("<b>Student didn't select any favorite programming languages!</b>");
	    else
	    {
            out.println("<b>Student's favorite programming languages:</b>");
            out.println("<ul>");
            for (String lang : langArr)
            out.println("<li>" + lang +"</li>");
            out.println("</ul>");
        }
	%>
</body>
</html>