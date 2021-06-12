package ru.getman.java.core;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentImpl student = new StudentImpl();
        List<Course> courseList = new ArrayList<>();
        courseList.add(new CourseImpl("Math"));
        courseList.add(new CourseImpl("Math"));
        courseList.add(new CourseImpl("Prog"));
        courseList.add(new CourseImpl("Java"));
        student.setCourseList(courseList);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);


	Homework homework = new Homework();
	List<Course> courses = homework.getUniqueCourses(studentList);
        for (Course c : courses) {
            System.out.println(c.getName());
        }
    }
}
