package Service;

import Domain.CardClient;
import Repository.CardClientRepository;

import java.util.List;

public class CardClientService {
    private CardClientRepository repository;


    public CardClientService(CardClientRepository repository){
        this.repository = repository;
    }
    public void addOrUpdate (String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration){
        CardClient existing = repository.findById(id);
            if (existing != null) {
                if (lastName.isEmpty()) {
                    lastName = existing.getLastName();
                }
                if (firstName.isEmpty()) {
                    firstName = existing.getFirstName();
                }
                if (CNP.isEmpty()) {
                    CNP = existing.getCNP();
                }
                if (dateOfBirth.isEmpty()) {
                    dateOfBirth = existing.getDateOfBirth();
                }
                if (dateOfRegistration.isEmpty()) {
                    dateOfRegistration = existing.getDateOfRegistration();
                }

            }
            CardClient cardClient = new CardClient(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
            repository.upsert(cardClient);



        }

    public void remove(String id){
            repository.remove(id);
        }


        public List<CardClient>getAll() {
            return repository.getAll();
        }
    }

