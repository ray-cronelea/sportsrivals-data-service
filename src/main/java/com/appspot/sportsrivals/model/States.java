package com.appspot.sportsrivals.model;

import org.springframework.data.annotation.Id;

public class States {

	@Id
	private String id;

	private String name;
	private String abbreviation;
	private String capital;
	private Integer rating;
	private String imageUrl;

	public States(){};

	public States(String name, String abbreviation, String capital, Integer rating, String imageUrl){
		this.name = name;
		this.abbreviation = abbreviation;
		this.capital = capital;
		this.rating = rating;
		this.imageUrl = imageUrl;
	}

	public String getId(){ return id; }
	public String getName(){ return name; }
	public String getAbbreviation(){ return abbreviation; }
	public String getCapital(){ return capital; }
	public Integer getRating(){ return rating; }
	public String getImageUrl(){ return imageUrl; }

	public void setName(String name){ this.name = name; }
	public void setAbbreviation(String abbreviation){ this.abbreviation = abbreviation; }
	public void setCapital(String capital){ this.capital = capital; }
	public void setRating(Integer rating){this.rating = rating; }
	public void setImageUrl(String imageUrl){ this.imageUrl = imageUrl; }

}