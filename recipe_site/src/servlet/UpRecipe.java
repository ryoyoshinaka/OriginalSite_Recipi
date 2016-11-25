package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Recipe;
import model.RecipeDAO;
import model.User;
import model.View;

@WebServlet("/UpRecipe")
public class UpRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		View view = new View();
		if(loginUser != null){
			String title = "";
			String time = "";
			String serving = "";
			String cook = loginUser.getName();
			String u_id = loginUser.getU_id();
			ArrayList<String> fs = new ArrayList<String>();
			ArrayList<String> quantity = new ArrayList<String>();
			ArrayList<String> process = new ArrayList<String>();

			for(int i = 0; i < 3; i++){
				fs.add("");
				quantity.add("");
				process.add("");
			}

			Recipe recipe = new Recipe(title, time, serving, fs, quantity, process, cook, u_id);
			request.setAttribute("recipe", recipe);

			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/upRecipeForm.jsp");
		}else{

			view.setMsg("レシピを投稿するにはログインが必要です。<br>");
			request.setAttribute("view", view);
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginForm.jsp");
		}

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dispatcher;
		Recipe recipe = new Recipe();

		View view = new View();

		String title = request.getParameter("title");
		String time = request.getParameter("time");
		String serving = request.getParameter("serving");
		String cook = request.getParameter("cook");
		String pageName = request.getParameter("pageName");
		String u_id = request.getParameter("u_id");
		int f_size = Integer.parseInt(request.getParameter("f_size"));
		int p_size = Integer.parseInt(request.getParameter("p_size"));
		ArrayList<String> fs = new ArrayList<String>();
		ArrayList<String> quantity = new ArrayList<String>();
		ArrayList<String> process = new ArrayList<String>();

		for(int i = 0; i < f_size;i++){
			fs.add(request.getParameter("fs" + i));
			quantity.add(request.getParameter("quantity" + i));
		}

		for(int i = 0; i < p_size; i++){
			process.add(request.getParameter("process" + i));
		}

		if(pageName.equals("材料追加") || pageName.equals("手順追加") || pageName.equals("材料削除") || pageName.equals("手順削除")){

			if(pageName.equals("材料追加")){

				fs.add("");
				quantity.add("");

			}else if(pageName.equals("手順追加")){

				process.add("");

			}else if(pageName.equals("材料削除")){

				fs.remove(fs.size()-1);
				quantity.remove(quantity.size()-1);

			}else{

				process.remove(process.size()-1);

			}
			recipe = new Recipe(title, time, serving, fs, quantity, process, cook, u_id);
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/upRecipeForm.jsp");

		}else{

			recipe = new Recipe(title, time, serving, fs, quantity, process, cook, u_id);

			if(pageName.equals("登録確認画面")){

				view.setMsg("上記の内容で登録しますか？");

			}else if(pageName.equals("登録結果")){

				RecipeDAO recipeDAO = new RecipeDAO();
				recipeDAO.addRecipe(recipe);

				view.setMsg("上記の内容で登録しました。");
			}

			request.setAttribute("view", view);
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/upRecipe.jsp");
		}
		view.setPageName(pageName);
		request.setAttribute("recipe", recipe);
		dispatcher.forward(request, response);
	}

}