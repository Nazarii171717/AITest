package com.example.aitest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.response.data.Response;
import com.tools.Quiz;
import lombok.SneakyThrows;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request
{
    @SneakyThrows
    public Response makeRequest(String topic, String difficulty)
    {
        final String apiKey = "AIzaSyDoIn_5Bo11HSHYocuevQy3TDUIyj76i24";

        HttpClient client = HttpClient.newBuilder().build();
        String question =
                "Generate 10 multiple-choice questions on a specific topic: " + topic +
                " Each question should have a content (the question itself)," +
                " suggested answers (options A-E represented as a TreeMap where the key is a letter " +
                "and the value is the corresponding answer), and a right answer (the correct option letter)." +
                " The questions should be of a specified difficulty level: "  + difficulty +
                "The output should be formatted as a JSON object containing an array, without using code block markdown " +
                "(i.e., without json at the beginning and  at the end). The keys in the JSON object should be:" +
                " id, content, suggestedAnswers, and rightAnswer. The structure of the json file should be the following:" +
                        "{questions:[{{}}]}";
        String requestString = """
                {"contents":[{"parts":[{"text": "%s"}]}]}
                """.formatted(question);

        HttpRequest request =
                HttpRequest.newBuilder(
                                new URI("https://generativelanguage.googleapis" +
                                        ".com/v1beta/models/gemini-pro:generateContent?key="+apiKey))
                        .header("Content-Type","application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(requestString))
                        .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Response responseFromAI = gson.fromJson(response.body(), Response.class);
        return responseFromAI;
    }
    public Quiz generateQuestions(String topic, String difficulty)
    {
        Response response = makeRequest(topic, difficulty);
        String questionsAsJSONOb = response.getCandidates().get(0).getContent().getParts().get(0).getText();

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Quiz quiz = gson.fromJson(questionsAsJSONOb, Quiz.class);
        return quiz;
    }
}

