package com.example.springbooth2databaseexample.repository;

 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springbooth2databaseexample.model.Student;
 
 
 
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{
 
}
	