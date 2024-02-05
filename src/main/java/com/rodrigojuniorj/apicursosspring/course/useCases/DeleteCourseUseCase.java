package com.rodrigojuniorj.apicursosspring.course.useCases;

import com.rodrigojuniorj.apicursosspring.course.entities.CourseEntity;
import com.rodrigojuniorj.apicursosspring.course.repositories.CourseRepository;
import com.rodrigojuniorj.apicursosspring.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID uuid){
        CourseEntity course = this.courseRepository.findById(uuid).orElseThrow(() -> new CourseNotFoundException());

        this.courseRepository.delete(course);

        return course;
    }

}
