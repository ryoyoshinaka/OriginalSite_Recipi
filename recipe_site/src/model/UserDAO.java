package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAO {

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
			if(conn.getWarnings() == null)
				return true;
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

	public UserDAO(){
		connect();
	}

	public void addUser(User user){
		connect();

		try{

			String sql = "insert into user(name, u_id, mail, pass) values(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getU_id());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getPass());

			pStmt.executeUpdate();

			pStmt.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public boolean checkUser(String u_id, String pass){

		connect();
		try{
			String sql = "select * from user where u_id=? and pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,u_id);
			pStmt.setString(2,pass);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()){
				return true;
			}
			pStmt.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}

		return false;
	}

	public User findUser(String u_id){
		connect();
		User user = new User();
		try{

			String sql = "select * from user where u_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,u_id);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String pass = rs.getString("pass");
				user = new User(name,u_id,mail,pass);
			}
			pStmt.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return user;
	}

	public boolean checkId(String u_id){
		connect();
		try{

			String sql = "select * from user where u_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,u_id);
			ResultSet rs = pStmt.executeQuery();

			if(rs.next() == false){
				return false;
			}

			pStmt.close();
			rs.close();

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean checkMail(String mail){

		connect();

		try{

			String sql = "select * from user where mail = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,mail);
			ResultSet rs = pStmt.executeQuery();

			if(rs.next() == false){
				return false;
			}

			pStmt.close();
			rs.close();

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}