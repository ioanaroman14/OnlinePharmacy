package Tests;

import Domain.IValidator;
import Domain.Medicine;
import Domain.MedicineValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MedicineRepositoryTest {
    @org.junit.jupiter.api.Test
    void findByIdWithExistingIdShouldReturnCorrectMedicine(){

        IValidator<Medicine> medicineValidator = new MedicineValidator();
        IRepository<Medicine> repo = new InMemoryRepository<>(medicineValidator);
        Medicine added = new Medicine("1", "test", "Terapia", 10,  true);
        repo.upsert(added);
        Medicine found = repo.findById("1");
        assertNotNull(found, "Returned null for existing id!");
        assertEquals("1", found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
        assertEquals("test", found.getName(), String.format("Returned name=%s instead of %s", found.getName(),added.getName()) );
        assertEquals("Terapia", found.getProducer(), String.format("Returned producer=%s instead of %s", found.getProducer(),added.getProducer()) );
        assertEquals(10, found.getPrice(), String.format("Returned price=%s instead of %s", found.getPrice(),added.getPrice()) );
        assertEquals(true, found.isRecipe(), String.format("Returned recipe=%s instead of %s",found.isRecipe(), added.isRecipe()));
    }


    @org.junit.jupiter.api.Test
    void upsert() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }
}