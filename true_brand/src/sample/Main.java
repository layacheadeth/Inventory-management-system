package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane border=new BorderPane();

        // this Imageview enable us to display the image we want and set it fitheight and width, put it in the hbox and but hbox in borderpane
        FileInputStream inputstream = new FileInputStream("/Users/deth/Desktop/truebrand.jpg");
        Image image=new Image(inputstream);
        ImageView view=new ImageView(image);
        view.setFitHeight(460);
        view.setFitWidth(500);
        HBox hbox=new HBox();
        border.setLeft(hbox);
        hbox.getChildren().add(view);

        Image image1=new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTV65RuNPIACmvx1wfT96TXZcPugavy5_iVfTjLNKghvxdgtIFd&usqp=CAU");
        ImageView view1=new ImageView(image1);
        view1.setFitWidth(100);
        view1.setFitHeight(100);

        Text scenetitle = new Text("Login_form");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        Label user=new Label("User: ");
        TextField textField=new TextField();
        textField.setPromptText("Username");


        Label password=new Label("Password:  ");
        PasswordField passwordField=new PasswordField();
        Button login=new Button("Login");
        login.setStyle("-fx-background-color: #1D82D4");
        Label register=new Label("Register_now");
        register.setTextFill(Color.STEELBLUE);


        // this gridpane is set in the borderpane on the right side
        // all gridpane need to set hgap and vgap in order to set each componenent more organize and clear using the row and column principal of gridpane.
        GridPane gridPane=new GridPane();
        gridPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        gridPane.setStyle("-fx-background-color: #F6F6F6");
        gridPane.setPadding(new Insets(5,5,5,5));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(view1,2,7);
        gridPane.add(scenetitle,0,20,2,1);
        gridPane.add(user,0,25);
        gridPane.add(textField,2,25);
        gridPane.add(password,0,28);
        gridPane.add(passwordField,2,28);
        gridPane.add(login,2,30);
        gridPane.add(register,2 ,40);

        border.setCenter(gridPane);

        // this button use lamda function to enable the action of the button
        login.setOnAction(e->{
            String user1=textField.getText();
            String pass=passwordField.getText();
            if(user1.equals("ace")&& pass.equals("078")){
                primaryStage.hide();//to hide the main stage and show the new stage
                App a=new App();
                a.start();


            }
            // else alert them with a message said Username or Password is incorrect
            else{
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setContentText("Username or Password is incorrect");
                alert.showAndWait();
            }


        });

        Scene scene=new Scene(border,840,460);

        // to enable the register label to switch the scene to registration scene.
        register.setOnMouseClicked(mouseEvent -> {
            primaryStage.setScene(register(primaryStage,scene));
        });






        primaryStage.setTitle("true_brand");

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    //this register scene require Stage and Scene so that it can be used in the main class and other as well by using it same functionalty but different variable(stage and scene)
    public Scene register(Stage primarystage, Scene scene){

        Label lname=new Label("Name");
        TextField name=new TextField();
        Label lgender=new Label("Gender");
        ObservableList<String> data= FXCollections.observableArrayList("Male","Female");
        ComboBox gender=new ComboBox(data);
        Label lemail=new Label("Email");
        TextField email=new TextField();
        Label ltel=new Label("Tel");
        TextField tel=new TextField();
        Button submit=new Button("Submit");

        Button goback=new Button("Goback");
        goback.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primarystage.setScene(scene);
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
        gridPane.add(lemail,7,6);
        gridPane.add(email,8,6);
        gridPane.add(ltel,7,8);
        gridPane.add(tel,8,8);
        gridPane.add(submit,8,10);
        gridPane.add(goback,9,10);

        gridPane.setAlignment(Pos.CENTER);
        Scene register=new Scene(gridPane,840,460);
        return register;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
