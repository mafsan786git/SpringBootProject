package com.masai.firstapp.student_review.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
    @Id
    private String subjectId;
    private String subjectName;

    public Subject(){}

    public Subject(String subjectId,String subjectName){
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
