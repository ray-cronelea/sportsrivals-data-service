package com.appspot.sportsrivals;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

	private static final String topicExchangeName = "sportsrivals";
	private static final String queueResults = "results";
	private static final String queueRanking = "ranking";

	@Bean
	Queue queueResults() {
		//To set durability: return new Queue(queueName, false);
		return new Queue(queueResults);
	}

	@Bean
	Queue queueRanking() {
		return new Queue(queueRanking);
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
	Binding bindingRanking(Queue queueRanking, TopicExchange exchange) {
		return BindingBuilder.bind(queueRanking)
				.to(exchange)
				.with("ranking.#");
	}

}
