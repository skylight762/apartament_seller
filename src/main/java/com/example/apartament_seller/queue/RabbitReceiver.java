package com.example.apartament_seller.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RabbitReceiver {
    @Autowired
    AnnotationConfigApplicationContext context;

    public void reciveMessage(String message){
        System.out.println("Received <" + message + ">");
        this.context.close();
    }
}
