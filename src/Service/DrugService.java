package Service;

import Domain.Drug;
import Repository.DrugRepository;

import java.util.List;

public class DrugService {
    private final DrugRepository repository;

    public DrugService(DrugRepository repository){
        this.repository = repository;
    }
    public void addOrUpdate (String id, String name, String producer, double price, boolean recipe){
        Drug existing = repository.findById(id);
        if (existing != null){
            if (name.isEmpty()){
                name = existing.getName();
            }
            if (producer.isEmpty()){
                producer = existing.getProducer();
            }
            if (price == 0){
                price = existing.getPrice();
            }
        }
        Drug drug = new Drug(id, name, producer, price, recipe);
        repository.upsert(drug);
    }
    public void stergere(String id){
        repository.remove(id);
    }
    public List<Drug> getAll(){
    return repository.getAll();
    }
}