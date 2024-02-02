package com.rodrigojuniorj.apicursosspring.course.repositories;

import com.rodrigojuniorj.apicursosspring.course.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

}
