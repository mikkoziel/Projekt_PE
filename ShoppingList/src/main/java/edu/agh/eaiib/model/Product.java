package edu.agh.eaiib.model;

public class Product {
    private String name;
    private int amount;
    private boolean bought;

    public Product(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.bought = false;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isBought(){return bought;}

    public void buyProduct() {
        this.bought = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (amount != product.amount) return false;
        if (bought != product.bought) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", bought=" + bought +
                '}';
    }

}
