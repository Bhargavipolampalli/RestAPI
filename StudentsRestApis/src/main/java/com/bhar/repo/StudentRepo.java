package com.bhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhar.entity.Student;

public interface StudentRepo extends  JpaRepository<Student, Long> {

}
