package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

	Connection conn;
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost/recipi_site";
	private final String DB_USER = "root";
	private final String DB_PASS ="UTsystem2016";

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

	public List<User> findAll(){
		List<User> userList = new ArrayList<User>();
		try{
			connect();
			String sql = "select name, id, mail, pass from user";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				String name = rs.getString("name");
				String id = rs.getString("id");
				String mail = rs.getString("mail");
				String pass = rs.getString("pass");
				User user = new User(name, id, mail, pass);
				userList.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public boolean addUser(User user){

		try{
			connect();
			String sql = "insert into user(name, id, mail, pass) values(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getId());
			pStmt.setString(3, user.getMail());
			pStmt.setString(4, user.getPass());

			int result = pStmt.executeUpdate();

			if(result != 1){
				return false;
			}
			pStmt.close();

		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public User findUser(String id){
		User user = null;
		try{
			connect();
			String sql = "select * from user where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String pass = rs.getString("pass");
				user = new User(name,id,mail,pass);
			}
			pStmt.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("bad1");
			return null;
		}finally{
			if(conn != null){
				try{
					conn.close();

				}catch(SQLException e){
					e.printStackTrace();
					System.out.println("bad2");
					return null;
				}
			}
		}
		return user;
	}
}
