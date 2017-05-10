package com.zuehlke;

import java.util.Arrays;
import java.util.List;

public class Movie {


	private long id;
	private String title;
	private String poster;
	private String plot;
	private int year;
	private String genre;
	private List<Rating> ratings;

	public Movie(long id, String title, String poster, String plot, int year, String genre, Rating ...ratings) {
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.plot = plot;
		this.year = year;
		this.genre = genre;	
		this.ratings = Arrays.asList(ratings);
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String tile) {
		this.title = tile;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}