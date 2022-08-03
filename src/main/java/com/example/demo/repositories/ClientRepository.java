package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;

import reactor.core.publisher.Mono;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
	public Mono<Client> requestPurchase(Client client);

}
