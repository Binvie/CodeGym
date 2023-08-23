package com.song.song_info.service;

import com.song.song_info.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> showList();
    void addSong(Song song);
    void editSong(Song song);
}
