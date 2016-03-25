

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/YUCK")
public class ZorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
		     //doPost(request,response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Postprocess request: gather and validate submitted data and display the result in the same JSP.
	    	String user_input = request.getParameter("name");
	    	String room_name ,opt1 ,opt2 ,opt3 ,things;
	    	
	    	 ConnectDB connectdb = new ConnectDB();
	    	//String room= connectdb.getRoomDetails(user_input);
	    	 Room room=connectdb.getRoomDetails(user_input);
	    	 room_name=room.getName();
	    	 opt1=room.getOption1();
	    	 opt2=room.getOption2();
	    	 opt3=room.getOption3();
	    	 things=room.getThings();
	    	 
	    	String log =connectdb.logfile();
	    	//System.out.println(room.getName()+room.getOption1()+room.getOption2()+room.getOption3()+room.getThings());
	        
	        request.setAttribute("Room_Name", room_name);
	        request.setAttribute("log_file", log);
	        request.setAttribute("Option1", opt1);
	        request.setAttribute("Option2", opt2);
	        request.setAttribute("Option3", opt3);
	        request.setAttribute("Things", things);
	        
	       

	        

	        request.getRequestDispatcher("/index.jsp").forward(request, response);
	    }
	    
}
