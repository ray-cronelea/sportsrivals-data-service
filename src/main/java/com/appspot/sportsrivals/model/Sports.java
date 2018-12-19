package com.appspot.sportsrivals.model;

import org.springframework.data.annotation.Id;

public class Sports {

	@Id private String id;

	private String name;
	private String sportName;
	private String imageUrl;

	public Sports(){};

	public Sports(String name, String sportName, String imageUrl){
		this.name = name;
		this.sportName = sportName;
		this.imageUrl = imageUrl;
	}

	public String getId() { return id; }
	public String getName(){ return name; }
	public String getSportName(){ return sportName; }
	public String getImageUrl(){ return imageUrl; }

	public void setName(String name){ this.name = name; }
	public void setSportName(String sportName){ this.sportName = sportName; }
	public void setImageUrl(String imageUrl){ this.imageUrl = imageUrl; }

}