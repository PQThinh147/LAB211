package data;

import util.Tools;

public class Menu {

    public static int inputChoice() {
//        int choice = Tools.getAnInteger("Input yout choice", "Value invalid!!!", 1, 8);
        return Tools.getAnInteger("Input yout choice: ", "Value invalid!!!", 1, 7);
    }

    public static void showMenu() {
        System.out.println("-----------------------");
//        System.out.println("1. Load data from file");
        System.out.println("1. Add new vehicle");
        System.out.println("2. Update vehicle by ID");
        System.out.println("3. Delete vehicle ID");
        System.out.println("4. Search vehicle");
        System.out.println("5. Show vehicle list");
        System.out.println("6. Store data to file");
        System.out.println("7. Quit");
        System.out.println("-----------------------");
    }

    public static void showSubmenuOfSearch() {
        System.out.println("------------------------------");
        System.out.println("1 Search by name(descending)");
        System.out.println("2 Search by id");
        System.out.println("------------------------------");
    }

    public static void showSubmenuOfPrint() {
        System.out.println("----------------------------------");
        System.out.println("1 Show all");
        System.out.println("2 Show all (descending by price)");
        System.out.println("----------------------------------");
    }
}
