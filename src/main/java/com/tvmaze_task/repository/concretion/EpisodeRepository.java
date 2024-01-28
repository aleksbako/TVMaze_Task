package com.tvmaze_task.repository.concretion;

import com.tvmaze_task.model.Episode;
import com.tvmaze_task.repository.abstraction.IEpisodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class EpisodeRepository implements IEpisodeRepository {
    private final WebClient webClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(EpisodeRepository.class);
    @Autowired
    public EpisodeRepository(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.tvmaze.com").build();
    }
    /**
     * Fetch top 5 episodes from a given show.
     * @param id the id of the show
     * @return a list of at most 5 episodes in order of highest rated to lowest.
     */
    public Mono<List<Episode>> FetchTopFiveEpisodesInShow(long id) {
        return webClient.get()
                .uri("/shows/{id}/episodes", id)
                .retrieve()
                .bodyToFlux(Episode.class)
                .collectList()
                .doOnError(error -> {
                    LOGGER.error("Error fetching episodes for show {}: {}", id, error.getMessage());
                })
                .onErrorReturn(List.of());

    }
}
