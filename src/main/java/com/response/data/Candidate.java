package com.response.data;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NonNull
@AllArgsConstructor
public class Candidate {

    @SerializedName("content")
    private Content content;

    @SerializedName("finishReason")
    private String finishReason;

    @SerializedName("index")
    private int index;

    @SerializedName("safetyRatings")
    private List<SafetyRating> safetyRatings;
}
