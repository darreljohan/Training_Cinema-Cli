public enum StudioClass {
    IMAX("Imax", 60000),
    PREMIERE("Premiere", 100_000),
    REGULAR("Regular", 40_000 ),
    ;

    private String name;
    private double price;

    StudioClass(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
