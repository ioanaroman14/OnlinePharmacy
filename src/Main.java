
import Domain.TransactionValidator;
import Domain.CardClientValidator;
import Domain.MedicineValidator;
import Repository.CardClientRepository;
import Repository.MedicineRepository;
import Repository.TransactionRepository;
import Service.CardClientService;
import Service.MedicineService;
import Service.TransactionService;
//import UI.Console;
import UI.Console;
import UI.ConsoleLimbajNatural;



public class Main {
    public static void main(String[] args) {
        MedicineValidator medicineValidator = new MedicineValidator();
        CardClientValidator cardClientValidator = new CardClientValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        MedicineRepository medicineRepository = new MedicineRepository(medicineValidator);
        CardClientRepository cardClientRepository = new CardClientRepository(cardClientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);

        MedicineService medicineService = new MedicineService(medicineRepository);
        CardClientService cardClientService = new CardClientService(cardClientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicineRepository);

        Console console = new Console(medicineService, cardClientService, transactionService);
        console.run();

        ConsoleLimbajNatural consoleLimbajNatural = new ConsoleLimbajNatural(medicineService,cardClientService,transactionService);
        consoleLimbajNatural.run2();
    }
}
