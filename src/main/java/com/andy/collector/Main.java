/*
 * Copyright (c) ...
 */

package com.andy.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Main class of the application. Creates new object of CardCollector class and turns it visible.
 * 
 * @version		0.1 14. May 2020
 * @author 		Andrej Marcan
 */
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.andy.collector.repository")
public class Main {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication app = new SpringApplication(Main.class);
     	app.run();	
    }
}




















