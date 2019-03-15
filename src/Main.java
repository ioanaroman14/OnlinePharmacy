
import Domain.TransactionValidator;
import Domain.CardClientValidator;
import Domain.DrugValidator;
import Repository.CardClientRepository;
import Repository.DrugRepository;
import Repository.TransactionRepository;
import Service.CardClientService;
import Service.DrugService;
import Service.TransactionService;
import UI.Console;

public class Main {
    public static void main(String[] args){
        DrugValidator drugValidator = new DrugValidator();
        CardClientValidator cardClientValidator = new CardClientValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        DrugRepository drugRepository = new DrugRepository(drugValidator);
        CardClientRepository cardClientRepository = new CardClientRepository(cardClientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);

        DrugService drugService = new DrugService(drugRepository);
        CardClientService cardClientService = new CardClientService(cardClientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, drugRepository);

        Console console = new Console(drugService, cardClientService, transactionService);
        console.run();


    }
}
