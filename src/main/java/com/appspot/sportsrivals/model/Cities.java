package com.appspot.sportsrivals.model;

import org.springframework.data.annotation.Id;

public class Cities {

	@Id private String id;

	private String name;
	private Integer rating;
	private String imageUrl;

	public Cities(String name, Integer rating, String imageUrl){
		this.name = name;
		this.rating = rating;
		this.imageUrl = imageUrl;
	}

	public String getName(){ return name; }
	public Integer getRating(){ return rating; }
	public String getImageUrl(){ return imageUrl; }

	public void setName(String name){ this.name = name; }
	public void setRating(int rating){ this.rating = rating; }
	public void setImageUrl(String imageUrl){ this.imageUrl = imageUrl; }

}