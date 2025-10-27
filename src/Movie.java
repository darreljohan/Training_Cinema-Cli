import java.util.ArrayList;

public class Movie {
    String title;
    Genre genre;
    Integer duration;
    ArrayList<Schedule> schedules = new ArrayList<>();

    public Movie(String title, Genre genre, Integer duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public void appendSchedule(Schedule schedule){
        schedules.add(schedule);
    }

    public void printAllScheduleInformation (){
        for(Schedule schedule : schedules){
            System.out.printf("Movie: %s, Theater: %s, %s - %s  \n",
                    schedule.getMovie().getTitle(),
                    schedule.getTheater().getName(),
                    formatUtility.toFormattedDate(schedule.getStartTime()),
                    formatUtility.toFormattedDate(schedule.getEndTime())
            );
        }
    }

    public boolean isSchedulesEmpty(){
        return schedules.isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<Schedule> schedules) {
        this.schedules = schedules;
    }
}
