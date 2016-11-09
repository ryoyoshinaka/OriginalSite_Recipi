package model;

public class View {

	private String msg;
	private String em;
	private String pageName;
//	private String judge;
	private int count = 3;

	public String getMsg(){return this.msg;}
	public void setMsg(String msg){this.msg = msg;}
	public String getEm(){return this.em;}
	public void setEm(String em){this.em = em;}
	public String getPageName(){return pageName;}
	public void setPageName(String pageName){this.pageName = pageName;}
	public int getCount(){return this.count;}
	public void setCount(int count){this.count = count;}

}
