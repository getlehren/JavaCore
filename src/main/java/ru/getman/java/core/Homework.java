package ru.getman.java.core;

import java.util.List;
import java.util.stream.Collectors;

/*public class Homework {
    List<Course> getUniqueCourses(List<Student> students) {
        return students.stream().flatMap(
                s -> s.getAllCourses().stream()).distinct()
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    List<Student> topSmartStudents(List<Student> students) {
        students
                .stream().
    }
}
