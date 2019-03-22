package Tests;

import Domain.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    @org.junit.jupiter.api.Test
        void getIdShouldReturnCorrectId3() {
            Transaction transaction = new Transaction("1", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            assertEquals("1", transaction.getId(), String.format("Returned %s, expected=%s", transaction.getId(), "1"));
            Transaction transaction2 = new Transaction("2", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            assertEquals("2", transaction2.getId(), String.format("Returned %s, expected=%s", transaction.getId(), "2"));
        }

        @org.junit.jupiter.api.Test
        void setIdShouldSetTheGivenId() {
            Transaction transaction = new Transaction("1", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            String setId = "7";
            transaction.setId(setId);
            assertEquals(setId, transaction.getId(), String.format("Returned=%s, Expected=%s", transaction.getId(), setId));
        }

        @org.junit.jupiter.api.Test
        void constructorShouldSetAllFieldsCorrectly() {
            Transaction cake = new Transaction("1", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            assertEquals("1", cake.getId());
            assertEquals("2", cake.getIdDrug());
            assertEquals("3", cake.getIdCardClient());
            assertEquals("10.03.2019", cake.getDate());
            assertEquals("12", cake.getTime());
            assertEquals(10, cake.getNumberOfItems());
            assertEquals(10, cake.getBasePrice());
            assertEquals(10, cake.getDiscount());

        }

        @org.junit.jupiter.api.Test
        void settersShouldSetFieldsCorrectly() {
            Transaction transaction = new Transaction("1", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);

            transaction.setId("2");
            transaction.setIdDrug("3");
            transaction.setIdCardClient("4");
            transaction.setDate("11.10.1990");
            transaction.setTime("13");
            transaction.setNumberOfItems(13);
            transaction.setBasePrice(13);
            transaction.setDiscount(15);


            assertEquals("2", transaction.getId());
            assertEquals("3", transaction.getIdDrug());
            assertEquals("4", transaction.getIdCardClient());
            assertEquals("11.10.1990", transaction.getDate());
            assertEquals("13", transaction.getTime());
            assertEquals(13, transaction.getNumberOfItems());
            assertEquals(13, transaction.getBasePrice());
            assertEquals(15, transaction.getDiscount());
        }

        @org.junit.jupiter.api.Test
        void equalityShouldWorkCorrectly() {
            Transaction transaction1 = new Transaction("1", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            Transaction transaction2 = new Transaction("1", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            Transaction transaction3 = new Transaction("2", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            assertNotEquals(transaction1, transaction3);
            assertNotEquals(transaction3, transaction1);
            assertNotEquals(transaction3, transaction2);
            assertNotEquals(transaction2, transaction3);
            assertEquals(transaction1, transaction2);
            assertEquals(transaction2, transaction1);
        }


        @org.junit.jupiter.api.Test
        void toStringShouldReturnALongEnoughString() {
            Transaction transaction1 = new Transaction("1", "2", "3", "10.03.2019",
                    "12", 10, 10, 10);
            assertTrue(transaction1.toString().length() > 10);
        }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void equals() {
    }

    @Test
    void toString1() {
    }

    @Test
    void getDiscountPrice() {
    }

    @Test
    void getIdDrug() {
    }

    @Test
    void setIdDrug() {
    }

    @Test
    void getIdCardClient() {
    }

    @Test
    void setIdCardClient() {
    }

    @Test
    void getDate() {
    }

    @Test
    void setDate() {
    }

    @Test
    void getTime() {
    }

    @Test
    void setTime() {
    }

    @Test
    void getNumberOfItems() {
    }

    @Test
    void setNumberOfItems() {
    }

    @Test
    void getBasePrice() {
    }

    @Test
    void setBasePrice() {
    }

    @Test
    void getDiscount() {
    }

    @Test
    void setDiscount() {
    }
}