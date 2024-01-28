package com.tvmaze_task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class ListEpisodesDTO {
    @JsonProperty("data")
    List<EpisodeDTO> episodes;
    //Add other properies if requirements specify.
}
