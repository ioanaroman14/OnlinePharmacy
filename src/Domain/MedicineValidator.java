package Domain;

public class MedicineValidator {
    public void validate (Medicine medicine){
        if(medicine.getPrice() < 0){
            throw new RuntimeException ("Price must be > 0.");
        }
    }
}
