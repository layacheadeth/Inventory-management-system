package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// this is the database section
//all of the database operation will be called into action from here.

public class database {
    // this is insert function(insert into database)
    public void insert(String name, String gender, String tel, String product_type, String item_name, String price, String address, String status,FileInputStream fin,int len) throws Exception {
        String sql="INSERT INTO product(name,gender,tel,product_type,item_name,price,address,status,image) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst=null;
        Connection conn=null;
        try{

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:truebrand.db");
             pst=conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,gender);
            pst.setString(3,tel);
            pst.setString(4,product_type);
            pst.setString(5,item_name);
            pst.setString(6,price);
            pst.setString(7,address);
            pst.setString(8,status);
            pst.setBinaryStream(9,fin,len);
            pst.executeUpdate();
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        finally{
            conn.close();
            pst.close();
        }
    }

    public void display(ObservableList<product> data1){
        String query="SELECT * FROM product";
        Connection con1;
        try{
            Class.forName("org.sqlite.JDBC");
            con1=DriverManager.getConnection("jdbc:sqlite:truebrand.db");
            data1= FXCollections.observableArrayList();
            ResultSet rs=con1.createStatement().executeQuery(query);
            while(rs.next()){
                data1.add(new product(rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(9)));
            }


        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

}
