package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

    }

    public  static void main(String [] args){
        launch(args);
    }




    public void start() {
        Stage stage=new Stage();
        BorderPane borderPane=new BorderPane();
        //The vbox section
        Button product=new Button("Register_Product");
        //we set PrefSize so that it will first display its defaultsize.
        product.setPrefSize(300,100);
        product.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //we set MaxSize so that when it's resizing , it will only show the max width that fit or response to the stage(responsive sizing).
        product.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                invoker in=new invoker();
                surface s=new surface(borderPane,stage);

                in.setRegistration(new registration(s));
                in.registrationpressed();


            }
        });
        Button register=new Button("Product_Sold");
        //we set PrefSize so that it will first display its defaultsize.
        register.setPrefSize(300,100);
        register.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //we set MaxSize so that when it's resizing , it will only show the max width that fit or response to the stage(responsive sizing).
        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                invoker invoker=new invoker();
                surface s=new surface(borderPane,stage);

                invoker.setProduct_sold(new product_sold(s));
                invoker.product_soldpressed();
            }
        });
        Button data =new Button("Product_available");
        //we set PrefSize so that it will first display its defaultsize.
        data.setPrefSize(300,100);
        data.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //we set MaxSize so that when it's resizing , it will only show the max width that fit or response to the stage(responsive sizing).

        data.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Label da=new Label("Data");
                StackPane stackPane=new StackPane(da);
                borderPane.setCenter(stackPane);
            }
        });
        Button detail=new Button("Payment");
        //we set PrefSize so that it will first display its defaultsize.
        detail.setPrefSize(300,100);
        detail.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //we set MaxSize so that when it's resizing , it will only show the max width that fit or response to the stage(responsive sizing).
        detail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Label deta=new Label("Detail");
                StackPane stackPane=new StackPane(deta);
                borderPane.setCenter(stackPane);
            }
        });
        VBox vBox=new VBox();
        // setVgrow is the property that enable the node in vbox to grow responsively to the stage by taking the max-size when maximize, and default when it first appear.
        VBox.setVgrow(product, Priority.ALWAYS);
        VBox.setVgrow(register,Priority.ALWAYS);
        VBox.setVgrow(data,Priority.ALWAYS);
        VBox.setVgrow(detail,Priority.ALWAYS);
        vBox.getChildren().addAll(product,register,data,detail);

        borderPane.setLeft(vBox);
        //

        //The hbox section


        Scene scene=new Scene(borderPane,900,700);

        stage.setTitle("True_brand");
        stage.setScene(scene);
        stage.show();
    }


}

