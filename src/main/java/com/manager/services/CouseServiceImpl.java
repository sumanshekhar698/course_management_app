package com.manager.services;

import com.manager.dao.CourseDao;
import com.manager.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
//    List<Course> list;

    public CouseServiceImpl(List<Course> list) {
/*        this.list = new ArrayList<>();
        this.list.add(new Course(1, "Java", "Core Java"));
        this.list.add(new Course(2, "Python", "Core Python"));*/

    }

    @Override
    public List<Course> getCourses() {
//        return this.list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long id) {
//        return this.list.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
//        return courseDao.getOne(id);
//        return courseDao.getById(id);
        Optional<Course> courseById = courseDao.findById(id);
        if (courseById.isPresent())
            return courseById.get();
        return null;
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
/*        list.forEach(e -> {
            if (e.getId() == course.getId()) {
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });*/
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseID) {
//        this.list = this.list.stream().filter(course -> course.getId() != courseID).collect(Collectors.toList());
        Course course = courseDao.findById(courseID).get();
        courseDao.delete(course);
    }


}
