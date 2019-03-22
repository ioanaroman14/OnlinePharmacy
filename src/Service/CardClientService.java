package Service;

import Domain.CardClient;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class CardClientService {
    private IRepository<CardClient> repository;


    public CardClientService(IRepository<CardClient> repository) {
        this.repository = repository;
    }
    public void addOrUpdate (String id, String lastName, String firstName, String CNP,
                             String dateOfBirth, String dateOfRegistration){
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

    /**
     * Searches clients whose field contain a given text.
     * @param text the text searched for
     * @return a list of clients whose fields contain text.
     */
    public List<CardClient> fullTextSearch(String text){
        List<CardClient> results = new ArrayList<>();
        for(CardClient c : repository.getAll()){
            //Might return false positives
            if (c.toString().contains(text)){
                results.add(c);
            }
           // if (c.getFirstName().contains(text)) || c.getLastName().contains(text)
        }
        return results;
    }
    public void remove(String id) {
            repository.remove(id);
        }

    public List<CardClient>getAll() {
        return repository.getAll();
        }
    }

