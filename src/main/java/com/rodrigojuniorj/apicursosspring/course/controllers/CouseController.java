package com.rodrigojuniorj.apicursosspring.course.controllers;

import com.rodrigojuniorj.apicursosspring.course.dto.CousePutDTO;
import com.rodrigojuniorj.apicursosspring.course.dto.CouseRequestDTO;
import com.rodrigojuniorj.apicursosspring.course.entities.CourseEntity;
import com.rodrigojuniorj.apicursosspring.course.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CouseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private RecuperaCourseUseCase recuperaCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private PutCourseUseCase putCourseUseCase;

    @Autowired
    private PatchCourseUseCase patchCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity){
        try{
            var result = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> find() {
        try{
            var result = this.recuperaCourseUseCase.execute();
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Object> delete(@PathVariable String uuid) {
        try{
            var result = this.deleteCourseUseCase.execute(UUID.fromString(uuid));
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Object> put(@PathVariable String uuid, @RequestBody CousePutDTO cousePutDTO) {
        try{
            var result = this.putCourseUseCase.execute(UUID.fromString(uuid), cousePutDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{uuid}/active")
    public ResponseEntity<Object> patch(@PathVariable String uuid) {
        try{
            var result = this.patchCourseUseCase.execute(UUID.fromString(uuid));
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
