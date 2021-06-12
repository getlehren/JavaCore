package ru.getman.java.core;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements Student {

    private List<Course> courseList = new ArrayList<>();
    private String name;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }
}
