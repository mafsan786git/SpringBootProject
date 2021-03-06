package com.masai.firstapp.student_review.service;


import com.masai.firstapp.student_review.entity.Subject;
import com.masai.firstapp.student_review.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepo;
    public List<Subject> getAllSubjects() {
        List<Subject> subject1 = subjectRepo.findAll();
        return  subject1;
    }

    public Subject addSubject(Subject subject) {
        Subject subject1 = subjectRepo.save(subject);
        return  subject1;
    }

    public String updateSubject(Subject subject) {
        Optional<Subject> subject1 = subjectRepo.findById(subject.getSubjectId());
        if(subject1.isEmpty())
            return "Error in repository";
        subject1.get().setSubjectName(subject.getSubjectName());
        subjectRepo.save(subject1.get());
        return "Info added successfully";
    }

    public  String deleteSubject(String subjectId){
        Optional<Subject> subject1 = subjectRepo.findById(subjectId);
        if(subject1.isEmpty())
            return "data is present for this id";
        try{
            subjectRepo.delete(subject1.get());
            return "Successfully Deleted";
        }catch (Exception e) {
            return "Delete failed";
        }

    }
}
