package repository;

import domain.Tema;
import org.junit.jupiter.api.Test;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class TemaXMLRepositoryTest {

    @Test
    public void Test_save_assignment_when_data_is_valid_and_nonexistent_success() {
        Tema tema = new Tema("5", "tema FP", 10, 5);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertEquals(temaXMLRepository.save(tema), tema);

        temaXMLRepository.delete("5");
    }

    @Test
    public void Test_save_assignment_when_data_is_valid_and_existent_returns_null() {
        Tema tema = new Tema("2", "XML", 8, 7);
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository temaXMLRepository = new TemaXMLRepository(temaValidator, "test_teme.xml");

        assertNull(temaXMLRepository.save(tema));
    }
}