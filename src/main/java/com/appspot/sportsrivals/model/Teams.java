package com.appspot.sportsrivals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Teams {

	@Id private String id;

	private String name;
	private Integer rating;
	private String imageUrl;
	private String sportRadarId;

	@DBRef private Sports sport;
	@DBRef private Cities city;
	@DBRef private States state;

	public Teams(){}

	public Teams(String name, Integer rating, String imageUrl, String sportRadarId, final Sports sport, final Cities city, final States state) {
		this.setName(name);
		this.setRating(rating);
		this.setImageUrl(imageUrl);
		this.setSportRadarId(sportRadarId);
		this.setSport(sport);
		this.setCity(city);
		this.setState(state);
	}

	public String getId() { return id; }
	public String getName() { return name; }
	public Integer getRating() { return rating; }
	public String getImageUrl() { return imageUrl; }
	public String getSportRadarId() { return sportRadarId; }
	public Sports getSport() { return sport; }
	public Cities getCity() { return city; }
	public States getState() { return state; }

	public void setId(String id) { this.id = id; };
	public void setName(String name) { this.name = name; }
	public void setRating(Integer rating) { this.rating = rating; }
	public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
	public void setSportRadarId(String sportRadarId) { this.sportRadarId = sportRadarId; }
	public void setSport(Sports sport) { this.sport = sport; }
	public void setCity(Cities city) { this.city = city; }
	public void setState(States state) { this.state = state; }
}