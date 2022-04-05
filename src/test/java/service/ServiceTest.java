package service;

import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    private Service service;
    private StudentXMLRepository studentXMLRepository;
    private TemaXMLRepository temaXMLRepository;
    private NotaXMLRepository notaXMLRepository;

    @BeforeEach
    void setUp() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "test_studenti.xml");
        temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");
        notaXMLRepository = new NotaXMLRepository(notaValidator, "test_note.xml");

        service = new Service(studentXMLRepository, temaXMLRepository, notaXMLRepository);
    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    public void test_addStudent() {
        assertEquals(service.saveStudent("55", "Anna", 200), 0);

        studentXMLRepository.delete("55");
    }

    @Test
    public void test_addAssignment() {
        assertEquals(service.saveTema("5", "tema FP", 10, 5), 0);

        temaXMLRepository.delete("5");
    }

    @Test
    public void test_addGrade() {
        assertEquals(service.saveNota("1", "3",  9, 8, "congrats"), 0);

        notaXMLRepository.delete(new Pair<>("1", "3"));
    }

    @Test
    public void test_integration_addGrade_success() {
        assertEquals(service.saveStudent("55", "Anna", 200), 0);
        assertEquals(service.saveTema("5", "tema FP", 10, 5), 0);
        assertEquals(service.saveNota("55", "5",  10, 6, "congrats"), 0);

        studentXMLRepository.delete("55");
        temaXMLRepository.delete("5");
        notaXMLRepository.delete(new Pair<>("55", "5"));
    }
}