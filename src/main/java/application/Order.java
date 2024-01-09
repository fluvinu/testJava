package application;

public class Order {
    private int oid;
    private String cusNam;
    private int pid ;
    private int proQty;
    private double taatal;


    public Order(int oid, String cusNam, int pid, int proQty, double taatal) {
        this.oid = oid;
        this.cusNam = cusNam;
        this.pid = pid;
        this.proQty = proQty;
        this.taatal = taatal;
    }

    public int getOid() {
        return oid;
    }

    public String getCusNam() {
        return cusNam;
    }

    public int getPid() {
        return pid;
    }

    public int getProQty() {
        return proQty;
    }

    public double getTaatal() {
        return taatal;
    }
}
