package com.nielson.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Programs {

	@Id
	private int Id;
	private String Title;
	private String Genre;
	private String Network;
	private String ViewerHometown;
	private int Viewers;
	
	public Programs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Programs(int id, String title, String genre, String network, String hometown, int viewers) {
		super();
		Id = id;
		Title = title;
		Genre = genre;
		Network = network;
		ViewerHometown = hometown;
		Viewers = viewers;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getNetwork() {
		return Network;
	}

	public void setNetwork(String network) {
		Network = network;
	}

	public String getHometown() {
		return ViewerHometown;
	}

	public void setHometown(String hometown) {
		ViewerHometown = hometown;
	}

	public int getViewers() {
		return Viewers;
	}

	public void setViewers(int viewers) {
		Viewers = viewers;
	}

	@Override
	public String toString() {
		return "Programs [Id=" + Id + ", Title=" + Title + ", Genre=" + Genre + ", Network=" + Network + ", Hometown="
				+ ViewerHometown + ", Viewers=" + Viewers + "]";
	}

	
	
	
}
