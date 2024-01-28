package com.tvmaze_task.mapper;

import com.tvmaze_task.dto.ShowDTO;
import com.tvmaze_task.model.Show;

public class ShowMapper {

    public static ShowDTO toShowDTO(Show show) {
        ShowDTO showDto = new ShowDTO();
        showDto.setId(show.getId());
        showDto.setUrl(show.getUrl());
        showDto.setName(show.getName());
        showDto.setType(show.getType());
        showDto.setLanguage(show.getLanguage());
        showDto.setGenres(show.getGenres());
        showDto.setStatus(show.getStatus());
        showDto.setRuntime(show.getRuntime());
        showDto.setOfficialSite(show.getOfficialSite());
        showDto.setSchedule(show.getSchedule());
        showDto.setRating(show.getRating());
        showDto.setNetwork(show.getNetwork());
        showDto.setWebChannel(show.getWebChannel());
        showDto.setImage(show.getImage());
        showDto.setSummary(show.getSummary());

        return showDto;

    }
}