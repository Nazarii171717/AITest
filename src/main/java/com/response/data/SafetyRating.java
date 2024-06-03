package com.response.data;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NonNull
@AllArgsConstructor
public class SafetyRating {

    @SerializedName("category")
    private String category;

    @SerializedName("probability")
    private String probability;


}
