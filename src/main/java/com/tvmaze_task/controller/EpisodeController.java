package com.tvmaze_task.controller;

import com.tvmaze_task.service.abstraction.IEpisodeService;
import com.tvmaze_task.util.RateLimited;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/episode")
@SecurityRequirement(name="Authorization")
@Tag(name = "Episode", description = "This is the Episode api where you get to perform operation on Episode entities.")
public class EpisodeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EpisodeController.class);

    private IEpisodeService episodeService;

    @Autowired
    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }




}
