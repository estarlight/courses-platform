package com.esther.courseplatform.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.esther.courseplatform.models.Course;
import com.esther.courseplatform.models.Student;
import com.esther.courseplatform.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public List<Student> allStudents(){
		return studentRepo.findAll();
	}
	
	
	
    public Student registerStudent(Student student) {
        String hashed = BCrypt.hashpw(student.getPassword(), BCrypt.gensalt());
        student.setPassword(hashed);
        return studentRepo.save(student);
    }
    
    public Student findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
    
    public Student findStudentById(Long id) {
    	Optional<Student> student = studentRepo.findById(id);
    	
    	if(student.isPresent()) {
            return student.get();
    	} else {
    	    return null;
    	}
    }

    public boolean authenticateUser(String email, String password) {
    
        Student student = studentRepo.findByEmail(email);
      
        if(student == null) {
            return false;
        } else {
      
            if(BCrypt.checkpw(password, student.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void addCourseToStudent (Student student, Course course) {
    	List<Course> courseList = student.getCourses();
    	courseList.add(course);
    	student.setCourses(courseList);
    	studentRepo.save(student);
    }

}
