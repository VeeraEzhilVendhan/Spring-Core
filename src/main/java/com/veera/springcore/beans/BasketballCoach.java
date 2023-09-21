package com.veera.springcore.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("basketballcoach")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Primary
public class BasketballCoach implements Coach
{
    @Override
    public String todayTask()
    {
        return "practice basketball";
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
