package com.example.demo.services;

import com.example.demo.entity.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	
	public Flux<Client> findAll();
	
	public Mono<Client> findById(String id);
	
	public Mono<Client> save(Client client);
	
	public Mono<Void> deleteById(String id);
	
	public Mono<Client> requestPurchase(Client client);

}
