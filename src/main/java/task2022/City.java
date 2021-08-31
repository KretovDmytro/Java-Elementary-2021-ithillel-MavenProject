package task2022;

public class City {

    private final String id;
    private final String name;

    public City(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}