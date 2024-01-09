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
                Order ore= new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5));
                or.add(ore);
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
        int n=0;
        String quary="delete from product_info where pid=?";
        try {
            PreparedStatement pstrmt= conn.prepareStatement(quary);
            pstrmt.setInt(1,pid);
            n=pstrmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
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

    public int updateProduct(Product p4U) {
        String quary= "update product_info set pid=?,pname=?,pqty=?,pro_price=? where pid=?" ;
        int n=0;
        try {
            PreparedStatement pstmt= conn.prepareStatement(quary);
            pstmt.setInt(1,p4U.getpId());
            pstmt.setString(2,p4U.getpName());
            pstmt.setInt(3,p4U.getpQty());
            pstmt.setDouble(4,p4U.getPrice());
            pstmt.setInt(5,p4U.getpId());
           n= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
}
