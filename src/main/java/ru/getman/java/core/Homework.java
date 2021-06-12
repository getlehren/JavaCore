package ru.getman.java.core;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Homework {
    List<Course> getUniqueCourses(List<Student> students) {
        return students.stream().flatMap(
                s -> s.getAllCourses().stream()).distinct()
                .collect(Collectors.toList());
    }

    List<Student> topSmartStudents(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(student -> student.getAllCourses().size(), Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());
    }

    List<Student> studentsOnCourse(List<Student> studentList, Course course) {
        return studentList.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
