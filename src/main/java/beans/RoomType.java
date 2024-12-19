package beans;

public class RoomType {
    private int id;          
    private String label; 
    private int capacity; 
    private int price;         
    private static int ind = 0;
    public RoomType() {
    }

    public RoomType(String label, int capacity, int price) {
        this.id = ++ind;
        this.label = label;
        this.capacity = capacity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
