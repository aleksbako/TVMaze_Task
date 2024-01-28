package com.tvmaze_task.controller;

import com.tvmaze_task.dto.ListEpisodesDTO;
import com.tvmaze_task.service.abstraction.IEpisodeService;
import com.tvmaze_task.util.RateLimited;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@SecurityRequirement(name = "Authorization")
@Tag(name = "Episode", description = "This is the Episode api where you get to perform operation on Episode entities.")
public class EpisodeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EpisodeController.class);

    private IEpisodeService episodeService;

    @Autowired
    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/top/{showId}")
    @RateLimited(key = "episode", interval = 20L)
    @Operation(summary = "Fetch top 5 episodes for a given show entity",
            description = "Given a showId , fetch 5 most highly rated episodes for a given series and present them as a string to the user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ListEpisodesDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema())}, description = "Bad Request! showId provided is <= 0. Please provide positive value for showId."),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema())}, description = "Unauthorized! Provide apikey to access this endpoint."),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}, description = "Forbidden! Denied access to this endpoint with the provided apikey."),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}, description = "Internal error occurred while processing request.")
    }
    )
    public ResponseEntity<ListEpisodesDTO> GetTopFiveEpisodesForShow(@Parameter(description = "The id of the show fetched from TV Maze.") @PathVariable long showId) {
        if (showId <= 0) {
            LOGGER.error("Invalid showId: {}", showId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ListEpisodesDTO(new ArrayList<>()));
        }

        ListEpisodesDTO result = episodeService.FetchTopFiveEpisodesInShowSummary(showId);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ListEpisodesDTO(new ArrayList<>()));
        }

        return ResponseEntity.ok(result);
    }

}