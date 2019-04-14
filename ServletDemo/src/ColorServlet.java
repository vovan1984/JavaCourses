

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.luv2code.servletdemo.*;;

/**
 * Servlet implementation class ColorServlet
 */
@WebServlet("/ColorServlet")
public class ColorServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private final DriverDB dbConnection; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColorServlet() 
    {
        super();
        dbConnection = new DriverDB();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Get selected color
	    String color = request.getParameter("servletColor");
	    
	    try (PrintWriter os = response.getWriter())
	    {
	        os.println("<h3>Confirmation of color selection using GET method</h3>");
	        displaySelection(color, os);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        // Get selected color
        String color = request.getParameter("servletColor");
        
        try (PrintWriter os = response.getWriter())
        {
            os.println("<h3>Confirmation of color selection using POST method</h3>");
            displaySelection(color, os);
        }
	}
	
	// Generate HTML representation of color selection
	private void displaySelection(String color, PrintWriter os)
	{
	    ResultSet myRs;
	    
        os.println("Your selected color: <b>" + color + "</b>");
        os.println("<br><br>");
        os.println("<h3>Previously selected colors</h3>");
        os.println("<ul>");
        
        try
        {
            myRs = dbConnection.executeQuery("select * from color_selections");
            while (myRs.next())
                os.println("<li>" + myRs.getString("color") + "</li>");
            
            // save newly selected color
            dbConnection.executeUpdate("insert into color_selections values (sysdate(), '" + color + "')");
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        os.println("</ul>");

	}

}
