package com.phani.springbootquickstart.course_api.topic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService; 
	
	
	@GetMapping("/topics")
	public List<Topic> listAllTopics() {
		return topicService.getAllTopics();
				
	}
	
	@GetMapping("/topics/{topicId}")
	public Topic getTopic(@PathVariable String topicId) {
		return topicService.getTopic(topicId);
	}
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
}
