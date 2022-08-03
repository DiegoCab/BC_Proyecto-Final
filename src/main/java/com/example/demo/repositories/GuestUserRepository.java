package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GuestUser;

import reactor.core.publisher.Mono;

@Repository
public interface GuestUserRepository extends ReactiveMongoRepository<GuestUser, String> {
	public Mono<GuestUser> findByDocumentNumber(String docNumber);
	public Mono<Void> deleteByDocumentNumber(String docNumber);
	

}
