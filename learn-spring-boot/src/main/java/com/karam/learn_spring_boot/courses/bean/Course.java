package com.karam.learn_spring_boot.courses.bean;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Entity (name = "Courses")
public class Course {
    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    @Column(name = "IDs")
    private long id;
    @Column(name="Names")
    private String name;
    @Column(name="Authors")
    private String author;

    public Course() {

    }

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }
}
