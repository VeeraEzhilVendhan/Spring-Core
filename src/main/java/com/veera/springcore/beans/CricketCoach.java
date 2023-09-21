package com.veera.springcore.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cricketcoach")
@Scope("prototype")
// @Lazy
public class CricketCoach implements Coach
{
    @Override
    public String todayTask()
    {
        return "practice bowling";
    }

    @PostConstruct
    public void startUp()
    {
        System.out.println("startup method "+this.getClass().getSimpleName());
    }

    @PreDestroy
    public void shuttingDown()
    {
        System.out.println("shuttingdown method "+this.getClass().getSimpleName());
    }
}
