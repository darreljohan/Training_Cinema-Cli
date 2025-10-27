import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Cinema {
    HashMap<String, Movie> movies = new HashMap<>();
    LinkedList<Schedule> schedules = new LinkedList<>();
    HashMap<String, Theater> theaters = new HashMap<>();

    public Cinema() {
    }

    public void appendSchedule(Schedule schedule){
        schedules.add(schedule);
    }

    public void appendMovie(Movie movie){
        movies.put(movie.getTitle().replaceAll("\\s+", "").toLowerCase(), movie);
    }

    public void appendTheater(Theater theater){
        theaters.put(theater.getName().replaceAll("\\s+", "").toLowerCase(), theater);
    }

    public Theater getTheaterByName(String name){
        return theaters.get(name);
    }

    public Movie getMovieByTitle(String title){
        return movies.get(title);
    }

    public HashMap<String, Movie> getMovies() {
        return movies;
    }

    public void setMovies(HashMap<String, Movie> movies) {
        this.movies = movies;
    }

    public LinkedList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(LinkedList<Schedule> schedules) {
        this.schedules = schedules;
    }

    public HashMap<String, Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(HashMap<String, Theater> theaters) {
        this.theaters = theaters;
    }
}
