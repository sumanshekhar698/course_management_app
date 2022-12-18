package com.manager.controller;

import com.manager.entities.Course;
import com.manager.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//@EnableGlobalMethodSecurity(prePostEnabled = true)//authorizing via annotation
//First Entity to get control from FrontEND
//@Controller
@RestController//For REST Controller
@RequestMapping("/coursemanager")
public class CourseController {

    @Autowired
    private CourseService courseService;

//    ------------- TESTER --------------

    @RequestMapping(value = "/courses/test", method = RequestMethod.GET)//by default its GET
    public String home() {
        return "Course app String coming from Controller";

    }

//    ------------- GET ALL COURSES --------------


//    @PreAuthorize("hasRole('ADMIN')")//authorizing via annotation
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }
//    ------------- GET COURSE via ID --------------

    @GetMapping("/courses/{courseId}")
    public Course getCoursesFromID(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //    ------------- ADD COURSE --------------
    //    @PostMapping(path = "/courses",consumes = "application/json")
    @PostMapping(path = "/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }


    @PutMapping(path = "/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }


    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
