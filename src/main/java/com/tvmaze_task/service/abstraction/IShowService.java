package com.tvmaze_task.service.abstraction;

import com.tvmaze_task.dto.ListShowsDTO;

public interface IShowService {
    ListShowsDTO FetchAllShowsSortByGenre();
}
