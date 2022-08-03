package com.example.demo.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.entity.GuestUser;
import com.example.demo.events.Event;
import com.example.demo.events.EventType;
import com.example.demo.events.GuestUserCreatedEvent;

@Component
public class GuestUserEventService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.guestuser.name:guestusers}")
	private String topicGuestUser;
	
	public void publish(GuestUser guestUser) {

		GuestUserCreatedEvent created = new GuestUserCreatedEvent();
		created.setData(guestUser);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicGuestUser, created);
	}

}
