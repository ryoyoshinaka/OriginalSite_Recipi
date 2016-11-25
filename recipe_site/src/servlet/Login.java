package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDAO;
import model.View;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String u_id ="";
		String pass = "";

		User user = new User(u_id, pass);
		View view = new View();

		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginForm.jsp");

		view.setMsg("");
		request.setAttribute("view", view);

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher;
		HttpSession session = request.getSession();
		View view = new View();

		String u_id = request.getParameter("u_id");
		String pass = request.getParameter("pass");

		UserDAO userDAO = new UserDAO();
		boolean check = userDAO.checkUser(u_id, pass);

		if(check){
			User user = userDAO.findUser(u_id);
			session.setAttribute("loginUser", user);
			view.setMsg("ログインに成功しました。");
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");

		}else{
			view.setMsg("idかパスワードが違います。");
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginForm.jsp");
		}
		view.setPageName("ログイン");
		request.setAttribute("view", view);
		dispatcher.forward(request, response);
	}

}
