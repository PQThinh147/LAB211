package data;

import fileControl.FileControl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.Tools;

public class VehicleList {

    public ArrayList<Vehicle> vehicleList = FileControl.inputFileVehicles();

    public void addNewVehicle() {
        int choice;
        do {
            int localChoice = Tools.getAnInteger("Select the type of vehicle you want to add:\n"
                    + "1. Car\t\t\t2. Motorbike\nInput your choice: ", "Value invalid!!!", 1, 2);
            if (localChoice == 1) {
                String id = inputId();
                String name = Tools.getString("Input vehicle name: ", "Value invalid!!!").toUpperCase();
                String color = Tools.getString("Input vehicle color: ", "Value invalid!!!").toUpperCase();
                double price = Tools.getADouble("Input vehicle price: ", "Value invalid!!!", 0, Double.MAX_VALUE);
                String brand = Tools.getString("Input vehicle brand: ", "Value invalid!!!").toUpperCase();
                String type = Tools.getString("Input vehicle type: ", "Value invalid!!!").toUpperCase();
                int yom = Tools.getAnInteger("Input year of manufacture: ", "Value invalid!!!", 0, inputYearOfManufacture());

                vehicleList.add(new Car(id, name, color, price, brand, type, yom));
            } else {
                String id = inputId();
                String name = Tools.getString("Input vehicle name: ", "Value invalid!!!").toUpperCase();
                String color = Tools.getString("Input vehicle color: ", "Value invalid!!!").toUpperCase();
                double price = Tools.getADouble("Input vehicle price: ", "Value invalid!!!", 0, Double.MAX_VALUE);
                String brand = Tools.getString("Input vehicle brand: ", "Value invalid!!!").toUpperCase();
                double speed = Tools.getADouble("Input vehicle price: ", "Value invalid!!!", 0, Double.MAX_VALUE);
                boolean license = Tools.getBooleanData("Input vehicle license: \n1. YES\t\t\t2. NO\nInput your choice: ",
                        "Value invalid!!!");
                vehicleList.add(new Motorbike(id, name, color, price, brand, speed, license));
            }
            choice = Tools.getAnInteger("Do you want to continue adding vehicle?"
                    + "\n1. YES\t\t\t2. NO\nInput your choice: ", "Value invalid!!!", 1, 2);
        } while (choice == 1);
    }



    public String inputId() {
        String id;
        do {
            id = Tools.getString("Input vehicle ID: ", "Value invalid!!!").toUpperCase();
            if (!checkId(id)) {
                return id;
            }
        } while (true);
    }

    public boolean checkId(String id) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public int inputYearOfManufacture() {
        LocalDate localDate = LocalDate.now();
        return localDate.getYear();
    }

    public String updateID(String vehicleId) {
        String id;
        do {
            id = Tools.getStringOfNull("Input vehicle ID: ", vehicleId).toUpperCase();
            if (id.equalsIgnoreCase(vehicleId)) {
                return id;
            } else if (!id.equalsIgnoreCase(vehicleId) && !checkId(id)) {
                return id;
            }
            System.err.println("This ID already exists!!!");
        } while (true);
    }

    public void updateVehicle() {
        int pos = searchById();
        if (pos == -1) {
            System.err.println("Vehicle does not exist!!!");
        } else {
            if (vehicleList.get(pos).getClassName().equalsIgnoreCase("Car")) {
                Car c = (Car) vehicleList.get(pos);
                c.setId(updateID(c.getId()));
                c.setName(Tools.getStringOfNull("Input vehicle name: ", c.getName()).toUpperCase());
                c.setColor(Tools.getStringOfNull("Input vehicle color: ", c.getColor()).toUpperCase());
                c.setPrice(Tools.getDoubleOfNull("Input vehicle price: ", "Value invalid!!!", 0, Double.MAX_VALUE, c.getPrice()));
                c.setBrand(Tools.getStringOfNull("Input vehicle brand: ", c.getBrand()).toUpperCase());
                c.setType(Tools.getStringOfNull("Input vehicle type: ", c.getType()).toUpperCase());
                c.setYom(Tools.getIntegerOfNull("Input year of manufacture: ", "Value invalid!!!", 0, inputYearOfManufacture(), c.getYom()));
                showInfo();
            } else {
                Motorbike m = (Motorbike) vehicleList.get(pos);
                m.setId(updateID(m.getId()));
                m.setName(Tools.getStringOfNull("Input vehicle name: ", m.getName()).toUpperCase());
                m.setColor(Tools.getStringOfNull("Input vehicle color: ", m.getColor()).toUpperCase());
                m.setPrice(Tools.getDoubleOfNull("Input vehicle price: ", "Value invalid!!!", 0, Double.MAX_VALUE, m.getPrice()));
                m.setBrand(Tools.getStringOfNull("Input vehicle color: ", m.getBrand()).toUpperCase());
                m.setSpeed(Tools.getDoubleOfNull("Input vehicle speed: ", "Value invalid!!!", 0, Double.MAX_VALUE, m.getSpeed()));
                m.setLicense(Tools.getBooleanDataOfNull("Input vehicle license: \n1. YES\t\t\t2. NO\nInput your choice: ", "Value invalid!!!", m.isLicense()));
                showInfo();
            }
        }
    }

    public void removeVehicle() {
        int pos = searchById();
        if (pos == -1) {
            System.err.println("Vehicle does not exist!!!");
        } else {
            System.out.println(vehicleList.get(pos).toString());
            int choice = Tools.getAnInteger("Are you sure you want to delete this vehicle?"
                    + "\n1. YES\t\t\t2. NO\nInput your choice: ", "Value invalid!!!", 1, 2);
            if (choice == 1) {
                vehicleList.remove(pos);
                System.out.println("Delete vehicle successfully!!!");
            } else {
                System.err.println("Delete failed vehicle!!!");
            }
        }
    }

    public void searchVehicle() {
        int choice = Tools.getAnInteger("Do you want to search vehicle by name or id?\n"
                + "1. Name\t\t\t2. ID\nInput your choice: ", "Value invalid!!!", 1, 2);
        if (choice == 1) {
            searchByName();
        } else {
            int pos = searchById();
            if (pos == -1) {
                System.err.println("Vehicle does not exist!!!");
            } else {
                System.out.println(vehicleList.get(pos).toString());
            }
        }
    }

    public int searchById() {
        String id = Tools.getString("Input the vehicle id you want to find: ", "Value invalid!!!");
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public void searchByName() {
        String key = ".*" + Tools.getString("Input the vehicle name you want to find: ",
                "Value invalid!!!") + ".*";
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicleList) {
            Vehicle a = v;
            if (a.getName().toLowerCase().matches(key)) {
                result.add(a);
            }
        }
        if (result.isEmpty()) {
            System.err.println("Vehicle does not exist!!!");

        } else {
            Collections.sort(vehicleList, new Comparator<Vehicle>() {
                @Override
                public int compare(Vehicle o1, Vehicle o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
            System.out.println("This is a list of name: " + key + " that you want to search");
            for (Vehicle v : result) {
                System.out.println(v.toString());
            }
        }
    }

    public void showAll() {
        int choice = Tools.getAnInteger("Do you want to show all or by type?\n"
                + "1. Show all\t\t\t2. Show by type\nInput your choice: ", "Value invalid!!!", 1, 2);
        if (choice == 1) {
            showInfo();
        } else {
            int localChoice = Tools.getAnInteger("Do you want to show car or motorbike?\n"
                    + "1. Car\t\t\t2. Motorbike\nInput your choice: ", "Value invalid!!!", 1, 2);
            if (localChoice == 1) {
                ArrayList<Car> c = new ArrayList<>();
                for (Vehicle v : vehicleList) {
                    if (v.getClassName().equalsIgnoreCase("Car")) {
                        c.add((Car) v);
                    }
                }
                Collections.sort(c, new Comparator<Vehicle>() {
                    @Override
                    public int compare(Vehicle o1, Vehicle o2) {
                        return o2.getPrice() > o1.getPrice() ? 1 : -1;
                    }
                });
                if (c.isEmpty()) {
                    System.out.println("Nothing to show!!!");
                }
                for (Car o : c) {
                    System.out.println(o.toString());
                }
            } else {
                ArrayList<Motorbike> m = new ArrayList<>();
                for (Vehicle v : vehicleList) {
                    if (v.getClassName().equalsIgnoreCase("Motorbike")) {
                        m.add((Motorbike) v);
                    }
                }
                Collections.sort(m, new Comparator<Vehicle>() {
                    @Override
                    public int compare(Vehicle o1, Vehicle o2) {
                        return o2.getPrice() > o1.getPrice() ? 1 : -1;
                    }
                });
                if (m.isEmpty()) {
                    System.out.println("Nothing to show!!!");
                }
                for (Motorbike o : m) {
                    System.out.println(o.toString());
                }
            }
        }
    }

    public void showInfo() {
        if (vehicleList.isEmpty()) {
            System.out.println("Nothing to show!!!");
        }
        showTitle();
        for (Vehicle v : vehicleList) {
            System.out.println(v.toString());
        }
    }

    public void showTitle() {
        System.out.printf("%-20s|%-20s|%-8s|%-20s|%-10s|%-8s|%-4s|%-10s|%-7s|%-12s|\n",
                "ID", "NAME", "COLOR", "PRICE", "BRAND", "TYPE", "YOM", "SPEED", "LICENSE", "SOUND");
    }

    public void storeDataToFile() {
        FileControl.outputFileVehicles();
//        FileControl.outputFileVehicles(vehicleList);
    }

    public void init() {
        vehicleList.add(new Car("1", "1", "1", 1, "1", "1", 1));
        vehicleList.add(new Car("7", "7", "7", 7, "7", "7", 7));
        vehicleList.add(new Car("3", "3", "3", 3, "3", "3", 3));
        vehicleList.add(new Car("9", "9", "9", 9, "9", "9", 9));
        vehicleList.add(new Car("5", "5", "5", 5, "5", "5", 5));
        vehicleList.add(new Motorbike("2", "2", "2", 2, "2", 2, true));
        vehicleList.add(new Motorbike("4", "4", "4", 4, "4", 4, false));
        vehicleList.add(new Motorbike("6", "6", "6", 6, "6", 6, true));
        vehicleList.add(new Motorbike("8", "8", "8", 8, "8", 8, false));
        vehicleList.add(new Motorbike("10", "10", "10", 10, "10", 10, true));
    }
}
