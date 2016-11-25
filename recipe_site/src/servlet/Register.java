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

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		View view = new View();
		view.setMsg("");

		String name = "";
		String u_id = "";
		String mail = "";
		String pass = "";
		User user = new User(name, u_id, mail, pass);

		request.setAttribute("user", user);
		request.setAttribute("view", view);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		View view = new View();
		UserDAO userDAO = new UserDAO();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");;

		String pageName = request.getParameter("pageName");
		String name = request.getParameter("name");
		String u_id = request.getParameter("u_id");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		User user = new User(name, u_id, mail, pass);

		if(pageName.equals("登録確認")){

			String pass2 = request.getParameter("pass2");

			if(userDAO.checkId(u_id) == true){
				view.setMsg(view.getMsg() + "そのIDは使用されています。<br>");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");

			}
			if(userDAO.checkMail(mail) == true){

				view.setMsg(view.getMsg() + "そのメールアドレスは使用されています。<br>");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");

			}
			if(pass.equals(pass2)){

				user.setPass(pass);

			}else{

				view.setMsg(view.getMsg() + "パスワードが違います。<br>");
				dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
			}

		}else{

			userDAO.addUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);

		}

		view.setPageName(pageName);
		request.setAttribute("user", user);
		request.setAttribute("view", view);
		dispatcher.forward(request, response);

	}
}
