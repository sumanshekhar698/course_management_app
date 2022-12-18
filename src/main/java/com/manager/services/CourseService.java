package com.manager.services;

import com.manager.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    Course getCourse(long id);

    Course addCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(long courseID);
}
