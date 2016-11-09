package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;
import model.View;

@WebServlet("/Log")
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/logout.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		View view = new View();

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		LoginLogic loginLogic = new LoginLogic();
		User user = loginLogic.execute(id, pass);
		HttpSession session = request.getSession();

		if(user != null){
			session.setAttribute("loginUser", user);
			view.setPageName("ログイン成功");
			view.setMsg("ログインに成功しました。");
		}else{
			view.setPageName("ログイン失敗");
			view.setMsg("ログインに失敗しました。");
		}

		session.setAttribute("view", view);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

}
