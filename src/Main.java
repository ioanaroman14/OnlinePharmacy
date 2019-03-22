
import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.CardClientService;
import Service.MedicineService;
import Service.TransactionService;
import UI.Console;

//import UI.Console;


public class Main {
    public static void main(String[] args) {
        IValidator<Medicine> medicineValidator = new MedicineValidator();
        IValidator<CardClient> cardClientValidator = new CardClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Medicine> medicineRepository = new InMemoryRepository<>(medicineValidator);
        IRepository<CardClient> cardClientRepository = new InMemoryRepository<>(cardClientValidator);
        IRepository<Transaction> transactionRepository  = new InMemoryRepository<>(transactionValidator);

        MedicineService medicineService = new MedicineService(medicineRepository);
        CardClientService cardClientService = new CardClientService(cardClientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicineRepository);

        Console console = new Console(medicineService, cardClientService, transactionService);
        console.run();

        //ConsoleLimbajNatural consoleLimbajNatural = new ConsoleLimbajNatural(medicineService,cardClientService,transactionService);
        //consoleLimbajNatural.run2();

    }
}
