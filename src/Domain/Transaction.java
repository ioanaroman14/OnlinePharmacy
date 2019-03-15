package Domain;

import java.util.Objects;

public class Transaction {
    private String id, idDrug, idCardClient, date, time;
    private int numberOfItems;
    private double basePrice, discount;

    public Transaction(String id, String idDrug, String idCardClient, String date,
                       String time, int numberOfItems, double basePrice, double discount) {
        this.id = id;
        this.idDrug = idDrug;
        this.idCardClient = idCardClient;
        this.date = date;
        this.time = time;
        this.numberOfItems = numberOfItems;
        this.basePrice = basePrice;
        this.discount = discount;

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id = '" + id + '\'' +
                ", idDrug = '" + idDrug + '\'' +
                ", idCardClient = '" + idCardClient + '\'' +
                ", date = '" + date + '\'' +
                ", time = '" + time + '\'' +
                ", numberOfItems = " + numberOfItems +
                ", basePrice = " + basePrice +
                ", discount = " + discount +
                '}';
    }

    /**
     * Custom getter for the discounted price.
     * @return the price after applying the discount.
     */
   public double getDiscountPrice(){
       return basePrice * numberOfItems - discount * basePrice * numberOfItems;
  }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idDrug, idCardClient, date, time, numberOfItems, basePrice, discount);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(String idDrug) {
        this.idDrug = idDrug;
    }

    public String getIdCardClient() {
        return idCardClient;
    }

    public void setIdCardClient(String idCardClient) {
        this.idCardClient = idCardClient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

}



