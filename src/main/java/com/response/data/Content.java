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
public class Content {

    @SerializedName("parts")
    private List<Part> parts;

    @SerializedName("role")
    private String role;


}
