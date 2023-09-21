package com.veera.springcore.controllers;

import com.veera.externalbeans.AWS;
import com.veera.springcore.beans.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DependencyInjectionController
{
    Coach c1;

    Coach c2;

    @Autowired
    @Qualifier("footballcoach")
    Coach c3;

    @Value("${IDE.name}")
    String IDE;

    @Autowired
    public DependencyInjectionController(@Qualifier("cricketcoach") Coach c)
    {
        this.c1=c;
    }

    public Coach getC2()
    {
        return c2;
    }

    @Autowired
    public void setC2(@Qualifier("basketballcoach") Coach c)
    {
        this.c2 = c;
    }

    @GetMapping("/constructor-di")
    public String getTodayTask()
    {
        return c1.todayTask();
    }

    @GetMapping("/setter-di")
    public String getTodayTaskSetter()
    {
        return c2.todayTask();
    }

    @GetMapping("/field-di")
    public String getTodayTaskField()
    {
        return c3.todayTask();
    }

    @GetMapping("/field")
    public String getIDEname()
    {
        return IDE;
    }

    @GetMapping("/externalbean-di")
    public String getDeploymentStatus()
    {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(Config_ExternalBeans.class);
        AWS aws=context.getBean("getAWS", AWS.class);
        return aws.performDeployment();
    }
}
