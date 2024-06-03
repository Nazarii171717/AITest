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
public class Part {

    @SerializedName("text")
    private String text;


}
