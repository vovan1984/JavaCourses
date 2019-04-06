<html>
    <head>
        <title>Confirmation</title>
        
        <% 
            // read form data
            String favLang = request.getParameter("favoriteLanguage");
    
            // create cookie
            Cookie c = new Cookie("myApp.favoriteLanguage", favLang);
            
            // set a life span on a cookie for 10 hours
            c.setMaxAge(60*60*24*10);
            
            // write cookie to the response
            response.addCookie(c);
        %>
    </head>
    <body>
        Thanks! We've set your favorite programming language to ${param.favoriteLanguage} 
        <br><br>
        <a href="cookies-homepage.jsp">Return to the HomePage</a>
    </body>
</html>