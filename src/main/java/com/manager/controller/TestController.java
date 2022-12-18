package com.manager.controller;

import com.manager.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController//For REST Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CourseService courseService;

//    ------------- TESTER --------------

    @RequestMapping(value = "/test_1", method = RequestMethod.GET)//by default its GET
    public String tes_1() {
        return "Course app String test_1 coming from Controller";

    }

    @GetMapping(value = "/test_2")
    public String test_2() {
        return "Course app String test_2 coming from Controller";

    }


}
