package data;

public class Motorbike extends Vehicle {

//    public final String id;
//    public String name;
//    public String color;
//    public double price;
//    public String brand;
    public double speed;
    public boolean license;

    public Motorbike(String id, String name, String color, double price, String brand, double speed, boolean license) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
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

//    @Override
//    public String toString() {
//        return String.format("|%-10s|%-20s|%-6s|%-18.2f|%-12s|%-7.2f|%4b|\n",
//                id, name, color, price, brand, speed, license);
//    }
    @Override
    public String toString() {
        return String.format("%-20s|%-20s|%-8s|%-20.2f|%-10s|%-8s|%-4s|%-10.2f|%-7s|%-12s|",
                id, name, color, price, brand, "-", "-", speed, changeLicense(license), makeSound());
    }

    public String changeLicense(boolean b) {
        return b ? "YES" : "NO";
    }

    public String makeSound() {
        return "Tin Tin Tin";
    }
}
