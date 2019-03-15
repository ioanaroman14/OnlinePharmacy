package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CardClientValidator {
    public void validate (CardClient cardClient){
        if (cardClient.getCNP().length() != 13){
            throw new RuntimeException("CNP-ul nu este corect");
        }
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            format.parse(cardClient.getDateOfBirth());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not a correct format!");
        }
         try {
             format.parse(cardClient.getDateOfRegistration());
         } catch (ParseException pe) {
             throw new RuntimeException("The date of registration is not a correct format!");

            }
        }
    }


