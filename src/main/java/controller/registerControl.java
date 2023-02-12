package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.user_dataDAO;
import model.user_data;

/**
 * Servlet implementation class registerControl
 */
@WebServlet(name="registerControl",urlPatterns = {"/registerControlUrl"})
public class registerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password = request.getParameter("password");
		String re_password =request.getParameter("re_password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		user_data tmp = new user_data(userId,password,firstName,lastName,age,gender,address,phone,3);
		user_dataDAO ud = new user_dataDAO();
		user_data user=ud.selectByLoginAndPassword(tmp);
		String url="";
		if(user != null ) {
			request.setAttribute("error","User has already existed! Please enter again!");
			request.setAttribute("firstName",firstName);
			request.setAttribute("lastName",lastName);
			request.setAttribute("age", age);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("phone", phone);
			url="/register.jsp";
		}
		else {
			ud.insert(tmp);
			url="/index.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
