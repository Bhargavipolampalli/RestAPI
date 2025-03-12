package com.bhar.service;

import java.util.List;
import java.util.Optional;

import com.bhar.entity.Student;

public interface StudentService {
	 public Student createStudent(Student student);
	 public List<Student> getAllStudents();
	 public Optional<Student> getStudentById(Long id);
	 public Student updateStudent(Long id, Student studentDetails);
	 public String deleteStudent(Long id);

}
