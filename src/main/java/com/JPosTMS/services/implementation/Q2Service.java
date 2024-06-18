package com.JPosTMS.services.implementation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.jpos.q2.Q2;
import org.springframework.stereotype.Service;

@Service
public class Q2Service {

    private Q2 q2;

    @PostConstruct
    public void init(){
        Q2 q2 = new Q2();
        q2.start();
    }

    @PreDestroy
    public void shutdown(){
        q2.shutdown();
    }
}
