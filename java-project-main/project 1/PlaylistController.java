package com.example.musicstreaming.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final Map<Long, List<Song>> playlists = new HashMap<>();

    @PostMapping("/{userId}/add")
    public String addSongToPlaylist(@PathVariable Long userId, @RequestParam Long songId) {
        Song song = new Song(songId, "Mock Title", "Mock URL"); // For demonstration purposes
        playlists.computeIfAbsent(userId, k -> new ArrayList<>()).add(song);
        return "Song added to playlist";
    }

    @DeleteMapping("/{userId}/remove")
    public String removeSongFromPlaylist(@PathVariable Long userId, @RequestParam Long songId) {
        List<Song> userPlaylist = playlists.get(userId);
        if (userPlaylist != null) {
            userPlaylist.removeIf(song -> song.getId().equals(songId));
            return "Song removed from playlist";
        } else {
            return "Playlist not found";
        }
    }
}
