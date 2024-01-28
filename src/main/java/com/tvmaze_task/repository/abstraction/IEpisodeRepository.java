package com.tvmaze_task.repository.abstraction;

import com.tvmaze_task.model.Episode;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IEpisodeRepository {
    Mono<List<Episode>> FetchTopFiveEpisodesInShow(long id);
}
