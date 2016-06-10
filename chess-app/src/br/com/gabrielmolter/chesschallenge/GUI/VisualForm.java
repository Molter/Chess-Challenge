package br.com.gabrielmolter.chesschallenge.GUI;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Gabriel Molter on 09/06/2016 at 19:45 BRT.
 */
public class VisualForm extends Application{


    /**
     * Main method
     * @param args
     */
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Molter Chess App");



        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 350, 400);
        primaryStage.setScene(scene);

        Text sceneTextTitle = new Text("Molter Chess App");
        sceneTextTitle.setFont(Font.font("Impact", FontWeight.BOLD, 22));
        grid.add(sceneTextTitle, 0, 0, 2, 1);

        Label bishopsLabel = new Label("Number of Bishops:");
        grid.add(bishopsLabel, 0, 1);

        TextField bishopsTextField = new TextField();
        bishopsTextField.setText("0");
        bishopsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                bishopsTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(bishopsTextField, 1, 1);




        Label kingsLabel = new Label("Number of Kings:");
        grid.add(kingsLabel, 0, 2);

        TextField kingsTextField = new TextField();
        kingsTextField.setText("2");
        kingsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                kingsTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(kingsTextField, 1, 2);


        Label kinghtsLabel = new Label("Number of Knights:");
        grid.add(kinghtsLabel, 0, 3);

        TextField knightsTextField = new TextField();
        knightsTextField.setText("0");
        knightsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                knightsTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(knightsTextField, 1, 3);


        Label queensLabel = new Label("Number of Queens:");
        grid.add(queensLabel, 0, 4);

        TextField queensTextField = new TextField();
        queensTextField.setText("0");
        queensTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                queensTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(queensTextField, 1, 4);

        Label rooksLabel = new Label("Number of Rooks:");
        grid.add(rooksLabel, 0, 5);

        TextField rooksTextField = new TextField();
        rooksTextField.setText("1");
        rooksTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                rooksTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(rooksTextField, 1, 5);

        Label sizeLabel = new Label("Number of Rows:");
        grid.add(sizeLabel, 0, 6);

        TextField sizeTextField = new TextField();
        sizeTextField.setText("3");
        sizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                sizeTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(sizeTextField, 1, 6);

        Label columnsLabel = new Label("Number of Columns:");
        grid.add(columnsLabel, 0, 7);

        TextField columnsTextField = new TextField();
        columnsTextField.setText("3");
        columnsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                columnsTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(columnsTextField, 1, 7);


        Button btn = new Button("Start");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 8);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 9);

        btn.setOnAction(e -> {
            actiontarget.setText("processing");
        });

        primaryStage.show();
    }


}
