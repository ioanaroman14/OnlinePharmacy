package Service;

import Domain.Medicine;
import Repository.MedicineRepository;

import java.util.List;

public class MedicineService {
    private final MedicineRepository repository;

    public MedicineService(MedicineRepository repository){
        this.repository = repository;
    }
    public void addOrUpdate (String id, String name, String producer, double price, boolean recipe){
        Medicine existing = repository.findById(id);
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
        Medicine medicine = new Medicine(id, name, producer, price, recipe);
        repository.upsert(medicine);
    }
    public void stergere(String id){
        repository.remove(id);
    }
    public List<Medicine> getAll(){
    return repository.getAll();
    }
}