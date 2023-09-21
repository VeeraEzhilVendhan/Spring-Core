package com.veera.springcore.controllers;

import com.veera.springcore.SpringCoreApplication;
import com.veera.springcore.beans.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InversionofControl
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringCoreApplication.class);

//        DependencyInjectionController di=context.getBean("dependencyInjectionController",DependencyInjectionController.class);
//        System.out.println(di.getTodayTask());

        Coach bc = context.getBean("basketballcoach",Coach.class); // lifecycle methods
        Coach fc = context.getBean("footballcoach",Coach.class);
        Coach cc = context.getBean("cricketcoach",Coach.class); // lifecycle methods, lazy applied or applying lazy to all

        System.out.println(bc.todayTask());
        System.out.println(fc.todayTask());
        System.out.println(cc.todayTask());

        // scope - singleton
        Coach bc1 = context.getBean("basketballcoach",Coach.class);
        System.out.println(bc+" "+bc1+" "+(bc==bc1));

        // scope - prototype
        Coach cc1 = context.getBean("cricketcoach",Coach.class);
        System.out.println(cc+" "+cc1+" "+(cc==cc1));

        context.close();
    }
}
