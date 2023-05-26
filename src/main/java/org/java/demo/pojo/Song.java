package org.java.demo.pojo;

public class Song {
	private int id;
	private String title;

	public Song(int id, String title) {
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
		return "Id: " + getId()
				+ "Titolo: " + getTitle();
	}
}