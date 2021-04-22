package io.arpaul.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLesson(String topicId, String courseId) {
		System.out.println("Lesson: Topic >> "+topicId+", Course >> "+courseId);
		List<Lesson> lessons = new ArrayList<>();
//		lessonRepository.findByTopicId(topicId).stream().filter(course -> course.getId().equals(courseId));
		lessonRepository.findByCourseId(courseId).forEach(lessons::add);
		return lessons;
	}
	
	public Lesson getLesson(String id) {
		System.out.println("Lesson: id >> "+id);
		return lessonRepository.findById(id).get();
	}

	public void addLesson(Lesson lesson) {
		System.out.println("Lesson: id >> "+lesson.getId()+", name >> "+lesson.getName()+", desc >> "+lesson.getDescription());
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) {
		System.out.println("Lesson: id >> "+lesson.getId()+", name >> "+lesson.getName()+", desc >> "+lesson.getDescription());
		lessonRepository.save(lesson);
	}

	public void deleteLesson(String id) {
		System.out.println("Lesson: id >> "+id);
		lessonRepository.deleteById(id);
	}
}
