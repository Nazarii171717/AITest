package com.tools;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NonNull
@AllArgsConstructor
@ToString
public class Quiz {
    @SerializedName("questions")
    private List<Question> questions;
}
