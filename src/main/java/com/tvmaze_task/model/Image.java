package com.tvmaze_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Image {
    @JsonProperty("medium")
    private String medium;

    @JsonProperty("original")
    private String original;
}