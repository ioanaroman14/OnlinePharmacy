package Domain;

import UI.CustomException;

public class TransactionValidator implements IValidator<Transaction> {
    public void validate (Transaction transaction){
        if (transaction.getNumberOfItems() <= 0) {
            try {
                throw new CustomException("The number of items must be at least 1!");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
    }
}
