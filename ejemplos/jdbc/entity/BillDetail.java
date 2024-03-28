package jdbc.entity;

public class BillDetail {
    private String id;
    private String productId;
    private String billId;
    private int quantity;
    private double subtotal;

    private Bill bill;
    private Product product;

    public BillDetail() {
    }

    public BillDetail(String id,String productId, String billId, int quantity, double subtotal) {
        this.productId = productId;
        this.billId = billId;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.id =id;
    }

    public BillDetail(String id,String productId, String billId, int quantity, double subtotal, Bill bill, Product product) {
        this.productId = productId;
        this.billId = billId;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.bill = bill;
        this.product = product;
        this.id =id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "BillDetail{" +
                "productId='" + productId + '\'' +
                ", billId='" + billId + '\'' +
                ", quantity=" + quantity +
                ", subtotal=" + subtotal +
                '}';
    }
}
