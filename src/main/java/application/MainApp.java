package application;

import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    static Service ser= new Service();
    public static void main(String[] args) {
        System.out.println("slecet option");
        System.out.println("1 display all product");
        System.out.println("2 emovw prodiuct");
        System.out.println("3 update product");
        System.out.println("4 placed oeder ");
        System.out.println("5 display all order");
        System.out.println("6 exit");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                displayProduct();
                break;
            case 2:
                System.out.println("enter product id");
                int pid = sc.nextInt();
                int n=ser.removeProduct(pid);
                break;
            case 3:
                System.out.println("enter product id ");
                int cpid= sc.nextInt();
                System.out.println("enter updated name ");
                String nameU=sc.next();
                System.out.println("enter pQty");
                int pQty=sc.nextInt();
                System.out.println("enter price to update ");
                double price =sc.nextDouble();
                updateProduct(cpid,nameU,pQty,price);

                break;
            case 4:
                System.out.println("enter ypur mane ");
                String cNmae= sc.next();
                System.out.println("enter product id ");
                int pId= sc.nextInt();
                System.out.println("enter product qty");
                int pQtyy= sc.nextInt();
                placeOrder(cNmae,pId,pQtyy);
                break;
            case 5:
                displayAllOrder();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("inavald input");
        }
        main(args);
    }

    private static void updateProduct(int cpid, String nameU, int pQty, double price) {
        Product p4U=new Product(cpid,nameU,pQty,price);
        int n= ser.updateProduct(p4U);
    }


    private static void displayAllOrder() {
        for(Order or:ser.viwOder()){
            System.out.println(or.getOid()+" "+or.getCusNam()+" "+or.getPid()+" "+or.getProQty()+" "+or.getTaatal());
        }
    }

    private static void placeOrder(String cNmae, int pId, int pQty) {
        int n=ser.placeProduct(cNmae,pId,pQty);
        System.out.println(n+" row updated");
    }

    public static void displayProduct(){
        for(Product pro:ser.viewProduct()){
            System.out.println(pro.getpId()+" "+ pro.getpQty()+"  "+ pro.getPrice()+"  "+pro.getpName());
        }
    }

}
