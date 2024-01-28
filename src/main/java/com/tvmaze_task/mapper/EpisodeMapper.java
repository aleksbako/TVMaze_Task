package com.tvmaze_task.mapper;

import com.tvmaze_task.dto.EpisodeDTO;
import com.tvmaze_task.model.Episode;

public class EpisodeMapper {
    public static EpisodeDTO toEpisodeDTO(Episode episode){
        EpisodeDTO episodeDto = new EpisodeDTO();
        episodeDto.setId(episode.getId());
        episodeDto.setUrl(episode.getUrl());
        episodeDto.setName(episode.getName());
        episodeDto.setSeason(episode.getSeason());
        episodeDto.setNumber(episode.getNumber());
        episodeDto.setType(episode.getType());
        episodeDto.setAirdate(episode.getAirdate());
        episodeDto.setRuntime(episode.getRuntime());
        episodeDto.setRating(episode.getRating());
        episodeDto.setImage(episode.getImage());
        episodeDto.setSummary(episode.getSummary());

        return episodeDto;
    }
}
