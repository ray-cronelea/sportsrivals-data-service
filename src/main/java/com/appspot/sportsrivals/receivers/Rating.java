package com.appspot.sportsrivals.receivers;

import com.appspot.sportsrivals.data.CitiesRepository;
import com.appspot.sportsrivals.data.SportsRepository;
import com.appspot.sportsrivals.data.StatesRepository;
import com.appspot.sportsrivals.data.TeamsRepository;
import com.appspot.sportsrivals.model.Teams;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Rating {

	private SportsRepository sportsRepository;
	private CitiesRepository citiesRepository;
	private StatesRepository statesRepository;
	private TeamsRepository teamsRepository;

	@Autowired public void setSportsRepository(SportsRepository sportsRepository) { this.sportsRepository = sportsRepository; }
	@Autowired public void setCitiesRepository(CitiesRepository citiesRepository) { this.citiesRepository = citiesRepository; }
	@Autowired public void setStatesRepository(StatesRepository statesRepository) { this.statesRepository = statesRepository; }
	@Autowired public void setTeamsRepositoryInterface(TeamsRepository teamsRepository) { this.teamsRepository = teamsRepository; }

	@RabbitListener(queues = "#{queueRating.name}")
	public void receiveRating(String message) throws InterruptedException{
		System.out.println("queueRating Received <" + message + ">");
		try {
			// Convert json string to object
			// TODO: decide on format of RabbitMQ message format
			Teams team = new ObjectMapper().readValue(message,Teams.class);
			// System.out.println("Team object: " + team.toString());
			// Print object as json formatted for debugging
			// ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			// System.out.println(ow.writeValueAsString(team));

			// Get team by name and increment rating as placeholder
			// TODO: decide on using name or id for search
			List<Teams> res = teamsRepository.findByName(team.getName());
			Teams t = res.get(0);
			// TODO: Get new rating value from message
			int newRating = t.getRating() + 1;
			t.setRating(newRating);
			teamsRepository.save(t);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occurred mapping message to team object");
		}
	}
}