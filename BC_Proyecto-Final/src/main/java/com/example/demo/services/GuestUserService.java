package com.example.demo.services;



import com.example.demo.entity.GuestUser;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GuestUserService {
	
    public Flux<GuestUser> findAll();
	
	public Mono<GuestUser> findByDocumentNumber(String docNumber);
	
	public Mono<Void> deleteByDocumentNumber(String docNumber);

}
