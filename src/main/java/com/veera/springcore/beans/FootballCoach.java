package com.veera.springcore.beans;

import org.springframework.stereotype.Component;

@Component("footballcoach")
public class FootballCoach implements Coach
{
    public String todayTask()
    {
        return "practice goal keeping";
    }
}
