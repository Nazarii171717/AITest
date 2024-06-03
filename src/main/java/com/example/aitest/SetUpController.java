package com.example.aitest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
public class SetUpController {
    @FXML
    private ChoiceBox<String> difficultyLevel;
    protected static String level;
    @FXML
    private TextField textField;
    protected static String topic;
    @FXML
    private Button generateTest;
    @FXML
    public void initialize() {

        difficultyLevel.getItems().addAll("Easy", "Middle", "Hard");
        generateTest.setOnAction(e -> {
            try {
                topic = textField.getText();
                level = difficultyLevel.getSelectionModel().getSelectedItem();
                Parent root = FXMLLoader.load(getClass().getResource("window2.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) generateTest.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
