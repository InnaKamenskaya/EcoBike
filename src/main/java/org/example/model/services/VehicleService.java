package org.example.model.services;

import org.example.model.dao.ElectroVehicleDAO;
import org.example.model.dao.FoldingBikeDAO;
import org.example.model.dao.impl.FileDAOFactory;
import org.example.model.entities.*;
import org.example.model.entities.impl.*;
import org.example.util.Menu;
import org.example.util.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Accepts user console input data, and pass its to DAO.
 *
 * @author Inna Kamenskaya.
 */
public class VehicleService {

    private List<AbstractVehicle> vehicles;
    private List<String> stringBikes;

    public VehicleService() {
        vehicles = new ArrayList<>();
        stringBikes = new ArrayList<>();
    }

    public List<String> getStringBikes() {
        return stringBikes;
    }

    /**
     * Takes path to the file, and return all vehicles from the file.
     *
     * @param path path to the file.
     * @return list of all the vehicles.
     */
    public List<AbstractVehicle> showAll(String path) {
        return FileDAOFactory.getInstance().getVehicleDAO().findAll(path);
    }

    /**
     * Creates a new object by choosing a class depending on the input parameters.
     *
     * @param type type of bike.
     * @return new bike object.
     */
    public AbstractVehicle createBike(VehicleType type) {
        if (type == VehicleType.FOLDING_BIKE) {
            String bike = FileDAOFactory.getInstance().getFoldingBikeDAO().create();
            stringBikes.add(bike);
            return VehicleFactory.getVehicle(VehicleType.FOLDING_BIKE, bike);
        } else if (type == VehicleType.E_BIKE) {
            String bike = FileDAOFactory.getInstance().getEBikeDAO().create();
            stringBikes.add(bike);
            return VehicleFactory.getVehicle(VehicleType.E_BIKE, bike);
        } else {
            String bike = FileDAOFactory.getInstance().getSpeedelecDAO().create();
            stringBikes.add(bike);
            return VehicleFactory.getVehicle(VehicleType.SPEEDELEC, bike);
        }
    }

    /**
     * Write new data to file and clear string of the added bikes.
     *
     * @param path path to the file.
     * @return boolean confirmation that the file was successfully written.
     */
    public boolean writeToFile(String path) {
        boolean res = false;
        if (FileDAOFactory.getInstance().getVehicleDAO().insert(stringBikes, path)) {
            System.out.println("All the data was successfully written to " + path);
            res = true;
            stringBikes.clear();
        }
        return res;
    }

    /**
     * Creating in the console a menu for selecting the type of objects for searching.
     *
     * @param path path to the source file for searching.
     * @throws IOException
     */
    public void getSearchResult(String path) throws IOException {
        Menu menu = new Menu("Please, select digit to specify type of vehicle you want:\n" +
                "1 - Folding bike\n" +
                "2 – E-bike\n" +
                "3 – Speedelec\n" +
                "If you want to return to the previous menu, enter 0");
        int choice = 0;

        do {
            choice = menu.run();
            switch (choice) {
                case 0: {

                }
                break;
                case 1: {
                    getFoldingBikeForSearch(path);

                }
                break;
                case 2: {
                    getElectroBikeFoSearch(2, path);
                }
                break;
                case 3: {
                    getElectroBikeFoSearch(3, path);
                }
                break;
                default:
                    System.out.println("Please enter number of your choice");
                    break;
            }
        } while (0 < choice);
    }

    /**
     * Creating in the console a menu for selecting the parameters of folding bike for searching.
     * Validates the input values.
     *
     * @param path path to the source file for searching.
     * @throws IOException
     */
    private void getFoldingBikeForSearch(String path) throws IOException {

        FoldingBike bike = new FoldingBike();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu("Please, specify digit of additional search parameter or select search:\n" +
                "1 - brand name - " + Utils.ANSI_RED + "required" + Utils.ANSI_RESET + "\n" +
                "2 - The size of the wheels (in inch) \n" +
                "3 – The number of gears \n" +
                "4 – The weight of the bike (in grams) \n" +
                "5 - The availability of lights at front and back (TRUE/FALSE) \n" +
                "6 - A color \n" +
                "7 - The price \n" +
                "8 - Search \n" +
                "If you want to return to the previous menu, enter 0");
        int choice = 0;

        do {
            choice = menu.run();
            switch (choice) {
                case 0: {
                    //do nothing
                }
                break;
                case 1: {
                    System.out.println("Enter brand name:");
                    String value = reader.readLine();
                    if (Utils.checkInputStringValue(value)) {
                        bike.setBrand(value);
                    }
                }
                break;
                case 2: {
                    System.out.println("Enter size of wheels:");
                    String value = reader.readLine();
                    if (Utils.checkInputIntegerValue(value)) {
                        bike.setWheelSize(Integer.parseInt(value));
                    }
                }
                break;
                case 3: {
                    System.out.println("Enter number of gears:");
                    String value = reader.readLine();
                    if (Utils.checkInputIntegerValue(value)) {
                        bike.setGearsNumber(Integer.parseInt(value));
                    }
                }
                break;
                case 4: {
                    System.out.println("Enter weight of folding bike:");
                    String value = reader.readLine();
                    if (Utils.checkInputIntegerValue(value)) {
                        bike.setWeight(Integer.parseInt(value));
                    }
                }
                break;
                case 5: {
                    System.out.println("Enter the availability of lights at front and back (TRUE/FALSE):");
                    String value = reader.readLine();
                    if (Utils.checkInputBooleanValue(value)) {
                        bike.setHasLights(Boolean.parseBoolean(value));
                    }
                }
                break;
                case 6: {
                    System.out.println("Enter a color:");
                    String value = reader.readLine();
                    if (Utils.checkInputStringValue(value)) {
                        bike.setColor(value);
                    }
                }
                break;
                case 7: {
                    System.out.println("Enter the price:");
                    String value = reader.readLine();
                    if (Utils.checkInputStringValue(value)) {
                        bike.setPrice(new BigDecimal(value));
                    }
                }
                break;
                case 8: {
                    searchFoldingBike(bike, path).stream().forEach(System.out::println);
                    choice = 0;
                }
                break;
                default:
                    System.out.println("Please enter number of your choice");
                    break;
            }
        } while (0 < choice);
    }

    /**
     * Creating in the console a menu for selecting the parameters of Electro bike for searching.
     * Validates the input values.
     *
     * @param switchChoice switch type of creating object between EBike and Speedelec.
     * @param path         path to the source file for searching.
     * @throws IOException
     */
    private void getElectroBikeFoSearch(int switchChoice, String path) throws IOException {
        ElectroVehicle bike;
        if (switchChoice == 2) {
            bike = new EBike();
        } else {
            bike = new Speedelec();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu("Please, specify digit of additional search parameter or select search:\n" +
                "1 - brand name - " + Utils.ANSI_RED + "required" + Utils.ANSI_RESET + "\n" +
                "2 - The maximum speed (in km/h) \n" +
                "3 – The weight of the bike (in grams) \n" +
                "4 - The availability of lights at front and back (TRUE/FALSE) \n" +
                "5 – The battery capacity (in mAh)  \n" +
                "6 - A color \n" +
                "7 - The price \n" +
                "8 - Search \n" +
                "If you want to return to the previous menu, enter 0");
        int choice = 0;

        do {
            choice = menu.run();
            switch (choice) {
                case 0: {
                    //do nothing
                }
                break;
                case 1: {
                    System.out.println("Enter brand name:");
                    String value = reader.readLine();
                    if (Utils.checkInputStringValue(value)) {
                        bike.setBrand(value);
                    }
                }
                break;
                case 2: {
                    System.out.println("Enter max speed:");
                    String value = reader.readLine();
                    if (Utils.checkInputIntegerValue(value)) {
                        bike.setMaxSpeed(Integer.parseInt(value));
                    }
                }
                break;
                case 3: {
                    System.out.println("Enter weight of bike:");
                    String value = reader.readLine();
                    if (Utils.checkInputIntegerValue(value)) {
                        bike.setWeight(Integer.parseInt(value));
                    }
                }
                break;
                case 4: {
                    System.out.println("Enter the availability of lights at front and back (TRUE/FALSE):");
                    String value = reader.readLine();
                    if (Utils.checkInputBooleanValue(value)) {
                        bike.setHasLights(Boolean.parseBoolean(value));
                    }
                }
                break;
                case 5: {
                    System.out.println("Enter battery capacity:");
                    String value = reader.readLine();
                    if (Utils.checkInputIntegerValue(value)) {
                        bike.setBatteryCapacity(Integer.parseInt(value));
                    }
                }
                break;
                case 6: {
                    System.out.println("Enter color:");
                    String value = reader.readLine();
                    if (Utils.checkInputStringValue(value)) {
                        bike.setColor(value);
                    }
                }
                break;
                case 7: {
                    System.out.println("Enter price:");
                    String value = reader.readLine();
                    if (Utils.checkInputStringValue(value)) {
                        bike.setPrice(new BigDecimal(value));
                    }
                }
                break;
                case 8: {
                    searchElectroVehicle(bike, path).stream().forEach(System.out::println);
                    choice = 0;
                }
                break;
                default:
                    System.out.println("Please enter number of your choice");
                    break;
            }
        } while (0 < choice);
    }

    /**
     * Searching folding bike for the input parameters.
     *
     * @param source object FoldingBike to be searched for.
     * @param path   path to the source file for searching.
     * @return Result of the search.
     */
    private List<FoldingBike> searchFoldingBike(FoldingBike source, String path) {
        FoldingBikeDAO dao = FileDAOFactory.getInstance().getFoldingBikeDAO();
        List<FoldingBike> dest = new ArrayList<>();
        List<FoldingBike> bikes = dao.findAllFoldingBikes(path);
        if (source.isContainsAllParams()) {
            Collections.sort(bikes);
            dest.add(bikes.get(Collections.binarySearch(bikes, source)));
            return dest;
        } else {
            if (source.getBrand() != null) {
                dest = dao.findByBrand(bikes, source.getBrand());
            }
            if (source.getWheelSize() != 0) {
                dest = dao.findByWheelSize(dest, source.getWheelSize());
            }
            if (source.getGearsNumber() != 0) {
                dest = dao.findByGearsNumber(dest, source.getGearsNumber());
            }
            if (source.getWeight() != 0) {
                dest = dao.findByWeight(dest, source.getWeight());
            }
            if (source.isHasLights() != null) {
                dest = dao.findByLights(dest, source.isHasLights());
            }
            if (source.getColor() != null) {
                dest = dao.findByColor(dest, source.getColor());
            }
            if (source.getPrice() != null) {
                dest = dao.findByPrice(dest, source.getPrice());
            }
        }
        return dest;
    }

    /**
     * Searching ElectroVehicle for the input parameters.
     *
     * @param source object ElectroVehicle to be searched for.
     * @param path   path to the source file for searching.
     * @return result of the search.
     */
    private List<ElectroVehicle> searchElectroVehicle(ElectroVehicle source, String path) {
        ElectroVehicleDAO dao = FileDAOFactory.getInstance().getElectroVehicleDAO();
        List<ElectroVehicle> dest = new ArrayList<>();
        List<ElectroVehicle> bikes;
        if (source instanceof EBike) {
            bikes = new ArrayList<>(FileDAOFactory.getInstance().getEBikeDAO().findAllEBike(path));
        } else {
            bikes = new ArrayList<>(FileDAOFactory.getInstance().getSpeedelecDAO().findAllSpeedelecs(path));
        }
        if (source.isContainsAllParams()) {
            Collections.sort(bikes);
            dest.add(bikes.get(Collections.binarySearch(bikes, source)));
            return dest;
        } else {
            if (source.getBrand() != null) {
                dest = dao.findByBrand(bikes, source.getBrand());
            }
            if (source.getMaxSpeed() != 0) {
                dest = dao.findByMaxSpeed(dest, source.getMaxSpeed());
            }
            if (source.getWeight() != 0) {
                dest = dao.findByWeight(dest, source.getWeight());
            }
            if (source.isHasLights() != null) {
                dest = dao.findByLights(dest, source.isHasLights());
            }
            if (source.getBatteryCapacity() != 0) {
                dest = dao.findByBatteryCapacity(dest, source.getBatteryCapacity());
            }
            if (source.getColor() != null) {
                dest = dao.findByColor(dest, source.getColor());
            }
            if (source.getPrice() != null) {
                dest = dao.findByPrice(dest, source.getPrice());
            }
        }
        return dest;
    }
}
