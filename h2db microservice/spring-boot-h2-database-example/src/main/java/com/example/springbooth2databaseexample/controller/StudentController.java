package com.example.springbooth2databaseexample.controller;

import java.util.List;

import org.apache.tomcat.jni.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbooth2databaseexample.model.Student;
import com.example.springbooth2databaseexample.service.StudentService;

import io.micrometer.core.ipc.http.HttpSender.Response;
 
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	// creating a get mapping that retrieves all the students detail from the
	// database
	@GetMapping("/student")
	private List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/student/{id}")
	private Student getStudent(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}

	// creating a delete mapping that deletes a specific student
	@DeleteMapping("/student/{id}")
	private void deleteStudent(@PathVariable("id") int id) {
		studentService.delete(id);
	}

	// creating post mapping that post the student detail in the database
	@PostMapping("/student")
	private int saveStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student.getId();
	}
	// creating post mapping that post the student detail in the database
		@PostMapping("/students")
		private String saveStudentAll(@RequestBody List<Student> students) {
			
			for(Student student :students )
			studentService.saveOrUpdate(student);
			return  "Add Successfully";
		}
}
