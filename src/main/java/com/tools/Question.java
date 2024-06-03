package com.tools;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.TreeMap;

@Getter
@Setter
@NonNull
@AllArgsConstructor
@ToString
public class Question {
    @SerializedName("id")
    private int id;
    @SerializedName("content")
    private String content;
    @SerializedName("suggestedAnswers")
    private TreeMap<String, String> suggestedAnswers;
    @SerializedName("rightAnswer")
    private String rightAnswer;
}
