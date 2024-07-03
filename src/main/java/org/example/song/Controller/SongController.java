package org.example.song.Controller;

import org.example.song.Entity.Song;
import org.example.song.Exceptions.ResourceNotFoundException;
import org.example.song.Repository.SongRepository;
import org.example.song.Service.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;
 
//    public SongController(SongRepository songRepository) {
//        this.songRepository = songRepository;
//    }

    @Autowired
    private DataProcessingService dataProcessingService;
    //    public SongController(SongRepository songRepository, DataProcessingService dataProcessingService) {
//        this.songRepository = songRepository;
//        this.dataProcessingService = dataProcessingService;
//    }
    @GetMapping("/load")
    public String loadData() {
        try {
            File jsonFile = new File("input/input.json");
            List<Song> songs = dataProcessingService.normalizeData(jsonFile);
            songRepository.saveAll(songs);
            return "Data loaded successfully!";
        } catch (IOException e) {
            return "Failed to load data: " + e.getMessage();
        }
    }

    @GetMapping
    public List<Song> getAllSongs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Song> songPage = songRepository.findAll(PageRequest.of(page, size));
        return songPage.getContent();
    }

    @GetMapping("/title")
    public ResponseEntity<?> getSongByTitle(@RequestParam String title) {
        List<Song> songs = songRepository.findByTitle(title);
        if (songs.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if no songs found
        } else {
            return ResponseEntity.ok(songs.get(0)); // Return the first song found
        }
    }


//    @PostMapping("/rate")
//    public Song rateSong(@RequestParam String id, @RequestParam double rating) {
//        Song song = songRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id " + id));
//        song.setStarRating(rating);
//
//        return songRepository.save(song);
//    }
    @PostMapping("/rate")
    public Song rateSong(@RequestParam String id, @RequestParam double rating) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song not found with id " + id));

        int tempRating = song.getRatingCount()+1;
        song.setRatingCount(tempRating);
        double currRatingSum = song.getRatingSum();
        song.setRatingSum(currRatingSum + rating);
        //new rating is (oldSum + newRating)/count;
        int currCount = song.getRatingCount();
        double avgRating = song.getRatingSum() / currCount;
        song.setStarRating(avgRating);

        return songRepository.save(song);
    }

}