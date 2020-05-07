package edu.agh.eaiib.model;

import java.util.Objects;

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

        return amount == product.amount &&
                bought == product.bought &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
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
