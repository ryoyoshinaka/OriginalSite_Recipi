package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Recipe;
import model.RecipeDAO;

@WebServlet("/SearchRecipe")
public class SearchRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		RecipeDAO recipeDAO = new RecipeDAO();

		int r_id = Integer.parseInt(request.getParameter("r_id"));

		Recipe recipe = recipeDAO.getRecipe(r_id);

		request.setAttribute("recipe", recipe);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeView.jsp");
		dispatcher.forward(request, response);




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
