package model;

import java.util.ArrayList;

public class Recipe {
	private int r_id;
	private String title;
	private String serving;
	private String time;
	private String cook;
	private String u_id;
	private ArrayList<String> fs;
	private ArrayList<String> quantity;
	private ArrayList<String> process;
	private ArrayList<String> comment;
	private ArrayList<String> status;

	public Recipe(String title,String time, String serving, ArrayList<String> fs, ArrayList<String> quantity, ArrayList<String> process, String cook, String u_id){
		this.title = title;
		this.serving = serving;
		this.time = time;
		this.fs = fs;
		this.quantity = quantity;
		this.process = process;
		this.cook = cook;
		this.setU_id(u_id);
	}

	public Recipe(int r_id, String title,String time, String serving, String cook, String u_id, ArrayList<String> fs, ArrayList<String> quantity, ArrayList<String> process, ArrayList<String>comment, ArrayList<String>status){
		this.r_id = r_id;
		this.title = title;
		this.serving = serving;
		this.time = time;
		this.fs = fs;
		this.quantity = quantity;
		this.process = process;
		this.cook = cook;
		this.u_id = u_id;
	}

	public Recipe() {

	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}

	public String getServing() {
		return serving;
	}
	public void setServing(String serving) {
		this.serving = serving;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public ArrayList<String> getFs() {
		return fs;
	}
	public void setFs(ArrayList<String> fs) {
		this.fs = fs;
	}
	public ArrayList<String> getProcess() {
		return process;
	}
	public void setProcess(ArrayList<String> process) {
		this.process = process;
	}
	public ArrayList<String> getComment() {
		return comment;
	}
	public void setComment(ArrayList<String> comment) {
		this.comment = comment;
	}

	public String getCook() {
		return cook;
	}

	public void setCook(String cook) {
		this.cook = cook;
	}

	public ArrayList<String> getQuantity() {
		return quantity;
	}

	public void setQuantity(ArrayList<String> quantity) {
		this.quantity = quantity;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public ArrayList<String> getStatus() {
		return status;
	}

	public void setStatus(ArrayList<String> status) {
		this.status = status;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}


}