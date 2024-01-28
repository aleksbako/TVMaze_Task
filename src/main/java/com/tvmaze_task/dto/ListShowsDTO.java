package com.tvmaze_task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;


import java.util.List;
@AllArgsConstructor
public class ListShowsDTO {
    @JsonProperty("data")
    List<ShowDTO> shows;
    //Add other properies if requirements specify.
}
