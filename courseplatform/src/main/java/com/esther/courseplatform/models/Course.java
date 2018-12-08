package com.esther.courseplatform.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=1, message="Name is required.")
	private String name;
	@Size(min=1, message="Instructor is required.")
	private String instructor;
	@NotNull(message="Capacity is required")
	@Min(value = 1, message="Capacity must be greater than 0")
	private Integer capacity;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "courses_students",
    		joinColumns = @JoinColumn(name = "course_id"),
    		inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    
    public Course() {
    	
    }
    
    
    
    
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}


	


	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getInstructor() {
		return instructor;
	}




	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}




	public Integer getCapacity() {
		return capacity;
	}




	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	



	public List<Student> getStudents() {
		return students;
	}




	public void setStudents(List<Student> students) {
		this.students = students;
	}




	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
}
