package model;

public class LoginLogic {
	public User execute(String id, String pass){

		UserDAO ud = new UserDAO();
		User user = ud.findUser(id);

		if(user.getPass().equals(pass)){
			return user;
		}
		return null;

	}
}
