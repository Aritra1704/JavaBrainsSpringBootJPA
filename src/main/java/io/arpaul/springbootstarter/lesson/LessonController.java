package io.arpaul.springbootstarter.lesson;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.arpaul.springbootstarter.course.Course;
import io.arpaul.springbootstarter.topic.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;

	@RequestMapping("/topics/{topicId}/courses/{courseId}/lesson")
	public List<Lesson> getAllLesson(@PathVariable String topicId, @PathVariable String courseId) {
		return lessonService.getAllLesson(topicId, courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lesson/{lessonId}")
	public Lesson getLesson(@PathVariable String lessonId) {
		return lessonService.getLesson(lessonId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lesson")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lesson/{lessonId}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lesson/{lessonId}")
	public void deleteLesson(@PathVariable String lessonId) {
		lessonService.deleteLesson(lessonId);
	}
}
