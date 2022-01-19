package fileControl;

import data.Car;
import data.Motorbike;
import data.Vehicle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileControl {

    public static void outputFileVehicles(ArrayList<Vehicle> vehicleList) {
        try {
            FileOutputStream fos = new FileOutputStream("src\\data\\vehicles.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(vehicleList);

            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("Save file vehicles.dat fail!!!");
        }
        System.out.println("File saved successfully !!!");
    }

    public static void outputFileVehicles() {
        try {
            FileOutputStream fos = new FileOutputStream("src\\data\\vehicles.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            ArrayList<Vehicle> vehicleList = new ArrayList<>();
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
            oos.writeObject(vehicleList);

            fos.close();
            oos.close();
        } catch (IOException e) {
            System.err.println("Save file vehicles.dat fail!!!");
        }
        System.out.println("File saved successfully!!!");
    }

    public static ArrayList<Vehicle> inputFileVehicles() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src\\data\\vehicles.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            vehicleList = (ArrayList<Vehicle>) ois.readObject();

            ois.close();
            fis.close();
        } catch (Exception e) {
            System.err.println("Read vehicles.dat file fail!!!");
        }
        return vehicleList;
    }
}
