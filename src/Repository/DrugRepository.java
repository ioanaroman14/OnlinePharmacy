package Repository;

import Domain.Drug;
import Domain.DrugValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrugRepository {
    private Map<String, Drug> storage = new HashMap<>();
    private DrugValidator validator;

    public DrugRepository(DrugValidator validator){
        this.validator = validator;
    }
    public Drug findById(String id){
        return storage.get(id);
    }
    /**
     * Adds or updates a drug if it already exists.
     * @param drug to add or update.
     */
    public void upsert (Drug drug){
        validator.validate(drug);
        storage.put(drug.getId(), drug);
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
    public List<Drug> getAll(){
        return new ArrayList<>(storage.values());
    }
}
