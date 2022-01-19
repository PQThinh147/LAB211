package runtime;

import data.Menu;
import data.VehicleList;

public class Program {

    public static void main(String[] args) {
        VehicleList v = new VehicleList();
//        v.init();
//        v.showInfo();
////        v.updateVehicle();//ngon
////        v.removeVehicle();//ngon
//        System.out.println("==========");
//        v.showAll();
//                System.out.println("==========");
//
//        v.showInfo();

//        v.addNewVehicle();
        int choice;
        do {
            Menu.showMenu();
            choice = Menu.inputChoice();
            switch (choice) {
                case 1:
                    v.addNewVehicle();
                    break;
                case 2:
                    v.updateVehicle();
                    break;
                case 3:
                    v.removeVehicle();
                    break;
                case 4:
                    v.searchVehicle();
                    break;
                case 5:
                    v.showAll();
                    break;
                case 6:
                    v.storeDataToFile();
                    break;
            }
        } while (choice != 7);
    }
}
