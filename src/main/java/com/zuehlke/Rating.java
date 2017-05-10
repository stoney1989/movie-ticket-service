package com.zuehlke;

public class Rating {

	
	private String source;
	private String rating;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Rating(String source, String rating){
		this.source = source;
		this.rating = rating;
		
	}
}
