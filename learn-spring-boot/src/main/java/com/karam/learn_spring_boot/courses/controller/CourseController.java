package com.karam.learn_spring_boot.courses.controller;

import com.karam.learn_spring_boot.courses.bean.Course;
import com.karam.learn_spring_boot.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan("com.karam.learn_spring_boot.courses.bean")
@RestController//expose web url, expose rest api
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // http://localhost:8080/courses
    //when user enters this url, we want to send a specific response
    @GetMapping("/courses")//this is what the user is going to send a request to
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
        // return List.of(new Course(1, "Learn MicroServices", "Karam"), new Course(2, "Learn SpringBoot", "Ranga"));
    }

    @GetMapping("/courses/{id}")
    public Course getFirstCourse(@PathVariable long id){
        if (courseRepository.findById(id).isPresent())
                return courseRepository.findById(id).get();
        throw new RuntimeException("Course not found with id " + id);
    }

    @PostMapping("/courses")
    public void createCourse(@RequestBody Course course){//we want to pick up the body of the request
        courseRepository.save(course);
    }

    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course){//we want to pick up the body of the request
        courseRepository.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable long id){
        courseRepository.deleteById(id);
    }
}
