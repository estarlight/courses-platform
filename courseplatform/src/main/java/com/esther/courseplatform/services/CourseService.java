package com.esther.courseplatform.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.esther.courseplatform.models.Course;
import com.esther.courseplatform.models.Student;
import com.esther.courseplatform.repositories.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepo;
	
	public CourseService(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}
	
	public List<Course> allCourses(){
		return courseRepo.findAll();
	}
	
	public Course addCourse(Course c) {
		return courseRepo.save(c);
	}
	
	public void deleteCourse(Course c) {
		courseRepo.delete(c);
	}
	
    public Course findCourseById(Long id) {
    	Optional<Course> course = courseRepo.findById(id);
    	
    	if(course.isPresent()) {
            return course.get();
    	} else {
    	    return null;
    	}
    }

}
