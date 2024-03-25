package poo.entity;

import java.util.List;

public class Bill {
    private String id;
    private List<Product> products;
    private double total;
    private String customer;

    public Bill() {
    }

    public Bill(String id, List<Product> products, double total, String customer) {
        this.id = id;
        this.products = products;
        this.total = total;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", products=" + products +
                ", total=" + total +
                ", customer='" + customer + '\'' +
                '}';
    }
}
