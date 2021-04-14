package com.nielson.domain;

public class ChartView {

	
	private String Genre;
	private int TotalViewers;
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public int getViewers() {
		return TotalViewers;
	}
	public void setViewers(int viewers) {
		TotalViewers = viewers;
	}
	@Override
	public String toString() {
		return "ChartView [Genre=" + Genre + ", TotalViewers=" + TotalViewers + "]";
	}
	
	
}
