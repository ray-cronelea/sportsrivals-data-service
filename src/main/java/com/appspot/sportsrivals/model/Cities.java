package com.appspot.sportsrivals.model;

import org.springframework.data.annotation.Id;

public class Cities {

	@Id private String id;
	private String name;
	private Double rating;
	private String imageUrl;

	public Cities(){};

	public Cities(String name, Double rating, String imageUrl){
		this.name = name;
		this.rating = rating;
		this.imageUrl = imageUrl;
	}

	public String getId() { return id; }
	public String getName(){ return name; }
	public Double getRating(){ return rating; }
	public String getImageUrl(){ return imageUrl; }

	public void setName(String name){ this.name = name; }
	public void setRating(Double rating){ this.rating = rating; }
	public void setImageUrl(String imageUrl){ this.imageUrl = imageUrl; }

}