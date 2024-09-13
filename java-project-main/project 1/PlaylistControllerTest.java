package com.example.musicstreaming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PlaylistController.class)
public class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddAndRemoveSongFromPlaylist() throws Exception {
        // Test adding a song to the playlist
        mockMvc.perform(MockMvcRequestBuilders.post("/playlists/1/add?songId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Song added to playlist"));

        // Test removing a song from the playlist
        mockMvc.perform(MockMvcRequestBuilders.delete("/playlists/1/remove?songId=1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Song removed from playlist"));
    }
}
