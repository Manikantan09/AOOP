package com.example.musicstreaming.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    private static final Map<Long, Song> songs = new HashMap<>();

    static {
        songs.put(1L, new Song(1L, "Song One", "http://example.com/song1.mp3"));
        songs.put(2L, new Song(2L, "Song Two", "http://example.com/song2.mp3"));
    }

    @GetMapping("/play/{id}")
    public String playSong(@PathVariable Long id) {
        Song song = songs.get(id);
        if (song != null) {
            return "Playing " + song.getTitle() + " from " + song.getUrl();
        } else {
            return "Song not found";
        }
    }
}
