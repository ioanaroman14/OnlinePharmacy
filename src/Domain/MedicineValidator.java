package Domain;

import UI.CustomException;

public class MedicineValidator implements IValidator<Medicine> {
    public void validate (Medicine medicine){
        if(medicine.getPrice() < 0){
            try {
                throw new CustomException ("Price must be > 0.");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
    }
}
