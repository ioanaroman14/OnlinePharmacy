package UI;

import Domain.CardClient;
import Domain.Medicine;
import Domain.Transaction;
import Service.CardClientService;
import Service.MedicineService;
import Service.TransactionService;

import java.util.Scanner;

public class Console {
    private MedicineService medicineService;
    private CardClientService cardClientService;
    private TransactionService transactionService;

    private Scanner scanner;

    public Console (MedicineService medicineService, CardClientService cardClientService, TransactionService transactionService){
        this.medicineService = medicineService;
        this.cardClientService = cardClientService;
        this.transactionService = transactionService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Medicine CRUD");
        System.out.println("2. Card client CRUD");
        System.out.println("3. Transaction CRUD");
        System.out.println("x. Exit");
    }
    public void run(){
        while(true){
            showMenu();
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    runMedicineCrud();
                    break;
                case "2":
                    runCardClientCrud();
                    break;
                case "3":
                    runTransactinCrud();
                    break;
                case "x":
                    return;
                    default:
                        System.out.println("Invalid option!");
                        break;
            }

        }
    }
    private void runTransactinCrud(){
        while (true){
            System.out.println("1. Add or update a transaction.");
            System.out.println("2. Remove a transaction.");
            System.out.println("3. View all transaction.");
            System.out.println("4. Back.");

            String option = scanner.nextLine();
            switch (option){
                case "1":
                    handleAddUpdateTransaction();
                    break;
                case "2":
                    handleRemoveTransaction();
                    break;
                case "3":
                    handleViewTransactions();
                    break;
                case "4":
                    return;
                 default:
                     System.out.println("Invalid option!");
                     break;
            }
        }
    }
    private void handleViewTransactions(){
        for (Transaction transaction : transactionService.getAll()){
            System.out.println(transaction);
        }
    }
    private void handleRemoveTransaction(){
        try {
            System.out.println("Enter the id transaction to remove:");
            String id = scanner.nextLine();
            transactionService.remove(id);

            System.out.println("Transaction removed!");
        } catch (Exception ex){
            System.out.println("Errors:\n" + ex.getMessage());

        }
    }
    private void handleAddUpdateTransaction(){
        try {
            System.out.println("Enter id transaction: ");
            String id = scanner.nextLine();
            System.out.println("Enter medicine id (empty to not change for update): ");
            String idMedicine = scanner.nextLine();
            System.out.println("Enter client card id (empty to not change for update): ");
            String idCardClient = scanner.nextLine();
            System.out.println("Enter number of items (0 to not change for update): ");
            int numberOfItems = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter date (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.println("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();

            Transaction transaction = transactionService.addOrUpdate(id, idMedicine, idCardClient, numberOfItems, date, time);
            System.out.println(String.format("Added transaction id=%s, paid price=%f, discount=%f%%", transaction.getId(),
                    transaction.getDiscountPrice(), transaction.getDiscount()));
        } catch (Exception ex) {
            System.out.println("Erori: \n" + ex.getMessage());
        }
    }
    private void runCardClientCrud(){
        while (true){
            System.out.println("1. Add or update a card client:");
            System.out.println("2. Remove a client card:");
            System.out.println("3. View all clients cards:");
            System.out.println("4. Back.");

            String optiuni = scanner.nextLine();
            switch (optiuni) {
                case "1":
                    handleAddUpdateCardClient();
                    break;
                case "2":
                    handleRemoveCardClient();
                    break;
                case "3":
                    handleViewCardClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void handleViewCardClients(){
        for (CardClient cardClient : cardClientService.getAll()){
            System.out.println(cardClient);
        }
    }
    private void handleRemoveCardClient(){
        try {
            System.out.println("Enter the client card id to remove:");
            String id = scanner.nextLine();
            cardClientService.remove(id);

            System.out.println("Client removed!");
        } catch (Exception ex){
            System.out.println("Errors: \n" + ex.getMessage());
        }
    }
    private void handleAddUpdateCardClient(){
        try {
            System.out.println("Enter client card id: ");
            String id = scanner.nextLine();
            System.out.println("Enter last name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.println("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.println("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();

            System.out.println("Enter date of birth (empty to not change for update): ");
            String dateOfBirth = scanner.nextLine();
            System.out.println("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();

            cardClientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
    private void runMedicineCrud() {
        while (true) {
            System.out.println("1. Add or update a medicine.");
            System.out.println("2. Remove a medicine.");
            System.out.println("3. View all medicine.");
            System.out.println("4. Back.");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateMedicine();
                    break;
                case "2":
                    handleRemoveMedicine();
                    break;
                case "3":
                    handleViewMedicine();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void handleViewMedicine() {
        for (Medicine medicine : medicineService.getAll()) {
            System.out.println(medicine);
        }
    }
    private void handleRemoveMedicine() {
        try {
            System.out.println("Enter the medicine id to remove:");
            String id = scanner.nextLine();
            medicineService.stergere(id);

            System.out.println("Medicine removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
    private void handleAddUpdateMedicine() {
        try {
            System.out.println("Enter medicine id: ");
            String id = scanner.nextLine();
            System.out.println("Enter name of medicine (empty to not change for update): ");
            String name = scanner.nextLine();
            System.out.println("Enter producer of medicine (empty to not change for update): ");
            String producer = scanner.nextLine();
            System.out.println("Enter price of medicine (0 to not change for update): ");
            Double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter if exists a recipe (true / false): ");
            boolean recipe = Boolean.parseBoolean(scanner.nextLine());

            medicineService.addOrUpdate(id, name, producer, price, recipe);
            System.out.println("Medicine added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" +  ex.getMessage());
        }
    }
}
