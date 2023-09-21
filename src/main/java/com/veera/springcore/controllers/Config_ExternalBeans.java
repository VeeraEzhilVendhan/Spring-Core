package com.veera.springcore.controllers;

import com.veera.externalbeans.AWS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config_ExternalBeans
{
    @Bean
    public AWS getAWS()
    {
        AWS aws = new AWS();
        return aws;
    }
}
