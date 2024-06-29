package org.example.song.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.song.Entity.Song;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DataProcessingService {

    public List<Song> normalizeData(File jsonFile) throws IOException {
//        System.out.println("1");
        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println("12");
        JsonNode rootNode = objectMapper.readTree(jsonFile);
//        System.out.println("123");

        JsonNode idNode = rootNode.path("id");
        JsonNode titleNode = rootNode.path("title");
        JsonNode danceabilityNode = rootNode.path("danceability");
        JsonNode energyNode = rootNode.path("energy");
        JsonNode modeNode = rootNode.path("mode");
        JsonNode acousticnessNode = rootNode.path("acousticness");
        JsonNode tempoNode = rootNode.path("tempo");
        JsonNode durationMsNode = rootNode.path("duration_ms");
        JsonNode numSectionsNode = rootNode.path("num_sections");
        JsonNode numSegmentsNode = rootNode.path("num_segments");
//        System.out.println("1234");


        List<Song> songs = new ArrayList<>();
        Iterator<String> fieldNames = idNode.fieldNames();

        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            Song song = new Song();
            song.setId(idNode.get(fieldName).asText());
            song.setTitle(titleNode.get(fieldName).asText());
            song.setDanceAbility(danceabilityNode.get(fieldName).asDouble());
            song.setEnergy(energyNode.get(fieldName).asDouble());
            song.setMode(modeNode.get(fieldName).asInt());
            song.setAcousticness(acousticnessNode.get(fieldName).asDouble());
            song.setTempo(tempoNode.get(fieldName).asDouble());
            song.setDurationMs(durationMsNode.get(fieldName).asInt());
            song.setNumSections(numSectionsNode.get(fieldName).asInt());
            song.setNumSegments(numSegmentsNode.get(fieldName).asInt());
            song.setStarRating(0.0); // Default star rating
            songs.add(song);
        }

        return songs;
    }
}
