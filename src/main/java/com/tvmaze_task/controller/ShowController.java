package com.tvmaze_task.controller;

import com.tvmaze_task.dto.ListShowsDTO;
import com.tvmaze_task.service.abstraction.IShowService;
import com.tvmaze_task.util.RateLimited;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/shows")
@Tag(name = "Shows", description = "This is the shows api where you get to perform operation on Show entities.")
public class ShowController {

    private IShowService showService;

    @Autowired
    public ShowController(IShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/SortByGenre")
    @RateLimited(key = "shows", interval = 20L)
    @Operation(summary = "Fetch first page of pagination of shows sorted by Genre",
            description = "Fetch first page of pagination of shows from the TV Maze api and return the data sorted by Genre.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ListShowsDTO.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "401", content = {@Content(schema = @Schema())}, description = "Unauthorized! Provide apikey to access this endpoint."),
            @ApiResponse(responseCode = "403", content = {@Content(schema = @Schema())}, description = "Forbidden! Denied access to this endpoint with the provided apikey."),
            @ApiResponse(responseCode = "429", content = {@Content(schema = @Schema())}, description = "Too many requests made in a short period of time."),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}, description = "Internal error occurred while processing request.")
    }
    )
    public ResponseEntity<ListShowsDTO> GetTopShowsByGenre() {

        ListShowsDTO result = showService.FetchAllShowsSortByGenre();
        if (result == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ListShowsDTO(new ArrayList<>()));
        }

        return ResponseEntity.ok(result);
    }

}