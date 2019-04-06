<html>
    <head>
        <title>Personalized Info</title>
    </head>
    <body>
        <!--  read the favorite programming language cookie -->
        <%
            String favLang = "Java";
            
            Cookie[] cookies = request.getCookies();
            
            // find myApp.favoriteLanguage cookie
            if (cookies != null)
                for (Cookie c : cookies)
                {
            	    if (c.getName().equals("myApp.favoriteLanguage"))
   	                favLang = c.getValue();
                	break;
                }
        %>
        
        <!--  now show a personalized page ... use the "favLang" variable --> 
        
        <h2>History of <%= favLang %></h2>
        Bla bla bla<br>
        Bla bla bla<br>
        Bla bla bla<br>
        
        <h2>Books on <%= favLang %></h2>
        Bla bla bla<br>
        Bla bla bla<br>
        Bla bla bla<br>
        
        <h2>Fun facts about <%= favLang %></h2>
        Bla bla bla<br>
        Bla bla bla<br>
        Bla bla bla<br>
        
        <br><br>
        
        <footer>
            <hr>
            <a href="cookies-personalize-form.html">Personalize this page</a>
        </footer>
    </body>
</html>