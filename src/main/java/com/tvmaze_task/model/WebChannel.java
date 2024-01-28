package com.tvmaze_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebChannel {
    @JsonProperty("name")
    private String name;
}