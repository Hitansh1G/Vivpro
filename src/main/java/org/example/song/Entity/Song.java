package org.example.song.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;
    private String id;
    private String title;
    private double danceAbility;
    private double energy;
    private int mode;
    private double acousticness;
    private double tempo;
    private long durationMs;
    private int numSections;
    private int numSegments;
    private double starRating;

    // Getters and setters

    public Song(Long index, String id, String title, double danceability, double energy, int mode, double acousticness, double tempo, long durationMs, int numSections, int numSegments, double starRating) {
        this.index = index;
        this.id = id;
        this.title = title;
        this.danceAbility = danceability;
        this.energy = energy;
        this.mode = mode;
        this.acousticness = acousticness;
        this.tempo = tempo;
        this.durationMs = durationMs;
        this.numSections = numSections;
        this.numSegments = numSegments;
        this.starRating = starRating;
    }

    public Song() {
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDanceAbility() {
        return danceAbility;
    }

    public void setDanceAbility(double danceAbility) {
        this.danceAbility = danceAbility;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(long durationMs) {
        this.durationMs = durationMs;
    }

    public int getNumSections() {
        return numSections;
    }

    public void setNumSections(int numSections) {
        this.numSections = numSections;
    }

    public int getNumSegments() {
        return numSegments;
    }

    public void setNumSegments(int numSegments) {
        this.numSegments = numSegments;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }
}

