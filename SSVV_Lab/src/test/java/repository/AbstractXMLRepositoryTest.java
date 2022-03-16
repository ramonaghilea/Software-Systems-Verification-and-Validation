package repository;

import domain.Student;
import org.junit.Test;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.Assert.*;

public class AbstractXMLRepositoryTest {
    @Test
    public void Test_save_student_when_id_is_null_returns_null() {
        Student student = new Student(null, "Anna", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_data_is_valid_success() {
        Student student = new Student("55", "Anna", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));

        studentXMLRepository.delete("55");
    }

    @Test
    public void Test_save_student_when_group_is_less_than_110_returns_null() {
        Student student = new Student("55", "Anna", 109);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_greater_than_938_returns_null() {
        Student student = new Student("55", "Anna", 939);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_0_returns_null() {
        Student student = new Student("55", "Anna", 0);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_minus_1_returns_null() {
        Student student = new Student("55", "Anna", -1);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_1_returns_null() {
        Student student = new Student("55", "Anna", 1);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_maxint_minus_1_returns_null() {
        Student student = new Student("55", "Anna", Integer.MAX_VALUE - 1);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_maxint_returns_null() {
        Student student = new Student("55", "Anna", Integer.MAX_VALUE);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }
}