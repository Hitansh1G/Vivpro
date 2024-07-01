package org.example.song.Repository;

import org.example.song.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByTitle(String title);
    Optional<Song>findById(String id);


}
