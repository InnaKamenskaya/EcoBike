package org.example.ui;

import org.apache.log4j.Logger;
import org.example.App;
import org.example.model.entities.VehicleType;
import org.example.model.services.VehicleService;
import org.example.util.Menu;
import org.example.util.Utils;

import java.io.IOException;

public class ConsoleUI {

    private static final Logger LOGGER = Logger.getLogger(ConsoleUI.class);
    String path;

    public ConsoleUI(String path) {
        this.path = path;
    }

    public void start(VehicleService vehicleService, App app){

        try {
            Menu menu = new Menu("Please, enter number of your choice:\n" +
                    "1 - Show the entire EcoBike catalog\n" +
                    "2 – Add a new folding bike\n" +
                    "3 – Add a new speedelec\n" +
                    "4 – Add a new e-bike\n" +
                    "5 – Find the first item of a particular brand\n" +
                    "6 – Write to file\n" +
                    "7 – Stop the program ");
            int choice = 0;
            do{
                choice = menu.run();
                switch (choice){
                    case 1:{
                        vehicleService.showAll(path).stream().forEach(System.out::println);
                    }
                    break;
                    case 2:{
                        vehicleService.createBike(VehicleType.FOLDING_BIKE);
                    }
                    break;
                    case 3:{
                        vehicleService.createBike(VehicleType.SPEEDELEC);
                    }
                    break;
                    case 4:{
                        vehicleService.createBike(VehicleType.E_BIKE);
                    }
                    break;
                    case 5:{
                        vehicleService.getSearchResult(path);
                    }
                    break;
                    case 6:{
                        vehicleService.writeToFile(path);
                    }
                    break;
                    case 7:{
                        app.stopProgram();
                    }
                    break;
                    default:
                        System.out.println(Utils.ANSI_RED + "Please enter number of your choice" + Utils.ANSI_RESET);
                        break;
                }
            }while (0 < choice);
        }catch (IOException e){
            LOGGER.error( e.getMessage());
        }catch (NumberFormatException e){
            System.out.println(Utils.ANSI_RED + "Select the number in the menu below" + Utils.ANSI_RESET);
            start(vehicleService, app);
        }
    }
}
