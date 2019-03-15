package Repository;

import Domain.CardClient;
import Domain.CardClientValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardClientRepository {
    private Map<String, CardClient> storage = new HashMap<>();
    private CardClientValidator validator;

    public CardClientRepository(CardClientValidator validator) {
        this.validator = validator;
    }

    public CardClient findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds o updates a client if it already exists.
     *
     * @param cardClient the cardClient to add or update.
     */
    public void upsert(CardClient cardClient) {
        validator.validate(cardClient);
        storage.put(cardClient.getId(), cardClient);
    }

    /**
     * Removes a client with a given id.
     *
     * @param id the id.
     * @throw RuntimeException if there is no client with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no client with the given id to remove.");
        }
        storage.remove(id);
    }

    /**
     * Adds a cardClient to the reposotory.
     *
     * @param cardClient the cardClient to add.
     *                   Raises RuntimeException if there already cardClient with the given CNP
     */
    public void adds(CardClient cardClient) {
        if (storage.containsKey(cardClient.getCNP())) {
            storage.remove(cardClient);
            throw new RuntimeException("A client card with that CNP already exists!");
        }
        validator.validate(cardClient);
        storage.remove(cardClient);
        storage.put(cardClient.getCNP(), cardClient);
    }

    public List<CardClient> getAll(){
        return new ArrayList<>(storage.values());
    }
}
