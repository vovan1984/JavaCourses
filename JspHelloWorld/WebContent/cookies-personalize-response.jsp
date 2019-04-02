<html>
    <head>
        <title>Confirmation</title>
    </head>
    <body>
        You selected: 
        <% 
            // read form data
            String favLang = request.getParameter("favoriteLanguage");
            out.println(favLang);
    
            // create cookie
            Cookie c = new Cookie("myApp.favoriteLanguage", favLang);
            
            // write cookie to the response
            response.addCookie(c);
        %>
    </body>
</html>