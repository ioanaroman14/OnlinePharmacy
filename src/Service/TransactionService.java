package Service;

import Domain.Medicine;
import Domain.Transaction;
import Repository.MedicineRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {
    private TransactionRepository transactionRepository;
    private MedicineRepository medicineRepository;

    public TransactionService(TransactionRepository transactionRepository, MedicineRepository medicineRepository) {
        this.transactionRepository = transactionRepository;
        this.medicineRepository = medicineRepository;
    }

    public Transaction addOrUpdate(String id, String idMedicine, String idClientCard, int numberOfItems, String date, String time) {
        Transaction existing = transactionRepository.gasitDupaId(id);
        if (existing != null) {
            idMedicine = existing.getIdDrug();

            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdCardClient();
            }
            if (numberOfItems == 0) {
                numberOfItems = existing.getNumberOfItems();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }
        Medicine medicineSold = medicineRepository.findById(idMedicine);
        if (medicineSold == null) {
            throw new RuntimeException("There is no drug with the given id!");
        }
        double basePrice = medicineSold.getPrice();
        double discount = 0;
        if (idClientCard != null && !medicineSold.isRecipe()) {
            discount = 0.1;
        }
        if (idClientCard != null && medicineSold.isRecipe()) {
            discount = 0.15;
        }
        Transaction transaction = new Transaction(id, idMedicine, idClientCard, date, time, numberOfItems, basePrice, discount);
        transactionRepository.upsert(transaction);
        return transaction;
    }
    public  void remove(String id){
        transactionRepository.sterge(id);
    }
    public List<Transaction> getAll(){
        return transactionRepository.getAll();
    }
}

