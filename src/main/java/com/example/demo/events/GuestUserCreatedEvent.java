package com.example.demo.events;

import com.example.demo.entity.GuestUser;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GuestUserCreatedEvent extends Event<GuestUser>{

}
