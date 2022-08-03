package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BootCoin;
import com.example.demo.entity.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.services.ClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientDao;
	
	@Override
    public Flux<Client> findAll() {
        return clientDao.findAll();
    }
	
	@Override
    public Mono<Client> findById(String id) {
        return clientDao.findById(id);
    }
	
	@Override
    public Mono<Client> save(Client client) {
        return clientDao.save(client);
    }
	
	@Override
    public Mono<Void> deleteById(String id) {
        return clientDao.deleteById(id);
    }
	
	@Override
    public Mono<Client> requestPurchase(Client client) {
		
		List bootcoin = new ArrayList<BootCoin>();
        BootCoin bc1 = new BootCoin();
        bootcoin.add(bc1);
        
      
        if(client.getPayType().equals("Yanki")){
        	bc1.setTransactionNumber("YNK-587539657");
        	bc1.setPurchaseTax("10%");
        	bc1.setSellTax("14%");
        }else{ 
        	bc1.setTransactionNumber("TN-768456792");
        	bc1.setPurchaseTax("17%"); 
        	bc1.setSellTax("20%");
        }
        return clientDao.requestPurchase(client);
    }

}
