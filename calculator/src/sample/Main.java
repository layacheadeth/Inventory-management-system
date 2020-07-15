package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    TextField answer;
    double getans;
    int opt;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Button sum,substract,multiply,divide,module,equal,non_int,clear;
    Button minus,percent;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        answer=new TextField();
        answer.setEditable(false);
        answer.setFont(new Font("Cambria", 32));
        StackPane pane=new StackPane();
        pane.setAlignment(Pos.BOTTOM_RIGHT);
        pane.getChildren().add(answer);

        b0=new Button("0");
        b1=new Button("1");
        b2=new Button("2");
        b3=new Button("3");
        b4=new Button("4");
        b5=new Button("5");
        b6=new Button("6");
        b7=new Button("7");
        b8=new Button("8");
        b9=new Button("9");

        sum=new Button("+");
        substract=new Button("-");
        multiply=new Button("*");
        divide=new Button("/");
        module=new Button("%");
        equal=new Button("=");
        non_int=new Button(".");
        clear=new Button("Clear");
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText("");
            }
        });

        minus=new Button("Neg");
        percent=new Button("per");

        number();


        GridPane gridPane=new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);

        setsize();



        gridPane.add(clear,0,0);
        gridPane.add(minus,1,0);
        gridPane.add(module,2,0);
        gridPane.add(divide,3,0);

        gridPane.add(b7,0,1);
        gridPane.add(b8,1,1);
        gridPane.add(b9,2,1);
        gridPane.add(multiply,3,1);

        gridPane.add(b4,0,2);
        gridPane.add(b5,1,2);
        gridPane.add(b6,2,2);
        gridPane.add(substract,3,2);

        gridPane.add(b1,0,3);
        gridPane.add(b2,1,3);
        gridPane.add(b3,2,3);
        gridPane.add(sum,3,3);

        gridPane.add(b0,0,4);
        gridPane.add(non_int,1,4);
        gridPane.add(percent,2,4);
        gridPane.add(equal,3,4);

        BorderPane borderPane=new BorderPane();
        borderPane.setBottom(gridPane);
        borderPane.setTop(pane);

        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(borderPane, 400, 400));
        primaryStage.show();
    }

    private void setsize(){
        answer.setPrefSize(100,100);

        b0.setPrefSize(100,50);
        b1.setPrefSize(100,50);
        b2.setPrefSize(100,50);
        b3.setPrefSize(100,50);
        b4.setPrefSize(100,50);
        b5.setPrefSize(100,50);
        b6.setPrefSize(100,50);
        b7.setPrefSize(100,50);
        b8.setPrefSize(100,50);
        b9.setPrefSize(100,50);

        sum.setPrefSize(100,50);
        substract.setPrefSize(100,50);
        multiply.setPrefSize(100,50);
        divide.setPrefSize(100,50);
        module.setPrefSize(100,50);
        non_int.setPrefSize(100,50);
        equal.setPrefSize(100,50);
        clear.setPrefSize(100,50);

        minus.setPrefSize(100,50);
        percent.setPrefSize(100,50);

    }
    double data;
    int operation=-1;
    double ans;
    private void number(){
        b0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"0");
            }
        });
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"1");
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"2");
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"3");
            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"4");
            }
        });
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"5");
            }
        });
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"6");
            }
        });
        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"7");
            }
        });
        b8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"8");
            }
        });
        b9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                answer.setText(answer.getText()+"9");
            }
        });
        sum.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data=Double.parseDouble(answer.getText());
                operation=1;
                answer.setText("");
            }
        });
        substract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data=Double.parseDouble(answer.getText());
                operation=2;
                answer.setText("");
            }
        });
        multiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data=Double.parseDouble(answer.getText());
                operation=3;
                answer.setText("");
            }
        });
        divide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data=Double.parseDouble(answer.getText());
                operation=4;
                answer.setText("");
            }
        });
        equal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double second=Double.parseDouble(answer.getText());
                switch(operation){
                    case 1:{
                        ans=data+second;
                        answer.setText(String.valueOf(ans));
                    }
                    break;
                    case 2:{
                        ans=data-second;
                        answer.setText(String.valueOf(ans));
                    }
                    break;
                    case 3:{
                        ans=data*second;
                        answer.setText(String.valueOf(ans));
                    }
                    break;
                    case 4:{
                        try{
                            ans=data/second;
                        }
                        catch(Exception e){
                            answer.setText("Error");
                        }

                        answer.setText(String.valueOf(ans));
                    }
                    break;
                    default:break;
                }
            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
