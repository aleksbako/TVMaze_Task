package com.tvmaze_task.service.concretion;

import com.tvmaze_task.dto.EpisodeDTO;
import com.tvmaze_task.dto.ListEpisodesDTO;
import com.tvmaze_task.mapper.EpisodeMapper;
import com.tvmaze_task.model.Episode;
import com.tvmaze_task.model.Show;
import com.tvmaze_task.repository.abstraction.IEpisodeRepository;
import com.tvmaze_task.service.abstraction.IEpisodeService;
import com.tvmaze_task.validation.ValidateEpisode;
import com.tvmaze_task.validation.ValidateShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService implements IEpisodeService {

    private IEpisodeRepository episodeRepository;

    @Autowired
    public EpisodeService(IEpisodeRepository episodeRepository){
        this.episodeRepository = episodeRepository;
    }
    /**
     * Fetch top 5 episodes from a given show.
     * @param id the id of the show
     * @return a list of at most 5 episodes in order of highest rated to lowest.
     */
    @Override
    public ListEpisodesDTO FetchTopFiveEpisodesInShowSummary(long id) {
        List<Episode> episodes = episodeRepository.FetchTopFiveEpisodesInShow(id).block();

        if(episodes == null){
            return new ListEpisodesDTO(new ArrayList<>()); // Value does not exist.
        }

        boolean DataIsValid = ValidateEpisode.isListValid(episodes);


        if(!DataIsValid){
            episodes = filterInvalidEpisodes(episodes);
        }

        episodes.sort(Comparator.comparingDouble((Episode episode) -> episode.getRating().getAverage()).reversed());
        int limit = Math.min(5, episodes.size());

        List<Episode> topFiveEpisodes = episodes.subList(0, limit);
        List<EpisodeDTO> episodeDtos = new ArrayList<>();

        for(Episode e : topFiveEpisodes){
            episodeDtos.add(EpisodeMapper.toEpisodeDTO(e));
        }
        ListEpisodesDTO listEpisodesDTO = new ListEpisodesDTO(episodeDtos);

        return listEpisodesDTO;
    }

    private List<Episode> filterInvalidEpisodes(List<Episode> episodes) {
        return episodes.stream()
                .filter(episode -> ValidateEpisode.isValid(episode))
                .collect(Collectors.toList());
    }
}
