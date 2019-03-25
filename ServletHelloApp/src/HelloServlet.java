import java.io.*;
import javax.servlet.*;

public class HelloServlet extends GenericServlet
{
    @Override
    public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("Hello World!");
        pw.close();
    }
}