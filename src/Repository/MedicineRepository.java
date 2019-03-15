package Repository;

import Domain.Medicine;
import Domain.MedicineValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicineRepository {
    private Map<String, Medicine> storage = new HashMap<>();
    private MedicineValidator validator;

    public MedicineRepository(MedicineValidator validator){
        this.validator = validator;
    }
    public Medicine findById(String id){
        return storage.get(id);
    }
    /**
     * Adds or updates a medicine if it already exists.
     * @param medicine to add or update.
     */
    public void upsert (Medicine medicine){
        validator.validate(medicine);
        storage.put(medicine.getId(), medicine);
    }
    /**
     * Removes a drug with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no drug  with the given id.
     */
    public void remove (String id){
        if(!storage.containsKey(id)){
            throw new RuntimeException("There is no drug with the given id to remove.");
        }
        storage.remove(id);
    }
    public List<Medicine> getAll(){
        return new ArrayList<>(storage.values());
    }
}
