package com.phani.springbootquickstart.course_api.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics =  new ArrayList<>(Arrays.asList(
			new Topic("Hadoop", "Hadoop EcoSystem", "Hadoop Description"), 
			new Topic("Jersey", "Java Jersey", "REST API using Jersey"), 
			new Topic("Spring", "SpringBoot Framework", "REST API using SpringBoot Framework")
			));

	public List<Topic> getAllTopics() {
		return topics; 
		
	} 
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}
	
	
}
