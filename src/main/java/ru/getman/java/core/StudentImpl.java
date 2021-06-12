package ru.getman.java.core;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements Student {

    List<Course> courseList = new ArrayList<>();

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }
}
