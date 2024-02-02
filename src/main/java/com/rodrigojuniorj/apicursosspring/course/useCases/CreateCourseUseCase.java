package com.rodrigojuniorj.apicursosspring.course.useCases;

import com.rodrigojuniorj.apicursosspring.course.dto.CouseRequestDTO;
import com.rodrigojuniorj.apicursosspring.course.entities.CourseEntity;
import com.rodrigojuniorj.apicursosspring.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity){
        if(courseEntity.getName().isEmpty() || courseEntity.getCatgory().isEmpty()){
            return null;
        }

        return this.courseRepository.save(courseEntity);
    }

}
