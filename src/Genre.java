public enum Genre {
    DRAMA("Drama"),
    HORROR("Horror"),
    COMEDY("Comedy"),
    SCIFI("Science Fiction"),
    ACTION("Action");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
