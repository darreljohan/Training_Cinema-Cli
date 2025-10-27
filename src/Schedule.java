import java.time.LocalDateTime;

public class Schedule {
    Theater theater;
    Movie movie;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Schedule(Theater theater, Movie movie, LocalDateTime startTime) {
        this.theater = theater;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = startTime.plusMinutes(movie.getDuration());
    }

    public void printScheduleInformation (){

            System.out.printf("Movie: %s, Theater: %s, %s - %s  \n",
                    this.movie.getTitle(),
                    this.theater.getName(),
                    formatUtility.toFormattedDate(this.startTime),
                    formatUtility.toFormattedDate(this.endTime)
            );

    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
