package data;

public class Car extends Vehicle {

//    public final String id;
//    public String name;
//    public String color;
//    public double price;
//    public String brand;
    public String type;
    public int yom; //    year of manufacture
//    id , name, color, price, brand, type (sport , travel, etc.)
//    , year of manufacture.

    public Car(String id, String name, String color, double price, String brand, String type, int yom) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yom = yom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYom() {
        return yom;
    }

    public void setYom(int yom) {
        this.yom = yom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("%-20s|%-20s|%-8s|%-20.2f|%-10s|%-8s|%-4d|%-10s|%-7s|%-12s|", id, name, color, price, brand, type, yom, "-", "-", "-");
    }

}
