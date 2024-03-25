package poo.entity;

public class Dairy extends Product{
    private int count;

    public Dairy() {
    }

    public Dairy(String name, double price, int stock, String id, int count) {
        super(name, price, stock, id);
        this.count = count;
    }

    public Dairy(String name, double price, int stock, String id) {
        super(name, price, stock, id);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Dairy{" +
                "count=" + count +
                '}';
    }
}
