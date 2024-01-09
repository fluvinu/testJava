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
                System.out.println("======");
                break;
            case 4:
                System.out.println("enter ypur mane ");
                String cNmae= sc.next();
                System.out.println("enter product id ");
                int pId= sc.nextInt();
                System.out.println("enter product qty");
                int pQty= sc.nextInt();
                placeOrder(cNmae,pId,pQty);
                break;
            case 5:
                displayAllOrder();
        }
        main(args);
    }

    private static void displayAllOrder() {
        for(Order or:ser.viwOder()){

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
