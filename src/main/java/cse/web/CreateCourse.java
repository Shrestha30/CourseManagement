package cse.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCourse
 */
//@WebServlet("/CreateCourse")
public class CreateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String type = (String)session.getAttribute("type");
		if(type.compareTo("3")==0) {
			List < Course > listCourses = DBControlModule.getAllCourses();
	        request.setAttribute("listCourses", listCourses);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("createCourse.jsp");
	        dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
	        dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
