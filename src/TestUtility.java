import java.time.LocalDateTime;

public class TestUtility {
    Cinema cinema;

    public TestUtility(Cinema cinema) {
        this.cinema = cinema;
    }

    public void injectMockData(){
        Theater gold = new Theater("Gold Screen", "Glebe Avenue 33", StudioClass.IMAX);
        Theater red = new Theater("Red Line", "Red Street 1 - 9", StudioClass.PREMIERE);
        Theater green = new Theater("Green Square", "Malcom Street 11", StudioClass.REGULAR);
        Theater lumia = new Theater("Lumia", "Ransom Point 22", StudioClass.REGULAR);

        Movie endless = new Movie("Endless Love", Genre.DRAMA, 100);
        Movie saw = new Movie("SAW", Genre.HORROR, 120);
        Movie american = new Movie("American Pie", Genre.COMEDY, 110);
        Movie avatar = new Movie("Avatar", Genre.SCIFI, 180);
        Movie wanted = new Movie("Wanted", Genre.ACTION, 120);

        cinema.appendTheater(gold);
        cinema.appendTheater(red);
        cinema.appendTheater(green);
        cinema.appendTheater(lumia);

        cinema.appendMovie(endless);
        cinema.appendMovie(saw);
        cinema.appendMovie(american);
        cinema.appendMovie(avatar);
        cinema.appendMovie(wanted);

    }

    public void injectMockDataWithSchedule(){
        Theater gold = new Theater("Gold Screen", "Glebe Avenue 33", StudioClass.IMAX);
        Theater red = new Theater("Red Line", "Red Street 1 - 9", StudioClass.PREMIERE);
        Theater green = new Theater("Green Square", "Malcom Street 11", StudioClass.REGULAR);
        Theater lumia = new Theater("Lumia", "Ransom Point 22", StudioClass.REGULAR);

        Movie endless = new Movie("Endless Love", Genre.DRAMA, 100);
        Movie saw = new Movie("SAW", Genre.HORROR, 120);
        Movie american = new Movie("American Pie", Genre.COMEDY, 110);
        Movie avatar = new Movie("Avatar", Genre.SCIFI, 180);
        Movie wanted = new Movie("Wanted", Genre.ACTION, 120);

        cinema.appendTheater(gold);
        cinema.appendTheater(red);
        cinema.appendTheater(green);
        cinema.appendTheater(lumia);

        cinema.appendMovie(endless);
        cinema.appendMovie(saw);
        cinema.appendMovie(american);
        cinema.appendMovie(avatar);
        cinema.appendMovie(wanted);

        Schedule date1 = new Schedule(lumia, saw, LocalDateTime.of(2020, 1, 1, 1,30));
        cinema.appendSchedule(date1);
        lumia.appendSchedule(date1);
        saw.appendSchedule(date1);

    }
}
