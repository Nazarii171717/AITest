package com.response.data;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NonNull
@AllArgsConstructor
@ToString
public class Response {

    @SerializedName("candidates")
    private List<Candidate> candidates;

    @SerializedName("usageMetadata")
    private UsageMetadata usageMetadata;

}

