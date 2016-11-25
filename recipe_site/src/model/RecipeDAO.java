package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDAO extends Recipes{

	Connection conn;
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
//	private final String JDBC_URL = "jdbc:mysql://localhost/recipe_site";
//	private final String DB_PASS ="UTsystem2016";
	private final String JDBC_URL = "jdbc:mysql://160.16.204.110/recipe_site";
	private final String DB_PASS ="";
	private final String DB_USER = "root";




	protected boolean connect(){
		try{
			if(conn != null){
				if(conn.getWarnings() == null){
					return true;
				}
				disconnect();
		}
			try{
				Class.forName(DRIVER_NAME);
			}catch(ClassNotFoundException e){

			}
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			if(conn.getWarnings() == null){
				return true;
			}
			disconnect();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	protected void disconnect(){
		if(conn != null){
			try{
				conn.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			conn = null;
		}
	}

	public RecipeDAO(){
		connect();
	}

	public void addRecipe(Recipe recipe){
		connect();
		try{

			String sql = "insert into recipe(title, serving, time, cook, u_id) values(?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, recipe.getTitle());
			pStmt.setString(2, recipe.getServing());
			pStmt.setString(3, recipe.getTime());
			pStmt.setString(4, recipe.getCook());
			pStmt.setString(5, recipe.getU_id());

			pStmt.executeUpdate();

			pStmt.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
		addFs(recipe);
	}

	public void addFs(Recipe recipe){
		connect();
		String r_id = getR_id(recipe);
		addProcess(recipe, r_id);
		try{

			String sql = "insert into fs(r_id, fs, quantity) values(?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);


			for(int i = 0; i < recipe.getFs().size(); i++){
				pStmt.setString(1, r_id);
				pStmt.setString(2, recipe.getFs().get(i));
				pStmt.setString(3, recipe.getQuantity().get(i));
				pStmt.executeUpdate();
			}

			pStmt.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public String getR_id(Recipe recipe){

		connect();
		String r_id = "";

		try{
			String sql = "select * from recipe where title=? and u_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, recipe.getTitle());
			pStmt.setString(2, recipe.getU_id());


			ResultSet rs = pStmt.executeQuery();

			if(rs.next()){
				r_id = rs.getString("r_id");
			}

			rs.close();
			pStmt.close();

			return r_id;

		}catch(SQLException e){
			e.printStackTrace();
		}
		return r_id;
	}

	public void addProcess(Recipe recipe, String r_id){
		connect();

		try{

			String sql = "insert into process(r_id, process) values(?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);


			for(int i = 0; i < recipe.getProcess().size(); i++){
				pStmt.setString(1, r_id);
				pStmt.setString(2, recipe.getProcess().get(i));
				pStmt.executeUpdate();
			}

			pStmt.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}



	public ArrayList<Recipe> searchRecipes(String word){
		connect();
		ArrayList<Recipe> searchRecipes = new ArrayList<Recipe>();
		try{
			String sql = "select * from recipe where title like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			String pattern = "%" + word.toUpperCase() + "%";
			pStmt.setString(1,  pattern);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int r_id = rs.getInt("r_id");
				String title = rs.getString("title");
				String serving = rs.getString("serving");
				String time = rs.getString("time");
				String cook = rs.getString("cook");
				String u_id = rs.getString("u_id");
				ArrayList<String> fs = getFs(r_id);
				ArrayList<String> quantity = getQuantity(r_id);
				ArrayList<String> process = getProcess(r_id);
				ArrayList<String> comment = getComment(r_id);
				ArrayList<String> status = getStatus(r_id);

				Recipe recipe = new Recipe(r_id, title, serving, time, cook, u_id, fs, quantity, process,comment, status);

				searchRecipes.add(recipe);

			}

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		return searchRecipes;

	}

	public ArrayList<String> getFs(int r_id){
		connect();
		ArrayList<String> fs = new ArrayList<String>();
		try{
			String sql = "select fs from fs where r_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, r_id);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				fs.add(rs.getString("fs"));
			}

			rs.close();
			pStmt.close();


		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		return fs;
	}

	public ArrayList<String> getQuantity(int r_id){
		connect();
		ArrayList<String> quantity = new ArrayList<String>();;
		try{
			String sql = "select quantity from fs where r_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, r_id);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				quantity.add(rs.getString("quantity"));
			}

			rs.close();
			pStmt.close();



		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		return quantity;
	}

	public ArrayList<String> getProcess(int r_id){
		connect();
		ArrayList<String> process = new ArrayList<String>();;
		try{
			String sql = "select process from process where r_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, r_id);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				process.add(rs.getString("process"));
			}

			rs.close();
			pStmt.close();



		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		return process;
	}

	public ArrayList<String> getComment(int r_id){
		connect();
		ArrayList<String> comment = new ArrayList<String>();;
		try{
			String sql = "select comment from comment where r_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, r_id);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				comment.add(rs.getString("comment"));
			}

			rs.close();
			pStmt.close();

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		return comment;
	}

	public ArrayList<String> getStatus(int r_id){
		connect();
		ArrayList<String> status = new ArrayList<String>();;
		try{
			String sql = "select userId from status where r_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, r_id);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				status.add(rs.getString("userId"));
			}

			rs.close();
			pStmt.close();

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}

		return status;
	}

	public Recipe getRecipe(int r_id){

		connect();
		Recipe recipe = null;

		try{
			String sql = "select * from recipe where r_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1,  r_id);
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()){

				String title = rs.getString("title");
				String serving = rs.getString("serving");
				String time = rs.getString("time");
				String cook = rs.getString("cook");
				String u_id = rs.getString("u_id");
				ArrayList<String> fs = getFs(r_id);
				ArrayList<String> quantity = getQuantity(r_id);
				ArrayList<String> process = getProcess(r_id);
				ArrayList<String> comment = getComment(r_id);
				ArrayList<String> status = getStatus(r_id);

				recipe = new Recipe(r_id, title, serving, time, cook, u_id, fs, quantity, process,comment, status);

			}

		}catch(SQLException e){
			e.printStackTrace();
			return recipe;
		}

		return recipe;

	}

}

