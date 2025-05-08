package chapter10.song;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> tracks;

    public Playlist() {
        this.tracks = new ArrayList<>();
    }

    public void append(Song song) {
        tracks.add(song);
    }

    public List<Song> getTracks() {
        return new ArrayList<>(tracks);
    }
}
