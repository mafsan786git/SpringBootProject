package com.masai.firstapp.student_review.repository;

import com.masai.firstapp.student_review.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,String> {
}
