package jdbc.entity;

public class Bill {
    private String id;
    private double total;
    private String customer;

    public Bill() {
    }

    public Bill(String id, double total, String customer) {
        this.id = id;
        this.total = total;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                ", total=" + total +
                ", customer='" + customer + '\'' +
                '}';
    }
}
