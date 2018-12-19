package com.appspot.sportsrivals.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Fixtures{

	@Id private String id;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	private String kickOffTime;

	@DBRef private Teams homeTeam;
	@DBRef private Teams awayTeam;
	@DBRef private Sports sport;

	public Fixtures(){};

	public Fixtures(Integer homeTeamScore, Integer awayTeamScore, String kickOffTime, final Teams homeTeam, final Teams awayTeam, final Sports sport) {
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.kickOffTime = kickOffTime;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.sport = sport;
	}

	public String getId(){ return id; }
	public Integer getHomeTeamScore(){ return homeTeamScore; }
	public Integer getAwayTeamScore(){ return awayTeamScore; }
	public String getKickOffTime(){ return kickOffTime; }
	public Teams getHomeTeam(){ return homeTeam; }
	public Teams getAwayTeam(){ return  awayTeam; }
	public Sports getSport(){ return sport; }

	public void setHomeTeamScore(Integer homeTeamScore){ this.homeTeamScore = homeTeamScore; }
	public void setAwayTeamScore(Integer awayTeamScore){ this.awayTeamScore = awayTeamScore; }
	public void setKickOffTime(String kickOffTime){ this.kickOffTime = kickOffTime; }
	public void setHomeTeam(Teams homeTeam){ this.homeTeam = homeTeam; }
	public void setAwayTeam(Teams awayTeam){ this.awayTeam = awayTeam; }
	public void setSport(Sports sport){ this.sport = sport; }

}