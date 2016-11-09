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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		View view = new View();
		view.setPageName(request.getParameter("pageName"));

		if(view.getPageName().equals("登録確認")){

			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String mail = request.getParameter("mail");
			String pass = request.getParameter("pass");
			User user = new User(name, id, mail, pass);

			session.setAttribute("user", user);

		}else if(view.getPageName().equals("登録結果")){
			User user = (User)session.getAttribute("user");
			UserDAO userDAO = new UserDAO();
			userDAO.addUser(user);
			session.setAttribute("loginUser", user);
		}

		session.setAttribute("view", view);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

}
