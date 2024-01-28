package com.tvmaze_task.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tvmaze_task.model.Image;
import com.tvmaze_task.model.Rating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

@Getter
@Setter
public class EpisodeDTO {

    @Id
    @JsonProperty("id")
    private int id;

    @JsonProperty("url")
    @NotBlank
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

    @JsonProperty("runtime")
    @Positive
    private int runtime;

    @JsonProperty("rating")
    private Rating rating;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("summary")
    @NotBlank
    private String summary;


}
