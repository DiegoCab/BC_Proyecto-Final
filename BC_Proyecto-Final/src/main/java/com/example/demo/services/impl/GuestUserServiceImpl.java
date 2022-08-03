package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.GuestUser;
import com.example.demo.repositories.GuestUserRepository;
import com.example.demo.services.GuestUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GuestUserServiceImpl implements GuestUserService {
	
	@Autowired
	private GuestUserRepository guestUserDao;
	
	@Override
    public Flux<GuestUser> findAll() {
        return guestUserDao.findAll();
    }
	
	@Override
    public Mono<GuestUser> findByDocumentNumber(String docNumber) {
        return guestUserDao.findByDocumentNumber(docNumber);
    }
	
	public Mono<Void> deleteByDocumentNumber(String docNumber) {
        return guestUserDao.deleteByDocumentNumber(docNumber);
    }

}
