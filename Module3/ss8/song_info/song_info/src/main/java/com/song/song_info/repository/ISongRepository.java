package com.song.song_info.repository;

import com.song.song_info.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
//    @Query(value = "select * from song ;", nativeQuery = true)
//    List<Song> showList();
//
//    @Query(value = "insert into song(name,artist,musicType) values (:#{#song.name},:#{#song.artist},:#{#song.musicType})",nativeQuery = true)
//    void addSong(Song song);
//
//    @Query(value = "update song set name = :#{#song.name}, artist = :#{#song.artist}, music_type = :#{#song.musicType} where id = :#{#song.id} )",nativeQuery = true)
//    void editSong(Song song);
}
