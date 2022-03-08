package repository;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.Assertions;
import validation.*;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class AbstractXMLRepositoryTest {

    @org.junit.jupiter.api.Test
    void Test_save_student_when_id_is_null_returns_null() {
        Student student = new Student(null, "Anna", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @org.junit.jupiter.api.Test
    void Test_save_student_when_data_is_valid_success() {
        Student student = new Student("55", "Anna", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }
}