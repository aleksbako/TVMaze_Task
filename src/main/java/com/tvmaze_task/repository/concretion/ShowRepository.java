package com.tvmaze_task.repository.concretion;

import com.tvmaze_task.model.Show;
import com.tvmaze_task.repository.abstraction.IShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class ShowRepository implements IShowRepository {


    private final WebClient webClient;
    @Autowired
    public ShowRepository(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.tvmaze.com").build();
    }

    /**
     * Fetch all the shows. The api returns the first page of shows which is up to 250 elements.
     * @return a list of Shows.
     */
    public Mono<List<Show>> FetchAllShows(){
        return webClient.get()
                .uri("/shows")
                .retrieve()
                .bodyToFlux(Show.class)
                .collectList();


    }

}
