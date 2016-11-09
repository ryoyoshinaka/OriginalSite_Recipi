package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String id;
	private String mail;//公開しない
	private String pass;//公開しない

	public User(){

	}

	public User(String name, String id, String mail, String pass){
		this.name = name;
		this.id= id;
		this.mail = mail;
		this.pass = pass;
	}
	public User(String id, String pass){
		this.id = id;
		this.pass = pass;

	}

	public String getName(){return this.name;}
//	public void setName(String name){this.name = name;}
	public String getId(){return this.id;}
//	public void setId(String id){this.id = id;}
	public String getMail(){return this.mail;}
//	public void setMail(String mail){this.mail = mail;}
	public String getPass(){return this.pass;}
//	public void setPass(String pass){this.pass = pass;}

}
