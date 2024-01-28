package com.tvmaze_task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tvmaze_task.model.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

import java.util.List;
@Getter
@Setter
public class ShowDTO {
    @Id
    @JsonProperty("id")
    private int id;
    @JsonProperty("url")
    @NotBlank
    private String url;
    @JsonProperty("name")
    @NotBlank
    private String name;
    @JsonProperty("type")
    @NotBlank
    private String type;
    @JsonProperty("language")
    @NotBlank
    private String language;
    @JsonProperty("genres")
    private List<String> genres;
    @JsonProperty("status")
    private String status;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("officialSite")
    private String officialSite;
    @JsonProperty("schedule")
    private Schedule schedule;
    @JsonProperty("rating")
    private Rating rating;
    @JsonProperty("network")
    private Network network;
    @JsonProperty("webChannel")
    private WebChannel webChannel;

    @JsonProperty("image")
    private Image image;
    @JsonProperty("summary")
    private String summary;


}
