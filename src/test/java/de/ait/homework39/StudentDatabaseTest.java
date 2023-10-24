package de.ait.homework39;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    @Test
    void addStudentSuccess() {
        Student student = new Student(1, "Mustermann", 25);
        Assertions.assertEquals(0, studentDatabase.getStudents().size());
        Assertions.assertTrue(studentDatabase.addStudent(student));
        Assertions.assertEquals(1, studentDatabase.getStudents().size());
        Set<Student> studentHashSet = studentDatabase.getStudents();
        for (Student databaseStudent : studentHashSet) {
            Assertions.assertEquals(databaseStudent, student);
        }
    }

    @Test
    void addStudentNull() {
        Assertions.assertFalse(studentDatabase.addStudent(null));
    }

    @Test
    void addStudentFailStudentExist() {
        Student student = new Student(1, "Mustermann", 25);
        Student newStudent = new Student(1, "Mustermann", 25);
        Assertions.assertEquals(0, studentDatabase.getStudents().size());
        studentDatabase.addStudent(student);
        Assertions.assertFalse(studentDatabase.addStudent(newStudent));
        Assertions.assertEquals(1, studentDatabase.getStudents().size());
    }

    @Test
    void removeStudentSuccess() {
        Student student = new Student(1, "Mustermann", 25);
        Assertions.assertEquals(0, studentDatabase.getStudents().size());
        studentDatabase.addStudent(student);
        Assertions.assertEquals(1, studentDatabase.getStudents().size());
        studentDatabase.removeStudent(student);
        Assertions.assertEquals(0, studentDatabase.getStudents().size());
    }

    @Test
    void removeStudentFailStudentNull() {
        Assertions.assertFalse(studentDatabase.removeStudent(null));
    }

    @Test
    void removeStudentFailNotExist() {
        Student student = new Student(1, "Mustermann", 25);
        Assertions.assertFalse(studentDatabase.removeStudent(student));
    }
}