package chapter10.song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playlist {
    private List<Song> tracks;
    private Map<String, String> singers;

    public Playlist() {
        this.tracks = new ArrayList<>();
        this.singers = new HashMap<>();
    }

    public void append(Song song) {
        tracks.add(song);
        singers.put(song.getSinger(), song.getTitle());
    }

    public List<Song> getTracks() {
        return new ArrayList<>(tracks);
    }

    public Map<String, String> getSingers() {
        return new HashMap<>(singers);
    }
}
