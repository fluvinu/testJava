package application;

public class Product {
    private int pId;
    private  String pName;
    private int pQty;

    private double price;

    public Product(int pId, String pName, int pQty, double price) {
        this.pId = pId;
        this.pName = pName;
        this.pQty = pQty;
        this.price = price;
    }

    public Product() {
    }

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public int getpQty() {
        return pQty;
    }

    public double getPrice() {
        return price;
    }
}
