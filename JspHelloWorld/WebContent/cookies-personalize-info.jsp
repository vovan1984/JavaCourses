<html>
    <head>
        <title>Personalized Info</title>
    </head>
    <body>
        <%!
            String getFavLang(Cookie[] cookies)
            {
                String favLang = "Java";
                
                // find myApp.favoriteLanguage cookie
                if (cookies != null)
                    for (Cookie c : cookies)
                    {
                	    if (c.getName().equals("myApp.favoriteLanguage"))
                		    favLang = c.getValue();
                	    break;
                    }
                
                return favLang;
            }
        %>
         
        <h2>History of <%= getFavLang(request.getCookies()) %></h2>
        Bla bla bla<br>
        Bla bla bla<br>
        Bla bla bla<br>
        
        <h2>Books on <%= getFavLang(request.getCookies()) %></h2>
        Bla bla bla<br>
        Bla bla bla<br>
        Bla bla bla<br>
        
        <h2>Fun facts about <%= getFavLang(request.getCookies()) %></h2>
        Bla bla bla<br>
        Bla bla bla<br>
        Bla bla bla<br>
        
        <br><br>
        
        <footer>
            <a href="cookies-personalize-form.html">Personalize</a>
        </footer>
    </body>
</html>