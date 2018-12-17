package com.appspot.sportsrivals.data;

import com.appspot.sportsrivals.model.States;
import com.appspot.sportsrivals.model.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class TeamsRepositoryImpl implements TeamsRepositoryCustom {

	private final MongoTemplate mongoTemplate;
	@Autowired public TeamsRepositoryImpl(MongoTemplate mongoTemplate) { this.mongoTemplate = mongoTemplate; }

	@Override
	public List<Teams> findTeamsForStateName(String stateName) {
		String stateId = mongoTemplate.findOne(query(where("name").is(stateName)), States.class).getId();
		return mongoTemplate.find(query(where("state").is(stateId)), Teams.class);
	}
}