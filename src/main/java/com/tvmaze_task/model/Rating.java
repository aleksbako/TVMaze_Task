package com.tvmaze_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Rating {
    @JsonProperty("average")
    private double average;
}