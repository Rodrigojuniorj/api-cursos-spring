package com.rodrigojuniorj.apicursosspring.course.useCases;

import com.rodrigojuniorj.apicursosspring.course.entities.CourseEntity;
import com.rodrigojuniorj.apicursosspring.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecuperaCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(){
        return this.courseRepository.findAll();
    }

}
