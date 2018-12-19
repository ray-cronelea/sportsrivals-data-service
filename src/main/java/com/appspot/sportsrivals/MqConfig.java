package com.appspot.sportsrivals;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

	private static final String topicExchangeName = "sportsrivals_local";
	private static final String queueResults = "results_local";
	private static final String queueRating = "rating_local";

	@Bean
	Queue queueResults() {
		//To set durability: return new Queue(queueName, false);
		return new Queue(queueResults);
	}

	@Bean
	Queue queueRating() {
		return new Queue(queueRating);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding bindingResults(Queue queueResults, TopicExchange exchange) {
		return BindingBuilder.bind(queueResults)
				.to(exchange)
				.with("results.#");
	}

	@Bean
	Binding bindingRatingTeam(Queue queueRating, TopicExchange exchange) {
		return BindingBuilder.bind(queueRating)
				.to(exchange)
				.with("rating.#");
	}

}
