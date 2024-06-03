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
public class UsageMetadata {

    @SerializedName("promptTokenCount")
    private int promptTokenCount;

    @SerializedName("candidatesTokenCount")
    private int candidatesTokenCount;

    @SerializedName("totalTokenCount")
    private int totalTokenCount;


}
