package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovieTheatreService {

    private Map<String, List<Movie> shows = new LinkedHashMap<>();

    public Map<String, List<Movie>> getShows() {
        return shows;
    }

    public void readFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String item : lines) {
                parseLine(item);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Error: Don't read file", ioe);
        }
    }

    private void parseLine(String item) {
        String[] parts = item.split("-");
        String[] partsTwoo = parts[1].split(";");
        if (!shows.containsKey(parts[0])) {
            shows.put(parts[0], new ArrayList<>());
        }
        shows.get(parts[0]).add(new Movie(partsTwoo[0], LocalTime.parse(parts[1])));
    }

    private void parseLine(String item) {
        String[] parts = item.split("-");
        String[] partsTwoo = parts[1].split(";");
        if (!shows.containsKey(parts[0])) {
            shows.put(parts[0], new ArrayList<>());
        }
        shows.get(parts[0]).sort();
    }



}
