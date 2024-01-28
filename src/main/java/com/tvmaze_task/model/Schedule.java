package com.tvmaze_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Schedule {
    @JsonProperty("time")
    private String time;
    @JsonProperty("days")
    private List<String> days;
}
