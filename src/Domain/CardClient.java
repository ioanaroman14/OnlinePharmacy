package Domain;

public class CardClient extends Entity {
    private String id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration;

    @Override
    public String toString() {
        return "CardClient{" +
                "id='" + getId() + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                '}';
    }


    public void setId(String setId) {
        this.id = id;
    }

    public CardClient(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
    }

    //@Override
    //public String getId() {
      //  return id;
    //}

   // public void setId(String id) {
     //   this.id = id;
    //}

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