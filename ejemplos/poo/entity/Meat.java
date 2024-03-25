package poo.entity;

public class Meat extends Product{
    private MeatType type;

    public Meat() {
    }
    public Meat(String name, double price, int stock, String id, MeatType type) {
        super(name, price, stock, id);
        this.type = type;
    }

    public Meat(String name, double price, int stock, String id) {
        super(name, price, stock, id);
    }

    public MeatType getType() {
        return type;
    }

    public void setType(MeatType type) {
        this.type = type;
    }
}
