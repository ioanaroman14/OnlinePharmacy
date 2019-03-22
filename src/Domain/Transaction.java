package Domain;

public class Transaction extends Entity {
    private String id, idDrug, idCardClient, date, time;
    private int numberOfItems;
    private double basePrice, discount;

    public Transaction(String id, String idDrug, String idCardClient, String date,
                       String time, int numberOfItems, double basePrice, double discount) {
        super(id);
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
                "id = '" + getId()  + '\'' +
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

   // @Override
   // public String getId() {
     //   return id;
   // }

   public void setId(String id) {
     this.id = id;
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



