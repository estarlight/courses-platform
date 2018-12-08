package com.esther.courseplatform.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esther.courseplatform.models.Course;
import com.esther.courseplatform.models.CourseStudent;
import com.esther.courseplatform.models.Student;
import com.esther.courseplatform.services.CourseService;
import com.esther.courseplatform.services.StudentService;
import com.esther.courseplatform.services.csService;
import com.esther.courseplatform.validator.StudentValidator;


@Controller
public class CourseController {
	private final StudentService sService;
	private final CourseService cService;
	private final csService csService;
	private final StudentValidator studentValidator;
	
	public CourseController(StudentService sService, CourseService cService, csService csService, StudentValidator studentValidator) {
		this.sService = sService;
		this.cService = cService;
		this.csService = csService;
		this.studentValidator = studentValidator;
	}
	
	@RequestMapping("/")
	public String indexPage(@ModelAttribute("student") Student student) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String registerStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, HttpSession session) {
		System.out.println("came to /register in controller");
		
		studentValidator.validate(student, result);
		
		if (result.hasErrors()) {
			System.out.println("errors portion in controller");
			return "index.jsp";
		} else {
			System.out.println("else no errors portion in controller");
			Student newStudent = sService.registerStudent(student);
			Long id = newStudent.getId();
			session.setAttribute("id", id);
	      
			return "redirect:/courses";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("student") Student student) {
		System.out.println("Came to /login in controller");
		boolean check = sService.authenticateUser(email, password);
    	if (check == true) {
    		System.out.println("Came to boolean true section");
    		Student s = sService.findByEmail(email);
    		session.setAttribute("id", s.getId());
    		return "redirect:/courses";
    	}
    	else {
    		System.out.println("Came to boolean false error section section");
    		model.addAttribute("error", "Username and password do not match.");
    		return "index.jsp";
    	}
	}

	@RequestMapping("/courses")
	public String showCourses(Model model, HttpSession session) {
		if (session != null) {
		Long id = (Long) session.getAttribute("id");
		Student student = sService.findStudentById(id);
   	 	model.addAttribute("student", student);
   	 	List<Course> courses = cService.allCourses();
   	 	model.addAttribute("courses", courses);
   	 return "welcome.jsp";
	}
		
		else {
			return "redirect:/";
			
		}
		
   	 	
   	 	
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
	    }
	
	@RequestMapping("/courses/new")
	public String addCourse(@ModelAttribute("course") Course course) {
		return "add.jsp";
	}
	
	
	@PostMapping("/courses/new")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("errors portion in controller");
			return "add.jsp";
		} else {
			System.out.println("else no errors portion in controller");
			Course newCourse = cService.addCourse(course);
	      
			return "redirect:/courses";
		}
	}
	
	@RequestMapping("courses/{id}")
	public String show(@PathVariable("id") Long id, Model model, @ModelAttribute("course") Course courses) {
		Course course = cService.findCourseById(id);
		model.addAttribute("course", course);
		
		List<Student> studentList = course.getStudents();
		int count = studentList.size();
		model.addAttribute("count", count);
		
		List<CourseStudent> connectionList = csService.connectionsByCourse(course);
		model.addAttribute("connectList", connectionList);
		return "show.jsp";
	}
	
	@RequestMapping("courses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Course course = cService.findCourseById(id);
		model.addAttribute("course", course);
		return "edit.jsp";
	}
	
	@RequestMapping("courses/{id}/delete")
	public String delete(@PathVariable("id") Long id, Model model) {
		Course course = cService.findCourseById(id);
		cService.deleteCourse(course);
		return "redirect:/courses";
	}
	
	@RequestMapping(value="/courses/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("course") Course c, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			cService.addCourse(c);
			return "redirect:/courses/{id}";
		}
		
	}
	
	@RequestMapping("/add/{id}")
	public String addCourse(@PathVariable("id") Long id, HttpSession session) {
		Course course = cService.findCourseById(id);
		Long studentId = (Long) session.getAttribute("id");
		Student student = sService.findStudentById(studentId);
//		CourseStudent connect = new CourseStudent();
//		connect.setCourse(course);
//		connect.setStudent(student);
//		csService.addConnection(connect);
		
		sService.addCourseToStudent(student, course);
		
		return "redirect:/courses";
		
	}
	
	
	
	
	
	
	
	
	
}
