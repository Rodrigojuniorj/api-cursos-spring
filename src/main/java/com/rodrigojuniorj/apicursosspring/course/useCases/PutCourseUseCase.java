package com.rodrigojuniorj.apicursosspring.course.useCases;

import com.rodrigojuniorj.apicursosspring.course.dto.CousePutDTO;
import com.rodrigojuniorj.apicursosspring.course.entities.CourseEntity;
import com.rodrigojuniorj.apicursosspring.course.repositories.CourseRepository;
import com.rodrigojuniorj.apicursosspring.exceptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PutCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID uuid, CousePutDTO cousePutDTO){
        CourseEntity course = this.courseRepository.findById(uuid).orElseThrow(() -> new CourseNotFoundException());
        System.out.println(cousePutDTO);
        if(cousePutDTO.getName() != null){
            course.setName(cousePutDTO.getName());
        }
        if(cousePutDTO.getCategory() != null){
            course.setCategory(cousePutDTO.getCategory());
        }

        var courseNew = this.courseRepository.save(course);

        return courseNew;
    }

}
