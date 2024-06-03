package com.example.aitest;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class TestApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("window2.fxml"));
        Scene scene2 = new Scene(root2);
        stage.setTitle("Test");
        stage.setScene(scene2);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}