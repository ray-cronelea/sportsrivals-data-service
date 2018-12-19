package com.appspot.sportsrivals.receivers.model;

import lombok.Getter;
import lombok.Setter;

public class RankingChange {

	@Getter @Setter String sportId;
	@Getter @Setter String teamId;
	@Getter @Setter String ranking;
	@Getter @Setter int rankingChangeType;

	public RankingChange(){}

	public RankingChange(String sportId, String teamId, String ranking, int rankingChangeType){
		this.sportId = sportId;
		this.teamId = teamId;
		this.ranking = ranking;
		this.rankingChangeType = rankingChangeType;
	}

}
