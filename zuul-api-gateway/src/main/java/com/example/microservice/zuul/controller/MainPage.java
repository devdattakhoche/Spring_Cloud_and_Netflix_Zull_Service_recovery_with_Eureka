package com.example.microservice.zuul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainPage {
	
	 @Autowired
	 private KafkaTemplate<String, DevList> kafkaTemplate;

	 private static final String TOPIC = "Kafka_Example2";
	
	 @GetMapping("/form")
	 public ModelAndView getMain() 
	 {
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("form", MainPage.class);
		 return modelAndView;
	 }
	
	 @PostMapping("/form")
	 public String sendData (@RequestParam("key") int key,@RequestParam("name")String name) 
	 {
		 DevList d = new DevList(key,name);
		 try {
		    	kafkaTemplate.send(TOPIC,d);
		 }catch(Exception e) {
			 System.out.println("Error in kafka template" + e);
		 }
		 
		 return "redirect:/first/first-service";
	}
	 
}
