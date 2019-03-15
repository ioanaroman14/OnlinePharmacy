package Domain;

import java.util.Objects;

public class CardClient {
    private String id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration;

    @Override
    public String toString() {
        return "CardClient{" +
                "id = '" + id + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", firstName = '" + firstName + '\'' +
                ", CNP = '" + CNP + '\'' +
                ", dateOfBirth = '" + dateOfBirth + '\'' +
                ", dateOfRegistration = '" + dateOfRegistration + '\'' +
                '}';
    }

    public CardClient(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardClient cardClient = (CardClient) o;
        return Objects.equals(id, cardClient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}