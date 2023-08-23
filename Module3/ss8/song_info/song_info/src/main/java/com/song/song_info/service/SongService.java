package com.song.song_info.service;

import com.song.song_info.model.Song;
import com.song.song_info.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> showList() {
        return songRepository.findAll();
    }

    @Override
    public void addSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void editSong(Song song) {
        songRepository.save(song);
    }
}
