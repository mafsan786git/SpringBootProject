package com.masai.firstapp.student_review.controller;

import com.masai.firstapp.student_review.entity.Subject;
import com.masai.firstapp.student_review.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @GetMapping("/subjects")
    public List<Subject> getAllSubjects(){
        List<Subject> subject1 = subjectService.getAllSubjects();
        return subject1;
    }

    @PostMapping("/subjects")
    public Subject addSubject(@RequestBody Subject subject){
        Subject subject1 = subjectService.addSubject(subject);
        return subject1;
    }

    @PutMapping("/subjects")
    public String updateSubject(@RequestBody Subject subject){
        String subject1 = subjectService.updateSubject(subject);
        return subject1;
    }

    @DeleteMapping("/subjects/{id}")
    public String deleteSubject(@PathVariable("id") String subjectId){
        String subject1 = subjectService.deleteSubject(subjectId);
        return  subject1;
    }

}
