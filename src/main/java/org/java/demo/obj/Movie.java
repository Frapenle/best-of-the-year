package org.java.demo.obj;

public class Movie {
	private int id;
	private String title;
	public Movie(int id, String title) {
		setId(id);
		setTitle(title);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Id: " + getTitle()
				+ "Titolo: " + getTitle();
	}
	
	
}