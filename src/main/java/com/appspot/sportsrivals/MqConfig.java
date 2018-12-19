package com.appspot.sportsrivals;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

	// MQ SETUP
	private static final String topicExchangeName = "sportsrivals";
	private static final String queueResults = "results";
	private static final String queueRatingTeam = "rating-team";
	private static final String queueRatingLocation = "rating-location";

	@Bean
	Queue queueResults() {
		//To set durability: return new Queue(queueName, false);
		return new Queue(queueResults);
	}

	@Bean
	Queue queueRatingTeam() {
		return new Queue(queueRatingTeam);
	}

	@Bean
	Queue queueRatingLocation() {
		return new Queue(queueRatingLocation);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding bindingResults(Queue queueResults, TopicExchange exchange) {
		return BindingBuilder.bind(queueResults)
				.to(exchange)
				.with("Results.#");
	}

	@Bean
	Binding bindingRatingLocation(Queue queueRatingLocation, TopicExchange exchange) {
		return BindingBuilder.bind(queueRatingLocation)
				.to(exchange)
				.with("Rating.Location");
	}

	@Bean
	Binding bindingRatingTeam(Queue queueRatingTeam, TopicExchange exchange) {
		return BindingBuilder.bind(queueRatingTeam)
				.to(exchange)
				.with("Rating.Team");
	}

}
