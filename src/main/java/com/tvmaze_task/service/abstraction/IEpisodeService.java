package com.tvmaze_task.service.abstraction;

import com.tvmaze_task.dto.ListEpisodesDTO;

public interface IEpisodeService {
    ListEpisodesDTO FetchTopFiveEpisodesInShowSummary(long id);
}
