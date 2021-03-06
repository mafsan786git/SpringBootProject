package com.masai.firstapp.student_review.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    String studentId;
    String studentName;
    String studentSection;
    public Student(){

    }
    public Student(String studentId,String studentName,String studentSection){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSection = studentSection;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentSection() {
        return studentSection;
    }
    public void setStudentSection(String studentSection) {
        this.studentSection = studentSection;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentSection='" + studentSection + '\'' +
                '}';
    }
}
