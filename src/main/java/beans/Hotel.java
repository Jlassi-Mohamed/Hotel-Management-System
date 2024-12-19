package beans;

public class Hotel {
    private int id;
    private String name;
    private String city;
    private int stars;
    private String description;
    private String image;
    private static int ind = 0;
    public Hotel() {
    }

    public Hotel(String name, String city, int stars, String description, String image) {
        this.id = ++ind;
        this.name = name;
        this.city = city;
        this.stars = stars;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}