package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.Teams;

import java.util.List;

public interface TeamsRepositoryCustom {

	List<Teams> findTeamsForStateName(String stateName);

}