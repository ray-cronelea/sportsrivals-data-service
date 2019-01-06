package com.appspot.sportsrivals.receivers;

import com.appspot.sportsrivals.data.CitiesRepository;
import com.appspot.sportsrivals.data.StatesRepository;
import com.appspot.sportsrivals.data.TeamsRepository;
import com.appspot.sportsrivals.model.Cities;
import com.appspot.sportsrivals.model.States;
import com.appspot.sportsrivals.model.Teams;
import com.appspot.sportsrivals.receivers.model.RankingChangeType;
import com.appspot.sportsrivals.receivers.model.RankingMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ranking {

	private CitiesRepository citiesRepository;
	private StatesRepository statesRepository;
	private TeamsRepository teamsRepository;

	@Autowired public void setCitiesRepository(CitiesRepository citiesRepository) { this.citiesRepository = citiesRepository; }
	@Autowired public void setStatesRepository(StatesRepository statesRepository) { this.statesRepository = statesRepository; }
	@Autowired public void setTeamsRepository(TeamsRepository teamsRepository) { this.teamsRepository = teamsRepository; }

	@RabbitListener(queues = "#{queueRanking.name}")
	//public void receiveRanking(String message) throws InterruptedException{
	public void receiveRanking(String message) {
		System.out.println("queueRanking Received <" + message + ">");
		try {

			// Convert json string to object
			RankingMessage rm = new ObjectMapper().readValue(message, RankingMessage.class);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			System.out.println(ow.writeValueAsString(rm));


			int rct = rm.getRankingChangeType();
			String id = rm.getId();

			if (rct == RankingChangeType.TEAM) {

				System.out.println("RankingChangeType is TEAM");
				Teams t = teamsRepository.findById(id).get();
				t.setRating(rm.getRanking());
				teamsRepository.save(t);

			} else if(rct == RankingChangeType.STATE) {

				System.out.println("RankingChangeType is STATE");
				States s = statesRepository.findById(id).get();
				s.setRating(rm.getRanking());
				statesRepository.save(s);

			} else if(rct == RankingChangeType.CITY) {

				System.out.println("RankingChangeType is CITY");
				Cities c = citiesRepository.findById(id).get();
				c.setRating(rm.getRanking());
				citiesRepository.save(c);

			} else if(rct == RankingChangeType.UNSET) {
				System.out.println("RankingChangeType is UNSET");
			} else {
				System.out.println("RankingChangeType not recognised, value:" + String.valueOf(rct));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred mapping message to team object");
		}
	}
}