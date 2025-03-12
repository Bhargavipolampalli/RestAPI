package com.bhar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhar.entity.Student;
import com.bhar.repo.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService {
 
	@Autowired
    private StudentRepo studentRepo;
	 @Override
	 public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

	 @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
       Optional<Student> stu=studentRepo.findById(id);
       if(stu.isPresent()) {
    	   Student s=stu.get();
    	   s.setName(studentDetails.getName());
    	   s.setEmail(studentDetails.getEmail());
    	   s.setAddress(studentDetails.getAddress());
    	   return studentRepo.save(s);
    	   }
       return null;
       
    }

   @Override
    public String deleteStudent(Long id) {
        studentRepo.deleteById(id);
        return "Student Data Deleted Successfully";
    }
}
