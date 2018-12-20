package com.appspot.sportsrivals.receivers;

import com.appspot.sportsrivals.receivers.model.ResultsMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Results {

	@RabbitListener(queues = "#{queueResults.name}")
	public void receiveResults(String message) {
		System.out.println("queueResults Received <" + message + ">");
		try {

			ResultsMessage rm = new ObjectMapper().readValue(message, ResultsMessage.class);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			System.out.println(ow.writeValueAsString(rm));




		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}