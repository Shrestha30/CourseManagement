package cse.web;

public class Course {
	/*Class to handle courses from and to database
	 * */
	
	protected int teacherid;//teacher id -1: not assigned
	protected String code,title;
	
	public Course(String code, String title, int teacherid) {
		super();
		this.teacherid = teacherid;
		this.code = code;
		this.title = title;
	}
	
	public Course(String code, String title) {
		super();
		this.code = code;
		this.title = title;
	}

	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
