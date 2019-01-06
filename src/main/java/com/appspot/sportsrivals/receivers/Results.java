package com.appspot.sportsrivals.receivers;

import com.appspot.sportsrivals.data.*;
import com.appspot.sportsrivals.model.Fixtures;
import com.appspot.sportsrivals.model.Teams;
import com.appspot.sportsrivals.receivers.model.ResultsMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Results {

	private TeamsRepository teamsRepository;
	private FixturesRepository fixturesRepository;

	@Autowired public void setTeamsRepository(TeamsRepository teamsRepository) { this.teamsRepository = teamsRepository; }
	@Autowired public void setFixtureRepository(FixturesRepository fixturesRepository) { this.fixturesRepository = fixturesRepository; }

	@RabbitListener(queues = "#{queueResults.name}")
	public void receiveResults(String message) {
		System.out.println("queueResults Received <" + message + ">");
		try {

			ResultsMessage rm = new ObjectMapper().readValue(message, ResultsMessage.class);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			System.out.println(ow.writeValueAsString(rm));

			System.out.println("Home team id: " + rm.getHomeTeamId());
			System.out.println("Away team id: " + rm.getAwayTeamId());

			Teams ht = teamsRepository.findById(rm.getHomeTeamId().toString()).get();
			Teams at = teamsRepository.findById(rm.getAwayTeamId().toString()).get();

			Fixtures f = new Fixtures();

			f.setHomeTeamScore(rm.getHomeTeamScore());
			f.setAwayTeamScore(rm.getAwayTeamScore());
			f.setKickOffTime(rm.getKickOffTimeUtc());
			f.setSportsRadarId(rm.getSourceId());
			f.setHomeTeam(ht);
			f.setAwayTeam(at);
			f.setSport(ht.getSport());

			fixturesRepository.save(f);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}