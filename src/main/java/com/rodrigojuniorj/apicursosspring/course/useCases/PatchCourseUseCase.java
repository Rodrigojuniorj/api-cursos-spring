package com.rodrigojuniorj.apicursosspring.course.useCases;

import com.rodrigojuniorj.apicursosspring.course.dto.CousePutDTO;
import com.rodrigojuniorj.apicursosspring.course.entities.CourseEntity;
import com.rodrigojuniorj.apicursosspring.course.repositories.CourseRepository;
import com.rodrigojuniorj.apicursosspring.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatchCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID uuid){
        CourseEntity course = this.courseRepository.findById(uuid).orElseThrow(() -> new CourseNotFoundException());

        if(course.getActive() == 1){
            course.setActive(2);
        } else{
            course.setActive(1);
        }

        this.courseRepository.save(course);

        return course;
    }

}
