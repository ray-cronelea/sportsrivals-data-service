package com.appspot.sportsrivals.receivers;

import com.appspot.sportsrivals.model.Teams;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Results {

	@RabbitListener(queues = "#{queueResults.name}")
	public void receiveResults(String message) throws InterruptedException{
		System.out.println("queueResults Received <" + message + ">");
	}

}