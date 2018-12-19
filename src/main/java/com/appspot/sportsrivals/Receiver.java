package com.appspot.sportsrivals;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@RabbitListener(queues = "#{queueResults.name}")
	public void receiveResults(String message) throws InterruptedException{
		System.out.println("queueResults Received <" + message + ">");
	}

	@RabbitListener(queues = "#{queueRatingTeam.name}")
	public void receiveRatingTeam(String message) throws InterruptedException{
		System.out.println("queueRatingTeam Received <" + message + ">");
	}

	@RabbitListener(queues = "#{queueRatingLocation.name}")
	public void receiveRatingLocation(String message) throws InterruptedException{
		System.out.println("queueRatingLocation Received <" + message + ">");
	}

}