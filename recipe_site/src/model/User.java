package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String u_id;
	private String mail;
	private String pass;

	public User(){

	}

	public User(String name, String u_id, String mail, String pass){
		this.name = name;
		this.u_id = u_id;
		this.mail = mail;
		this.pass = pass;
	}
	public User(String u_id, String pass){
		this.u_id = u_id;
		this.pass = pass;

	}

	public String getName(){return this.name;}
//	public void setName(String name){this.name = name;}
	public String getU_id(){return this.u_id;}
//	public void setId(String id){this.id = id;}
	public String getMail(){return this.mail;}
//	public void setMail(String mail){this.mail = mail;}
	public String getPass(){return this.pass;}
	public void setPass(String pass){this.pass = pass;}

}
