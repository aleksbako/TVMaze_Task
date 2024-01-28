package com.tvmaze_task.service.concretion;

import com.tvmaze_task.dto.ListShowsDTO;
import com.tvmaze_task.dto.ShowDTO;
import com.tvmaze_task.mapper.ShowMapper;
import com.tvmaze_task.model.Show;
import com.tvmaze_task.repository.abstraction.IShowRepository;
import com.tvmaze_task.service.abstraction.IShowService;
import com.tvmaze_task.validation.ValidateShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService implements IShowService {

    private IShowRepository showRepository;

    @Autowired
    public ShowService(IShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public ListShowsDTO FetchAllShowsSortByGenre() {

        List<Show> shows = showRepository.FetchAllShows().block();
        if (shows == null) {
            return new ListShowsDTO(new ArrayList<>()); // Value does not exist.
        }

        //Remove data which has empty genre lists.

        boolean DataIsValid = ValidateShow.isListValid(shows);
        if (!DataIsValid) {
            shows = filterInvalidShows(shows);
        }

        shows.sort(Comparator.comparing(show -> String.join(",", show.getGenres())));

        List<ShowDTO> showDtos = new ArrayList<>();
        for (Show show : shows) {
            showDtos.add(ShowMapper.toShowDTO(show));
        }

        ListShowsDTO listShowsDTO = new ListShowsDTO(showDtos);

        return listShowsDTO;
    }

    private List<Show> filterInvalidShows(List<Show> shows) {
        return shows.stream()
                .filter(show -> ValidateShow.isValid(show))
                .collect(Collectors.toList());
    }

}