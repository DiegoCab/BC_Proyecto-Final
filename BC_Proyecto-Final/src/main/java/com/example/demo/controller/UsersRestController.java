package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.entity.GuestUser;
import com.example.demo.services.ClientService;
import com.example.demo.services.GuestUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UsersRestController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private GuestUserService guestUserService;
	
	// Clients endpoints
    @GetMapping("/client")
    public Flux<Client> getAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/client/{id}")
    public Mono<Client> getClient(@PathVariable String id) {
        return clientService.findById(id);
    }
    
	@PostMapping("/client/save")
	public Mono<Client> savePerson(@RequestBody Client client) {
		 return clientService.save(client);
	}
	
    @DeleteMapping("/client/delete/{id}")
    public Mono<Void> deleteClient(@PathVariable String id) {
        return clientService.deleteById(id);
    }
    
    // GuestUser endpoints
    @GetMapping("/guestuser")
    public Flux<GuestUser> getAllGuestUsers() {
        return guestUserService.findAll();
    }

    @GetMapping("/guestuser/{docNumber}")
    public Mono<GuestUser> getGuestUser(@PathVariable String docNumber) {
        return guestUserService.findByDocumentNumber(docNumber);
	}
	
    @DeleteMapping("/guestuser/delete/{docNumber}")
    public Mono<Void> deleteGuestUser(@PathVariable String docNumber) {
        return guestUserService.deleteByDocumentNumber(docNumber);
    }

}
