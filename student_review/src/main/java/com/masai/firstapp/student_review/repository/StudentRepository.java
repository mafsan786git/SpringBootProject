package com.masai.firstapp.student_review.repository;


import com.masai.firstapp.student_review.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

}
