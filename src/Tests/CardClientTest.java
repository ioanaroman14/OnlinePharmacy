package Tests;

import Domain.CardClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardClientTest {
    @org.junit.jupiter.api.Test
    void getIdShouldReturnCorrectId2() {
        CardClient cardClient = new CardClient("1", "test", "test", "2801014125811",
                "14.10.1990", "15.10.2019");
        assertEquals("1", cardClient.getId(), String.format("Returned %s, expected=%s", cardClient.getId(), "1"));
        CardClient cardClient2 = new CardClient("2","test","test","2801014125811", "14.10.1990","15.10.2019");
        assertEquals("2", cardClient2.getId(), String.format("Returned %s, expected=%s", cardClient.getId(), "2"));
    }

    @org.junit.jupiter.api.Test
    void setIdShouldSetTheGivenId2() {
        CardClient cardClient = new CardClient("1", "test", "test",
                "2801014125811", "14.10.1990","15.10.2019");
        String setId = "1";
        cardClient.setId(setId);
        assertEquals(setId, cardClient.getId(), String.format("Returned=%s, Expected=%s", cardClient.getId(), setId));
    }

    @org.junit.jupiter.api.Test
    void constructorShouldSetAllFieldsCorrectly2() {
        CardClient cardClient = new CardClient("1", "test", "test",
                "2801014125811", "14.10.1990","15.03.2019");
        assertEquals("1", cardClient.getId());
        assertEquals("test", cardClient.getLastName());
        assertEquals("test", cardClient.getFirstName());
        assertEquals("2801014125811", cardClient.getCNP());
        assertEquals("14.10.1990", cardClient.getDateOfBirth());
        assertEquals("15.03.2019", cardClient.getDateOfRegistration());

    }

    @org.junit.jupiter.api.Test
    void settersShouldSetFieldsCorrectly2() {
        CardClient cardClient = new CardClient("2", "test", "test",
                "2801014125811", "14.10.1990","15.10.2019");

        cardClient.setId("2");
        cardClient.setLastName("test2");
        cardClient.setFirstName("test2");
        cardClient.setCNP("2801013235811");
        cardClient.setDateOfBirth("11.10.1990");
        cardClient.setDateOfRegistration("16.10.2019");


        assertEquals("2", cardClient.getId());
        assertEquals("test2", cardClient.getLastName());
        assertEquals("test2", cardClient.getFirstName());
        assertEquals("2801013235811", cardClient.getCNP());
        assertEquals("11.10.1990", cardClient.getDateOfBirth());
        assertEquals("16.10.2019", cardClient.getDateOfRegistration());

    }

    @org.junit.jupiter.api.Test
    void equalityShouldWorkCorrectly() {
        CardClient cardClient1 = new  CardClient("1", "test", "test",
                "2801014125811", "14.10.1990","15.10.2019");
        CardClient cardClient2 = new  CardClient("1", "test", "test",
                "2801014125811", "14.10.1990","15.10.2019");
        CardClient cardClient3 = new  CardClient("2", "test", "test",
                "2801014125811", "14.10.1990","15.10.2019");


        assertNotEquals(cardClient1, cardClient3);
        assertNotEquals(cardClient3, cardClient1);
        assertNotEquals(cardClient3, cardClient2);
        assertNotEquals(cardClient2, cardClient3);
        assertEquals(cardClient1, cardClient2);
        assertEquals(cardClient2, cardClient1);
    }


    @org.junit.jupiter.api.Test
    void toStringShouldReturnALongEnoughString() {
        CardClient cardClient1 = new  CardClient("1", "test", "test",
                "2801014125811", "14.10.1990","15.10.2019");
        assertTrue(cardClient1.toString().length() > 10);
    }



    @Test
    void equals() {
    }


    @Test
    void getId() {
    }

    @Test
    void toString1() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getCNP() {
    }

    @Test
    void setCNP() {
    }

    @Test
    void getDateOfBirth() {
    }

    @Test
    void setDateOfBirth() {
    }

    @Test
    void getDateOfRegistration() {
    }

    @Test
    void setDateOfRegistration() {
    }
}