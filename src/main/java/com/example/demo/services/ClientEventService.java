package com.example.demo.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Client;
import com.example.demo.events.ClientCreatedEvent;
import com.example.demo.events.Event;
import com.example.demo.events.EventType;

@Component
public class ClientEventService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.client.name:clients}")
	private String topicClient;
	
	public void publish(Client client) {

		ClientCreatedEvent created = new ClientCreatedEvent();
		created.setData(client);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicClient, created);
	}

}
