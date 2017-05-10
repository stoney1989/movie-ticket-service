package com.zuehlke;

public class SimpleMovie {

	private final Movie movie;

	public SimpleMovie(Movie movie) {
		this.movie = movie;
	}

	public long getId() {
		return movie.getId();
	}

	public String getTitle() {
		return movie.getTitle();
	}

	public String getPoster() {
		return movie.getPoster();
	}

}
