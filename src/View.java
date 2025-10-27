import java.time.LocalDateTime;

public class View {
    Cinema cinema;

    public View(Cinema cinema) {
        this.cinema = cinema;
    }

    public void mainMenu(){
        try {
            System.out.println("\n======================MAIN MENU======================\n");
            System.out.println("Input salah satu angka menu:");
            System.out.println("1. Lihat seluruh Theater");
            System.out.println("2. Lihat seluruh Movie");
            System.out.println("3. Lihat seluruh Schedule");
            System.out.println("4. Exit Application");

            switch (InputUtility.inputInteger("", 1, 4)){
                case 1:
                    theaterMenu();
                    break;
                case 2:
                    movieMenu();
                    break;
                case 3:
                    System.out.println("\n======================SCHEDULE MENU======================\n");
                    showAllSchedules();
                    mainMenu();
                    break;
                case 4:
                    break;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            mainMenu();
        }
    }

    public void theaterMenu(){
        try {
            System.out.println("\n======================THEATER MENU======================\n");
            showAllTheaters();
            System.out.println("Input salah satu angka di menu:");
            System.out.println("1. Lihat detail jadwal Theater");
            System.out.println("2. Tambah schedule");
            System.out.println("3. Back to Main Menu");

            switch (InputUtility.inputInteger("", 1, 3)) {
                case 1:
                    showTheaterSchedulesMenu();
                    theaterMenu();
                    break;
                case 2:
                    addScheduleMenu();
                    theaterMenu();
                    break;
                case 3:
                    mainMenu();
                    break;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            theaterMenu();
        }
    }

    public void movieMenu(){
        try {
            System.out.println("\n======================MOVIE MENU======================\n");
            showAllMovies();
            System.out.println("Input salah satu angka di menu:");
            System.out.println("1. Lihat detail jadwal Movie");
            System.out.println("2. Tambah schedule");
            System.out.println("3. Back to Main Menu");

            switch (InputUtility.inputInteger("", 1, 3)) {
                case 1:
                    showMovieSchedulesMenu();
                    movieMenu();;
                    break;
                case 2:
                    addScheduleMenu();
                    movieMenu();
                    break;
                case 3:
                    mainMenu();
                    break;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            movieMenu();
        }
    }

    public void showAllTheaters(){
        for(Theater theater: cinema.getTheaters().values()){
           showTheaterInformation(theater);
        }
    }

    public void showAllMovies(){
        for(Movie movie: cinema.getMovies().values()){
            showMovieInformation(movie);
        }
    }

    public void showAllSchedules(){
        for(Schedule schedule: cinema.getSchedules()){
            //showScheduleInformation(schedule);
            schedule.printScheduleInformation();
        }
    }

    public void showTheaterSchedulesMenu(){
        System.out.println("\n======================THEATER SCHEDULE MENU======================\n");
        Theater theater= getTheaterByUserInput();
        if(theater.isSchedulesEmpty()){
            System.out.println("Tidak ditemukan schedule");
        }else{
            System.out.println("\n======================THEATER MENU======================\n");
            showAllSchedulesByTheaters(theater);
        }
    }

    public void     showMovieSchedulesMenu(){
        System.out.println("\n======================MOVIE SCHEDULE MENU======================\n");
        Movie movie = getMovieByUserInput();
        if(movie.isSchedulesEmpty()){
            System.out.println("Tidak ditemukan schedule");
        }else{
            System.out.println("\n======================MOVIE MENU======================\n");
            showAllSchedulesByMovies(movie);
        }
    }

    public void addScheduleMenu(){
        System.out.println("\n======================ADD SCHEDULE MENU======================\n");
        System.out.println("Theaters:");
        showAllTheaters();
        System.out.println("Movies");
        showAllMovies();

        Theater theater = getTheaterByUserInputWithRetry();
        Movie movie = getMovieByUserInputWithRetry();
        Schedule schedule = handleAddScheduleByUserInputWithRetry(movie, theater);

        System.out.println("\n======================SCHEDULE MENU======================\n");
        showAllSchedules();

    }


    public void showTheaterInformation(Theater theater){
        System.out.printf("Name: %s, Address: %s, Class %s, Cost: %s \n",
            theater.getName(),
            theater.getAddress(),
            theater.getStudioClass().getName(),
            formatUtility.toRupiah(theater.getStudioClass().getPrice())
        );
    }

    public void showScheduleInformation(Schedule schedule){
        System.out.printf("Movie: %s, Theater: %s, %s - %s  \n",
                schedule.getMovie().getTitle(),
                schedule.getTheater().getName(),
                formatUtility.toFormattedDate(schedule.getStartTime()),
                formatUtility.toFormattedDate(schedule.getEndTime())
        );
    }

    public void showScheduleInformationWithMovie(Schedule schedule){
        System.out.printf("Movie: %s, %s - %s  \n",
                schedule.getMovie().getTitle(),
                formatUtility.toFormattedDate(schedule.getStartTime()),
                formatUtility.toFormattedDate(schedule.getEndTime())
        );
    }

    public void showScheduleInformationWithTheater(Schedule schedule){
        System.out.printf("Theater: %s, %s - %s  \n",
                schedule.getTheater().getName(),
                formatUtility.toFormattedDate(schedule.getStartTime()),
                formatUtility.toFormattedDate(schedule.getEndTime())
        );
    }

    public void showMovieInformation(Movie movie){
        System.out.printf("Title : %s, Genre: %s, Duration: %d minutes \n",
                    movie.getTitle(),
                    movie.getGenre().getName(),
                    movie.getDuration()
                );
    }

    public void showAllSchedulesByTheaters(Theater theater){
        for (Schedule schedule: theater.getSchedules()){
            showScheduleInformationWithMovie(schedule);
        }
    }


    public void showAllSchedulesByMovies(Movie movie){
        for (Schedule schedule: movie.getSchedules()){
            showScheduleInformationWithTheater(schedule);
        }
    }

    public Theater getTheaterByUserInput(){
        String theaterName = formatUtility.sanitizeKeyInput(InputUtility.input("Masukkan nama theater:\n"));

        Theater theater = cinema.getTheaterByName(theaterName);
        if (theater == null) {
            throw new NullPointerException("Theater tidak ditemukan.");
        }
        return theater;
    }

    public Movie getMovieByUserInput(){
        String movieTitle = formatUtility.sanitizeKeyInput(InputUtility.input("Masukkan judul movie:\n"));
        Movie movie = cinema.getMovieByTitle(movieTitle);
        if (movie == null) {
            throw new NullPointerException("Movie tidak ditemukan.");
        }
        return movie;
    }

    public Schedule createScheduleByDateTimeFromUserInput(Movie movie, Theater theater ){
        LocalDateTime localDateTime = InputUtility.inputDateTime("Masukkan hari dan jam mulai (dd/MM/yy HH:mm):\n");
        //May using validation here to make sure no overlapped schedule
        return new Schedule(theater, movie, localDateTime);
    }

    public boolean addNewScheduleToCinema(Schedule schedule){
        if(schedule.theater.isScheduleAvailable(schedule.getStartTime(), schedule.getEndTime())){
            cinema.appendSchedule(schedule);
            schedule.getTheater().appendSchedule(schedule);
            schedule.getMovie().appendSchedule(schedule);
            return true;
        }
        return false;
    }

    public Theater getTheaterByUserInputWithRetry(){
        while (true){
            try{
                return getTheaterByUserInput();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Movie getMovieByUserInputWithRetry(){
        while (true){
            try{
                return getMovieByUserInput();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Schedule handleAddScheduleByUserInputWithRetry(Movie movie, Theater theater){
        while (true){
            try{
                Schedule schedule = createScheduleByDateTimeFromUserInput(movie, theater);
                if (addNewScheduleToCinema(schedule)){
                    return schedule;
                }else{
                    throw new RuntimeException("Jadwal tidak tersedia");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


}
