package com.phani.springbootquickstart.course_api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/topics")
	public List<Topic> listAllTopics() {
		return Arrays.asList(
				new Topic("Hadoop", "Hadoop EcoSystem", "Hadoop Description"), 
				new Topic("Jersey", "Java Jersey", "REST API using Jersey"), 
				new Topic("Spring", "SpringBoot Framework", "REST API using Jersey")
				); 
				
	}
}
