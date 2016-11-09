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

import model.View;

@WebServlet("/upRecipiForm")
public class upRecipiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> fs = new ArrayList<String>();
		for(int i = 0; i < 6; i++){
			fs.add("");
		}
		HttpSession session = request.getSession();
		session.setAttribute("fs", fs);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/upRecipiForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String judge = request.getParameter("judge");
		String s = request.getParameter("count");
		int count = Integer.parseInt(s);
		RequestDispatcher dispatcher = null;

		ArrayList<String> fs = new ArrayList<String>();
		for(int i = 0; i < count; i++){
			fs.add(request.getParameter("fs"+i));
		}
		if(judge.equals("材料を追加")){
			fs.add("");
			fs.add("");
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/upRecipiForm.jsp");
		}else if(judge.equals("登録確認画面")){
			View view = new View();
			view.setPageName(judge);
			view.setMsg("上記の内容で登録しますか？");
			session.setAttribute("view", view);
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/upRecipi.jsp");
		}
		session.setAttribute("fs", fs);
		dispatcher.forward(request, response);
	}

}
