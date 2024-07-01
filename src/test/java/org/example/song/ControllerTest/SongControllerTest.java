package org.example.song.ControllerTest;

import org.example.song.Controller.SongController;
import org.example.song.Entity.Song;
import org.example.song.Repository.SongRepository;
import org.example.song.Service.DataProcessingService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SongController.class)
public class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongRepository songRepository;

    @MockBean
    private DataProcessingService dataProcessingService;

    @Test
    public void testLoadData() throws Exception {
        when(dataProcessingService.normalizeData(ArgumentMatchers.any(File.class)))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/songs/load"))
                .andExpect(status().isOk())
                .andExpect(content().string("Data loaded successfully!"));

        verify(songRepository, times(1)).saveAll(Collections.emptyList());
    }

    @Test
    public void testGetAllSongs() throws Exception {
        Song song = new Song();
        song.setId("5vYA1mW9g2Coh1HUFUSmlb");
        song.setTitle("3AM");

        List<Song> songs = Collections.singletonList(song);
        when(songRepository.findAll(PageRequest.of(0, 10)))
                .thenReturn(new PageImpl<>(songs));

        mockMvc.perform(get("/api/songs?page=0&size=10"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':'5vYA1mW9g2Coh1HUFUSmlb','title':'3AM'}]"));
    }

    @Test
    public void testGetSongByTitle() throws Exception {
        Song song = new Song();
        song.setId("5vYA1mW9g2Coh1HUFUSmlb");
        song.setTitle("3AM");

        when(songRepository.findByTitle("3AM")).thenReturn(Collections.singletonList(song));

        mockMvc.perform(get("/api/songs/title")
                        .param("title", "3AM"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':'5vYA1mW9g2Coh1HUFUSmlb','title':'3AM'}"));
    }



    @Test
    public void testRateSong() throws Exception {
        Song song = new Song();
        song.setId("5vYA1mW9g2Coh1HUFUSmlb");
        song.setTitle("3AM");
        song.setStarRating(0.0);

        when(songRepository.findById("5vYA1mW9g2Coh1HUFUSmlb")).thenReturn(Optional.of(song));
        when(songRepository.save(song)).thenReturn(song);

        mockMvc.perform(post("/api/songs/rate")
                        .param("id", "5vYA1mW9g2Coh1HUFUSmlb")
                        .param("rating", "4.5"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id':'5vYA1mW9g2Coh1HUFUSmlb','title':'3AM','starRating':4.5}"));
    }

}
