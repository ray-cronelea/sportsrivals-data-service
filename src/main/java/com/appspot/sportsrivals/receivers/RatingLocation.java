package com.appspot.sportsrivals.receivers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RatingLocation {

	@RabbitListener(queues = "#{queueRatingLocation.name}")
	public void receiveRatingLocation(String message) throws InterruptedException{



	}

}