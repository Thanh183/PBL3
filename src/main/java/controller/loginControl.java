package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import database.user_dataDAO;
import model.user_data;

/**
 * Servlet implementation class loginControl
 */
@WebServlet(name="loginControl",urlPatterns = {"/loginControlUrl"})
public class loginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginControl() {
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
		
		user_data tmp = new user_data();
		tmp.setUserId(userId);
		tmp.setPassword(password);
		
		user_dataDAO personDAO = new user_dataDAO();
		user_data person = personDAO.selectByLoginAndPassword(tmp);
		
		
		String url ="";
		if (person != null) {
			//response.getWriter().append("Chúc mừng bạn đã đăng nhập thành công!");
			HttpSession session = request.getSession();
			session.setAttribute("person", person);
			url = "/index.jsp";
			
		}else {
			//response.getWriter().append("Đăng nhập thất bại!");
			request.setAttribute("error", "Login Failed!");
			request.setAttribute("userId", userId);
			url = "/login.jsp";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}


