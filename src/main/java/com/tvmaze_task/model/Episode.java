package com.tvmaze_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@Getter
@Setter
public class Episode {

    @Id
    @JsonProperty("id")
    private int id;

    @JsonProperty("url")
    @NotBlank
    @URL
    private String url;

    @JsonProperty("name")
    @NotBlank
    private String name;

    @JsonProperty("season")
    @Positive
    private int season;

    @JsonProperty("number")
    @Positive
    private int number;

    @JsonProperty("type")
    @NotBlank
    private String type;

    @JsonProperty("airdate")
    private String airdate;

    @JsonProperty("airtime")
    @DateTimeFormat
    private String airtime;

    @JsonProperty("airstamp")
    @DateTimeFormat
    private String airstamp;

    @JsonProperty("runtime")
    @Positive
    private int runtime;

    @JsonProperty("rating")
    private Rating rating;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("summary")
    private String summary;


}