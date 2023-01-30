package com.phani.springbootquickstart.course_api.topic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class TopicController {

	private final TaskExecutor taskExecutor;

	public TopicController(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	@Autowired
	private TopicService topicService; 
	
	
	@GetMapping("/topics")
	public DeferredResult<List<Topic>> listAllTopics() {
		DeferredResult<List<Topic>> deferredResult = new DeferredResult<>();
		taskExecutor.execute(() -> {
			List<Topic> data = topicService.getAllTopics();
			deferredResult.setResult(data);
		});
		return deferredResult;
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
