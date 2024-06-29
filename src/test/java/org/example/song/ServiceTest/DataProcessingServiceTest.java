package org.example.song.ServiceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.song.Entity.Song;
import org.example.song.Service.DataProcessingService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataProcessingServiceTest {

    @Test
    public void testNormalizeData() throws Exception {
        DataProcessingService dataProcessingService = new DataProcessingService();
        File jsonFile = new File("src/test/resources/input.json");

        List<Song> songs = dataProcessingService.normalizeData(jsonFile);

        assertNotNull(songs);
        assertEquals(100, songs.size());

        Song firstSong = songs.get(0);
        assertEquals("5vYA1mW9g2Coh1HUFUSmlb", firstSong.getId());
        assertEquals("3AM", firstSong.getTitle());
    }
}