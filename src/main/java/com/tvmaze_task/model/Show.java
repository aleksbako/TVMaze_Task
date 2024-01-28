package com.tvmaze_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import nonapi.io.github.classgraph.json.Id;
import org.hibernate.validator.constraints.URL;

import java.util.List;
@AllArgsConstructor
@Getter
public class Show {
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
    @JsonProperty("type")
    @NotBlank
    private String type;
    @JsonProperty("language")
    @NotBlank
    private String language;
    @JsonProperty("genres")
    @NotEmpty
    private List<String> genres;
    @JsonProperty("status")
    private String status;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("averageRuntime")
    private double averageRuntime;
    @JsonProperty("premiered")
    private String premiered;
    @JsonProperty("ended")
    private String ended;
    @JsonProperty("officialSite")
    private String officialSite;
    @JsonProperty("schedule")
    private Schedule schedule;
    @JsonProperty("rating")
    private Rating rating;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("network")
    private Network network;
    @JsonProperty("webChannel")
    private WebChannel webChannel;
    @JsonProperty("dvdCountry")
    private DvdCountry dvdCountry;
    @JsonProperty("externals")
    private Externals externals;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("updated")
    private long updated;
    @JsonProperty("links")
    private Links links;

    public static class DvdCountry {}

    public static class Externals {
        private int tvrage;
        private int thetvdb;
        private String imdb;

    }

    public static class Links {
        private Self self;
        private PreviousEpisode previousEpisode;


    }

    public static class Self {
        private String href;
    }

    public static class PreviousEpisode {
        private String href;
    }


}