package com.bhar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhar.entity.Student;
import com.bhar.service.StudentService;

@RestController
public class StudentController {
	@Autowired
    private StudentService studentService;
	
	

    
    public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
    	List<Student> allStudents=studentService.getAllStudents();
        return new ResponseEntity<>(allStudents,HttpStatus.OK);
    }

    // Get student by ID
    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student1 = studentService.getStudentById(id);
        if (student1.isPresent()) {
            return new  ResponseEntity<Student>(student1.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   
    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent,HttpStatus.CREATED);
    }

  
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
       Optional<Student> student=studentService.getStudentById(id);
       if(student.isPresent()) {
    	   Student updatedStudent=studentService.updateStudent(id, studentDetails);
    	   return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
       }else {
    	   return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
       }
    }

  
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        String msg=studentService.deleteStudent(id);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }



}
