package com.example.aitest;
import com.tools.Quiz;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import static com.example.aitest.SetUpController.level;
import static com.example.aitest.SetUpController.topic;

public class TestController {
    @FXML
    private AnchorPane anchorPane;
    private Label[] questions = new Label[10];
    private RadioButton[][] multipleChoices = new RadioButton[10][5];
    @FXML
    private Button goBack;
    @FXML
    private Label result;

    @FXML
    private Label chosenLevel;
    @FXML
    private Label chosenTopic;
    private Quiz quiz;
    public void onCheckButton() {

        int counter = 0 ;
        for (int i = 0; i < questions.length; i++) {
            for (int j = 0; j < multipleChoices[i].length; j++) {
                RadioButton radioButton = multipleChoices[i][j];

                String correctFirstLetter = quiz.getQuestions().get(i).getRightAnswer().substring(0, 1);
                String selectedFirstLetter = radioButton.getText().substring(0, 1);

                boolean isCorrectAnswer = correctFirstLetter.equals(selectedFirstLetter);

                if (radioButton.isSelected()) {
                    if (isCorrectAnswer) {
                        //true
                        counter++;
                        radioButton.setTextFill(Color.GREEN);

                    } else {
                        //false
                        radioButton.setTextFill(Color.RED);
                    }
                } else if (isCorrectAnswer) {
                    //right answer
                    radioButton.setTextFill(Color.YELLOW);
                }
            }
        }
        chosenLevel.setText(level);
        chosenTopic.setText(topic);
        result.setText("Your result: " + counter + " out of 10");
    }

    public void initialize() {
        Request request = new Request();
        quiz = request.generateQuestions(topic, level);

        for (int i = 0; i < questions.length; i++) {
            questions[i] = new Label();
            questions[i].setText((i+1) + ". " + quiz.getQuestions().get(i).getContent());
            anchorPane.getChildren().add(questions[i]);
            if (i <= 4){
            questions[i].setLayoutX(300);
                questions[i].setLayoutY(i * 120);}
            else {questions[i].setLayoutX(800);
                questions[i].setLayoutY((i-5) * 120);}


            for (int j = 0; j < multipleChoices[i].length; j++) {
                multipleChoices[i][j] = new RadioButton();
                String letter = switch (j) {
                    case 0 -> "A";
                    case 1 -> "B";
                    case 2 -> "C";
                    case 3 -> "D";
                    case 4 -> "E";
                    default -> "";
                };
                multipleChoices[i][j].setText(letter + ". " + quiz.getQuestions().get(i).getSuggestedAnswers().get(letter));
                anchorPane.getChildren().add(multipleChoices[i][j]);
                if (i <= 4){
                multipleChoices[i][j].setLayoutX(300);
                multipleChoices[i][j].setLayoutY(questions[i].getLayoutY() + (j+1) * 20);}
                else {
                    multipleChoices[i][j].setLayoutX(800);
                    multipleChoices[i][j].setLayoutY(questions[i-5].getLayoutY() + (j+1) * 20);}

            }
        }

        goBack.setOnAction(e -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("window1.fxml")); // Replace with the path to your FXML file
                Scene scene = new Scene(root);
                Stage stage = (Stage) goBack.getScene().getWindow();
                stage.setScene(scene);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
