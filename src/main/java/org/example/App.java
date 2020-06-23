package org.example;

import org.apache.log4j.Logger;
import org.example.model.services.VehicleService;
import org.example.ui.ConsoleUI;
import org.example.util.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class);
    private VehicleService vehicleService;
    private ConsoleUI ui;
    private String path;

    public App() {
        vehicleService = new VehicleService();
    }

    public void run() {
        try {
            System.out.println("Please, enter path");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String temp = reader.readLine();
            while (!Utils.checkInputStringValue(temp)) {
                temp = reader.readLine();
            }

            this.path = temp;
            File file = new File(path);
            if (file.exists()) {
                ConsoleUI ui = new ConsoleUI(path);
                ui.start(vehicleService, this);
            }else {
                System.out.println(Utils.ANSI_RED + "Not valid path to the file, try again" + Utils.ANSI_RESET);
                run();
            }
        }catch (IOException e){
            System.out.println(Utils.ANSI_RED + "Not valid path to the file, try again" + Utils.ANSI_RESET);
            LOGGER.error(e.getMessage());
        }
    }

    public void stopProgram() {
        if (vehicleService.getStringBikes().isEmpty()) {
            System.out.println("Program is closed");
            System.exit(0);
        }else {
            System.out.println(Utils.ANSI_RED + "Application retain unsaved data, please write it to file before exit" + Utils.ANSI_RESET);
            ui = new ConsoleUI(path);
            ui.start(vehicleService, this);
        }
    }
}
