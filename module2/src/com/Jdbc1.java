package com;

import java.sql.*;

/**
 * ClassName:Jdbc1
 * Package:com
 * Date:2020/4/25 0:10
 * Author:TZM
 */
public class Jdbc1 {
    public static void main(String[] args) {
        Statement st=null;
        Connection con=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useSSL=false&serverTimezone=UTC","root","123456");

            st=con.createStatement();
            rs=st.executeQuery("select * from bookinfo");
            while (rs.next()){
                int bookID = rs.getInt("BookID");
                String bookname = rs.getString("Bookname");
                String publisher = rs.getString("Publisher");
                double price = rs.getDouble("Price");
                System.out.println("图书ID:"+bookID+"\t图书名称:"+bookname+"\t出版社:"+publisher+"\t价格:"+price);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
