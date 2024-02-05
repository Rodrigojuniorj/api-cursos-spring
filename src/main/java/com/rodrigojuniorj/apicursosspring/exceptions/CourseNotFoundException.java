package com.rodrigojuniorj.apicursosspring.exceptions;

public class CourseNotFoundException extends  RuntimeException{
    public CourseNotFoundException() {
        super("Curso não existe!");
    }
}
