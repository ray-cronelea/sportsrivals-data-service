package com.appspot.sportsrivals.receivers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ResultsMessage {


	String sportId;
	String source;
	String sourceId;
	String kickOffTimeUtc; //"2018-12-16T21:25:00+00:00",
	String homeTeamId;
	String awayTeamId;
	String homeTeamName;
	String awayTeamName;
	Integer homeTeamScore;
	Integer awayTeamScore;

	ResultsMessage(){}

	ResultsMessage(String sportId, String source, String sourceId,	String kickOffTimeUtc, String homeTeamId, String awayTeamId, String homeTeamName, String awayTeamName, Integer homeTeamScore, Integer awayTeamScore){
		this.sportId = sportId;
		this.source = source;
		this.sourceId = sourceId;
		this.kickOffTimeUtc = kickOffTimeUtc;
		this.homeTeamId = homeTeamId;
		this.awayTeamId = awayTeamId;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
	}

	public String getSportId(){ return sportId; }
	public String getSource(){ return source; }
	public String getSourceId(){ return sourceId; }
	public String getKickOffTimeUtc(){ return kickOffTimeUtc; }
	public String getHomeTeamId(){ return homeTeamId; }
	public String getAwayTeamId(){ return awayTeamId; }
	public String getHomeTeamName(){ return homeTeamName; }
	public String getAwayTeamName(){ return awayTeamName; }
	public Integer getHomeTeamScore(){ return homeTeamScore; }
	public Integer getAwayTeamScore(){ return awayTeamScore; }

	@JsonProperty("SportId") public void setSportId(String sportId){ this.sportId = sportId; }
	@JsonProperty("Source") public void setSource(String source){ this.source = source; }
	@JsonProperty("SourceId") public void setSourceId(String sourceId){ this.sourceId = sourceId; }
	@JsonProperty("KickOffTimeUtc") public void setKickOffTimeUtc(String kickOffTimeUtc){ this.kickOffTimeUtc = kickOffTimeUtc; }
	@JsonProperty("HomeTeamId") public void setHomeTeamId(String homeTeamId){ this.homeTeamId = homeTeamId; }
	@JsonProperty("AwayTeamId") public void setAwayTeamId(String awayTeamId){ this.awayTeamId = awayTeamId; }
	@JsonProperty("HomeTeamName") public void setHomeTeamName(String homeTeamName){ this.homeTeamName = homeTeamName; }
	@JsonProperty("AwayTeamName") public void setAwayTeamName(String awayTeamName){ this.awayTeamName = awayTeamName; }
	@JsonProperty("HomeTeamScore") public void setHomeTeamScore(Integer homeTeamScore){ this.homeTeamScore = homeTeamScore; }
	@JsonProperty("AwayTeamScore") public void setAwayTeamScore(Integer awayTeamScore){ this.awayTeamScore = awayTeamScore; }

}
