package sample;


import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.sql.ResultSet;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class surface {
    Stage primarystage;
    BorderPane borderPane;
    public surface( BorderPane borderPane,Stage primarystage) {
        this.primarystage=primarystage;
        this.borderPane=borderPane;
    }

    TextField name;
    ObservableList<String> data,product,stats;
    ComboBox gender,product_type,status;
    TextField tel;
    TextField item_name;
    TextField price;
    File file;
    Image image;

    public void registration(){
        Label lname=new Label("Name_owner");
        name=new TextField();
        Label lgender=new Label("Gender");
        data= FXCollections.observableArrayList("Male","Female");
        gender=new ComboBox(data);
        Label ltel=new Label("Tel");
        tel=new TextField();
        Label lproduct=new Label("Product_type");
        product= FXCollections.observableArrayList("Jewelery","Clothes");
        product_type=new ComboBox(product);
        Label item=new Label("Item_name");
        item_name=new TextField();
        Label lprice=new Label("price");
        price=new TextField();
        Label laddress=new Label("address");
        TextField address=new TextField();
        Label lstatus=new Label("Status");
        stats=FXCollections.observableArrayList("booked","half-paid","fully-paid");
        status=new ComboBox(stats);
        ImageView imageView=new ImageView();
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        Button upload=new Button("upload");
        upload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fc=new FileChooser();//to choose file from machine;
//                FileChooser.ExtensionFilter ext1= new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");//sort of file(extension) allowed to choose .jpg
//                FileChooser.ExtensionFilter ext2= new FileChooser.ExtensionFilter("PNG files(*.png)","*.png");//sort of file(extension) allowed to choose .png
//                FileChooser.ExtensionFilter ext3=new FileChooser.ExtensionFilter("JPEG files(*.jpeg)","*.jpeg");
//                fc.getExtensionFilters().addAll(ext1,ext2,ext3);//allowed ext1(jpg) ext2(png) to be the allowed extension for this file_chooser, the rest is not.
                file=fc.showOpenDialog(primarystage);

                BufferedImage bf;
                try{
                    bf= ImageIO.read(file);
                    image= SwingFXUtils.toFXImage(bf,null);
                    imageView.setImage(image);
                }
                catch(Exception e){
                    System.out.print(e.getMessage());
                }


            }
        });



        Button submit=new Button("SUBMIT");
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name1=name.getText();
                String gender1=gender.getValue().toString();
                String tel1=tel.getText();
                String product_type1=product_type.getValue().toString();
                String item_name1=item_name.getText();
                String price1=price.getText();
                String address1=address.getText();
                String status1=status.getValue().toString();
                FileInputStream fin = null;
                try {
                    fin = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int len = (int)file.length();



                if(name1.isEmpty()||gender1.isEmpty()||tel1.isEmpty()||product_type1.isEmpty()||item_name1.isEmpty()||price1.isEmpty()||status1.isEmpty()||address1.isEmpty()){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setContentText("All field is mandatory");
                    alert.showAndWait();
                }
                else{
                    try{

                       database da=new database();
                       da.insert(name1,gender1,tel1,product_type1,item_name1,price1,address1,status1,fin,len);


                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Message");
                        alert.setContentText("Insert_successful");
                        alert.showAndWait();
                        name.setText("");
                        tel.setText("");
                        item_name.setText("");
                        price.setText("");
                        address.setText("");
                        name.requestFocus();
                    }
                    catch (Exception e){
                        System.out.print(e.getMessage());
                    }

                }
            }
        });







        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setVgap(8);
        gridPane.setHgap(8);
        gridPane.add(lname,7,2);
        gridPane.add(name,8,2);
        gridPane.add(lgender,7,4);
        gridPane.add(gender,8,4);
        gridPane.add(ltel,7,6);
        gridPane.add(tel,8,6);
        gridPane.add(lproduct,7,8);
        gridPane.add(product_type,8,8);
        gridPane.add(item,7,10);
        gridPane.add(item_name,8,10);
        gridPane.add(lprice,7,12);
        gridPane.add(price,8,12);
        gridPane.add(laddress,7,14);
        gridPane.add(address,8,14);
        gridPane.add(lstatus,7,16);
        gridPane.add(status,8,16);
        gridPane.add(upload,7,18);
        gridPane.add(imageView,8,18);
        gridPane.add(submit,8,20);
        gridPane.setAlignment(Pos.CENTER);



        borderPane.setCenter(gridPane);

    }





    ObservableList<product> data1;
    ImageView imageView;


    public void product_sold(){

//        TableView ta=new TableView();



        TableView<product> ta=new TableView<>();
        javafx.scene.control.TableColumn<sample.product, String> name1=new TableColumn<>("name");
        javafx.scene.control.TableColumn<sample.product, String> tel1=new TableColumn<>("tel");
        TableColumn<sample.product, String> categories1=new TableColumn<>("categories");
        javafx.scene.control.TableColumn<sample.product, String> item_name1=new TableColumn<>("item_name");
        javafx.scene.control.TableColumn<sample.product, String> price1=new TableColumn<>("price");
        javafx.scene.control.TableColumn<sample.product, String> status1=new TableColumn<>("status");



        Label label = new Label("Product_Sold");

        label.setFont(new Font("Arial", 40));
        label.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
//        ta.setEditable(true);
//        ta.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);


//        TableColumn name = new TableColumn("Name");
//        TableColumn tel = new TableColumn("Tel");
//        TableColumn type=new TableColumn("Categories");
//        TableColumn item_name = new TableColumn("Item_name");
//        TableColumn price=new TableColumn("Price");
//        TableColumn Status=new TableColumn("Status");
       ta.getColumns().addAll(name1,tel1,categories1,item_name1,price1,status1);
        ta.setEditable(true);
        ta.setPrefHeight(300);
       ta.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
       Button load=new Button("Loadtable");
       load.setPrefSize(200,10);
       load.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
       load.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               String query="SELECT * FROM product";
               Connection con1;
               try{
                   Class.forName("org.sqlite.JDBC");
                   con1=DriverManager.getConnection("jdbc:sqlite:truebrand.db");
                   data1=FXCollections.observableArrayList();
                  ResultSet rs=con1.createStatement().executeQuery(query);
                   while(rs.next()){
                       data1.add(new product(rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(9)));
                   }


               }
               catch (Exception e){
                   System.out.print(e.getMessage());
               }

               name1.setCellValueFactory(new PropertyValueFactory<>("name_property"));
               tel1.setCellValueFactory(new PropertyValueFactory<>("tel_property"));
               categories1.setCellValueFactory(new PropertyValueFactory<>("categories_property"));
               item_name1.setCellValueFactory(new PropertyValueFactory<>("item_name_property"));
               price1.setCellValueFactory(new PropertyValueFactory<>("price_property"));
               status1.setCellValueFactory(new PropertyValueFactory<>("status_property"));

               ta.setItems(null);
               ta.setItems(data1);

           }
       });



       Label item_name=new Label("Item_Name");
        TextField item_name_field=new TextField();
       Label owner=new Label("Owner");
        TextField owner_field=new TextField();
       Label price=new Label("Price");
        TextField price_field=new TextField();
       Label tel=new Label("Tel");
        TextField tel_field=new TextField();
        Button update=new Button("Update");
        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        Button delete=new Button("Delete");
         imageView=new ImageView();
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

       GridPane gridPane=new GridPane();
       gridPane.setVgap(15);
       gridPane.setHgap(15);

       gridPane.add(item_name,2,1);
       gridPane.add(item_name_field,3,1);
       gridPane.add(owner,2,2);
       gridPane.add(owner_field,3,2);
       gridPane.add(imageView,5,2);
       gridPane.add(price,2,3);
       gridPane.add(price_field,3,3);
       gridPane.add(tel,2,4);
       gridPane.add(tel_field,3,4);
       gridPane.add(update,5,4);
       gridPane.add(delete,6,4);


       gridPane.setAlignment(Pos.CENTER_LEFT);
       gridPane.setPadding(new Insets(5,5,5,5));

       gridPane.setPrefHeight(300);
       gridPane.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);


        setvaluefromtabletotextfield(ta,item_name_field,owner_field,price_field,tel_field);

        VBox v=new VBox();
        v.setSpacing(5);
        v.setPadding(new Insets(10, 10, 10, 10));
        VBox.setVgrow(label, Priority.ALWAYS);
        VBox.setVgrow(ta,Priority.ALWAYS);
        VBox.setVgrow(load,Priority.ALWAYS);
        VBox.setVgrow(gridPane,Priority.ALWAYS);
        v.getChildren().addAll(label,ta,load,gridPane);
        borderPane.setCenter(v);
    }

    private void setvaluefromtabletotextfield(TableView ta,TextField item_name,TextField price,TextField tel,TextField owner){
        ta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                product p1= (sample.product) ta.getItems().get(ta.getSelectionModel().getSelectedIndex());
                item_name.setText(p1.getItem_name_property());
                price.setText(p1.getPrice_property());
                tel.setText(p1.getTel_property());
                owner.setText(p1.getName_property());
                showimage(p1.getName_property());
            }
        });
    }

    private void showimage(String name){
        Connection con=null;
        try{
            PreparedStatement pst=con.prepareStatement("SELECT image FROM product WHERE name=?");
            pst.setString(2,name);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                InputStream is=rs.getBinaryStream(2);
                OutputStream os=new FileOutputStream(new File("photo.jpg"));
                byte[] contents=new byte[1024];
                int size=0;
                while ((size=is.read(contents))!=-1){
                    os.write(contents,0,size);
                }
                image=new Image("file:photo.jpg",imageView.getFitWidth(),imageView.getFitHeight(),true,true);
                imageView.setImage(image);
            }

        }catch (Exception e){
            System.out.print(e.getMessage());
        }

    }

    private void update_items(TextField item_name,TextField price,TextField tel,TextField owner,TableView ta){
        String sql="UPDATE product SET item_name=?, price=?, tel=?, name=? WHERE categories=? ";
        Connection connection = null;
        try{
            String item_name1=item_name.getText();
            String price1=price.getText();
            String tel1=tel.getText();
            String owner1=owner.getText();
            PreparedStatement pst=connection.prepareStatement(sql);
            pst.setString(2,owner1);
            pst.setString(4,tel1);
            pst.setString(6,item_name1);
            pst.setString(7,price1);

            int i= pst.executeUpdate();

            if(i==1){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Update Success");
                alert.showAndWait();
                database da=new database();
                da.display(data1);
                ta.setItems(data1);

            }


        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }

    }






    public void product_available(){

    }
    public void student_grade(){

    }


}

class registration implements command{
    surface s;
    public registration(surface s){
        this.s=s;
    }

    @Override
    public void execute() {
        this.s.registration();
    }

    @Override
    public void unexecute() {

    }
}

class product_sold implements command{

    surface s;
    public product_sold(surface s){
        this.s=s;
    }
    @Override
    public void execute() {
        this.s.product_sold();
    }

    @Override
    public void unexecute() {

    }
}


