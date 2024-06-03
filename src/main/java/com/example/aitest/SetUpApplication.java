package com.example.aitest;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SetUpApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("window1.fxml"));
        Scene scene1 = new Scene(root1);
        stage.setTitle("Preview");
        stage.setScene(scene1);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}