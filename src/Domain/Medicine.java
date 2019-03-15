package Domain;

import java.util.Objects;

public class Medicine {
    private String id, name, producer;
    private double price;
    private boolean recipe;


    public Medicine(String id, String name, String producer, double price, boolean recipe) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id.equals(medicine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producer, price);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", recipe=" + recipe +
                '}';
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price= price;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }
}

