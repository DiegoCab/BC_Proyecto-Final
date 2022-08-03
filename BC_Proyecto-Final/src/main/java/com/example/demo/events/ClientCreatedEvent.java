package com.example.demo.events;

import com.example.demo.entity.Client;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientCreatedEvent extends Event<Client>{

}
