package ru.getman.java.core;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Course> courseList = new ArrayList<>();
        courseList.add(new CourseImpl("Math"));
        courseList.add(new CourseImpl("HTML"));
        courseList.add(new CourseImpl("DataScience"));
        courseList.add(new CourseImpl("Prog"));
        courseList.add(new CourseImpl("Java"));
        courseList.add(new CourseImpl("C++"));
        List<Course> courseList2 = new ArrayList<>();
        courseList2.add(new CourseImpl("Java"));
        courseList2.add(new CourseImpl("Java"));
        courseList2.add(new CourseImpl("Java"));
        courseList2.add(new CourseImpl("QA"));
        courseList2.add(new CourseImpl("BigData"));
        courseList2.add(new CourseImpl("BigData"));
        courseList2.add(new CourseImpl("BigData"));
        List<Course> courseList3 = new ArrayList<>();
        courseList3.add(new CourseImpl("Math"));
        courseList3.add(new CourseImpl("Math"));
        courseList3.add(new CourseImpl("QA"));
        courseList3.add(new CourseImpl("Prog"));
        courseList3.add(new CourseImpl("Java"));
        List<Course> courseList4 = new ArrayList<>();
        courseList4.add(new CourseImpl("Java"));
        courseList4.add(new CourseImpl("HTML"));
        courseList4.add(new CourseImpl("Java"));
        courseList4.add(new CourseImpl("Java"));
        courseList4.add(new CourseImpl("Prog"));

        StudentImpl student = new StudentImpl();
        student.setCourseList(courseList);
        student.setName("Вася");
        StudentImpl student2 = new StudentImpl();
        student2.setCourseList(courseList2);
        student2.setName("Костик");
        StudentImpl student3 = new StudentImpl();
        student3.setCourseList(courseList3);
        student3.setName("Настя");
        StudentImpl student4 = new StudentImpl();
        student4.setCourseList(courseList4);
        student4.setName("Обиженный Ильюша");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Homework homework = new Homework();
        List<Course> courses = homework.getUniqueCourses(studentList);
        for (Course c : courses) {
            System.out.println(c.getName());
        }
        System.out.println("*********************");

        List<Student> students = homework.topSmartStudents(studentList);
        for (Student studentt : students) {
            System.out.println(studentt.getName());
        }
        System.out.println("*********************");

        List<Student> students2 = homework.studentsOnCourse(studentList, new CourseImpl("Prog"));
        for (Student studentt : students2) {
            System.out.println(studentt.getName());
        }
        System.out.println("*********************");
    }
}
