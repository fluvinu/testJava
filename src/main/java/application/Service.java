package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    static String url="jdbc:mysql://localhost:3306/testjdbc";
    static String uname = "root";
    static String pass="tiger";
    static Connection conn;
    static {
        try {
            conn = DriverManager.getConnection(url,uname,pass);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Order> viwOder(){
        String quary= "select * from order_info";
        Statement stmt= null;
        List<Order> or= new ArrayList<>();
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(quary);
            while (rs.next()){
                Order ore= new Order();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return or;
    }


    public List<Product> viewProduct() {
        List<Product> proL= new ArrayList<>();
        String quary = "select * from product_info";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(quary);
            while (rs.next()){
                Product pro= new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
                proL.add(pro);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return proL;
    }

    public int removeProduct(int pid) {
        String quary="delete from product_info where pid=?";
        return 0;
    }

    public int placeProduct(String cNmae, int pId, int pQty) {
        try {
            CallableStatement cstmt= conn.prepareCall("{call placedOrder(?,?,?)}");
            cstmt.setString(1,cNmae);
            cstmt.setInt(2,pId);
            cstmt.setInt(3,pQty);
            cstmt.execute();
            System.out.println("qury executed");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 1;
    }
}
