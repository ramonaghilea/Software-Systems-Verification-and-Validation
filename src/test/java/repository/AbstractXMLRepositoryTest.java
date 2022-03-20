package repository;

import domain.Student;
import org.junit.jupiter.api.Test;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractXMLRepositoryTest {

    @Test
    public void Test_save_student_when_data_is_valid_success() {
        Student student = new Student("55", "Anna", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));

        studentXMLRepository.delete("55");
    }

    @Test
    public void Test_save_student_when_data_is_valid_and_group_is_110_success() {
        Student student = new Student("0", "Ben", 110);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));

        studentXMLRepository.delete("0");
    }

    @Test
    public void Test_save_student_when_data_is_valid_and_group_is_greater_than_110_success() {
        Student student = new Student("0", "Ben", 111);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));

        studentXMLRepository.delete("0");
    }

    @Test
    public void Test_save_student_when_data_is_valid_and_group_is_less_than_938_success() {
        Student student = new Student("0", "Ben", 937);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));

        studentXMLRepository.delete("0");
    }

    @Test
    public void Test_save_student_when_data_is_valid_and_group_is_938_success() {
        Student student = new Student("0", "Ben", 938);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));

        studentXMLRepository.delete("0");
    }

    @Test
    public void Test_save_student_when_id_is_null_returns_null() {
        Student student = new Student(null, "Anna", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_id_is_empty_returns_null() {
        Student student = new Student("", "Anna", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_name_is_empty_returns_null() {
        Student student = new Student("55", "", 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_name_is_null_returns_null() {
        Student student = new Student("55", null, 200);
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_null_returns_null() {
        Student student = new Student("55", "", 0);  //nu pot pune null, trebuie sa modificam din int in Integer
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
    }

    @Test
    public void Test_save_student_when_group_is_not_natural_returns_null() {
        Student student = new Student("55", "", 0); //nu pot pune 913.13, pentru ca e int nu double
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");

        assertNull(studentXMLRepository.save(student));
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