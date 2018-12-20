package com.appspot.sportsrivals.receivers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RankingMessage {

	String id;
	Double ranking;
	Integer rankingChangeType;

	public RankingMessage(){}

	public RankingMessage(String id, Double ranking, Integer rankingChangeType){
		this.id = id;
		this.ranking = ranking;
		this.rankingChangeType = rankingChangeType;
	}

	public String getId(){ return id; }
	public Double getRanking(){ return ranking; }
	public Integer getRankingChangeType(){ return rankingChangeType; }

	@JsonProperty("Id") public void setId(String id){ this.id = id; }
	@JsonProperty("Ranking") public void setRanking(Double ranking){ this.ranking = ranking; }
	@JsonProperty("RankingChangeType") public void setRankingChangeType(Integer rankingChangeType){ this.rankingChangeType = rankingChangeType; }

}