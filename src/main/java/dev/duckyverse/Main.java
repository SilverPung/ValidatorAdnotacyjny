package dev.duckyverse;

import dev.duckyverse.exception.ValidationException;
import dev.duckyverse.validator.Validator;

public class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.setEmail("James.Bla@pbs.edu.pl");
            student.setImie("JYYYY");
            student.setNazwisko("BAAA");
            student.setNrIndeksu("12345678");
            Validator.validate(student);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}