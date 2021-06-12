package ru.getman.java.core;

import java.util.Objects;

public class CourseImpl implements Course {
    String name;

    public CourseImpl(String name) {
        this.name = name;
    }

    public CourseImpl() {
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseImpl course = (CourseImpl) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
