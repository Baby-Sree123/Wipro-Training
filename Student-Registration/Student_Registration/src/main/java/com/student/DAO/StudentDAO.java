package com.student.DAO;

import java.util.List;
import com.student.model.Student;

public interface StudentDAO {
    void addStudent(Student student);
    Student getStudent(int studentId);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    List<Student> getAllStudents();
}
