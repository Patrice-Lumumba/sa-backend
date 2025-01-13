package com.example.emsbackend.controller;

import com.example.emsbackend.entities.Sentiment;
import com.example.emsbackend.enums.TypeSentiment;
import com.example.emsbackend.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "sentiment", produces = MediaType.APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment) {
        this.sentimentService.creer(sentiment);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type) {

        return this.sentimentService.rechercher(type);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id) {
        this.sentimentService.supprimer(id);
    }


}
