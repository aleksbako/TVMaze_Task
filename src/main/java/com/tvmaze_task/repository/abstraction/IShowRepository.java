package com.tvmaze_task.repository.abstraction;

import com.tvmaze_task.model.Show;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IShowRepository {
    Mono<List<Show>> FetchAllShows();
}
