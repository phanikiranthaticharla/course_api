package com.phani.springbootquickstart.course_api.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics =  Arrays.asList(
			new Topic("Hadoop", "Hadoop EcoSystem", "Hadoop Description"), 
			new Topic("Jersey", "Java Jersey", "REST API using Jersey"), 
			new Topic("Spring", "SpringBoot Framework", "REST API using SpringBoot Framework")
			);

	public List<Topic> getAllTopics() {
		return topics; 
		
	} 
	
	
}
