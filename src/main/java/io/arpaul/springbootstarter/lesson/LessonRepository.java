package io.arpaul.springbootstarter.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, String> {

//	public List<Lesson> findByTopicId(String topicId);
	public List<Lesson> findByCourseId(String courseId);
}
