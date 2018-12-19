package com.appspot.sportsrivals.receivers;

import com.appspot.sportsrivals.model.Teams;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RatingTeam {

	@RabbitListener(queues = "#{queueRatingTeam.name}")
	public void receiveRatingTeam(String message) throws InterruptedException{
		System.out.println("queueRatingTeam Received <" + message + ">");
		try {
			//Convert json string to object
			Teams team = new ObjectMapper().readValue(message,Teams.class);
			System.out.println("Team object: " + team.toString());

			// Print object as json formatted
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			System.out.println(ow.writeValueAsString(team));

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occurred mapping message to team object");
		}

	}

}