package org.example.model.dao.impl;

import org.apache.log4j.Logger;
import org.example.model.dao.FoldingBikeDAO;
import org.example.model.entities.AbstractVehicle;
import org.example.model.entities.impl.FoldingBike;
import org.example.util.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoldingBikeDAOImpl implements FoldingBikeDAO {

    private static final Logger LOGGER = Logger.getLogger(FoldingBikeDAOImpl.class);
    private static FoldingBikeDAOImpl foldingBikeDAO = new FoldingBikeDAOImpl();

    private FoldingBikeDAOImpl(){}

    static FoldingBikeDAOImpl getInstance(){
        return foldingBikeDAO;
    }

    @Override
    public List<FoldingBike> findAllFoldingBikes(String source) {
        List<AbstractVehicle> vehicles = VehicleDAOImpl.getInstance().findAll(source);
        ArrayList<FoldingBike> dest = new ArrayList<>();
        for (AbstractVehicle vehicle : vehicles){
            if (vehicle instanceof FoldingBike){
                dest.add((FoldingBike) vehicle);
            }
        }
        return dest;
    }

    @Override
    public List<FoldingBike> findByBrand(List<FoldingBike> source, String brand) {
        return source.stream().filter(s -> s.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<FoldingBike> findByWeight(List<FoldingBike> source, int weight) {
        return source.stream().filter(s -> s.getWeight()==weight).collect(Collectors.toList());
    }

    @Override
    public List<FoldingBike> findByLights(List<FoldingBike> source, boolean isLights) {
        return source.stream().filter(s -> s.isHasLights()==isLights).collect(Collectors.toList());
    }

    @Override
    public List<FoldingBike> findByColor(List<FoldingBike> source, String color) {
        return source.stream().filter(s -> s.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public List<FoldingBike> findByPrice(List<FoldingBike> source, BigDecimal price) {
        return source.stream().filter(s -> s.getPrice().equals(price)).collect(Collectors.toList());
    }

    @Override
    public List<FoldingBike> findByWheelSize(List<FoldingBike> source, int wheelSize) {
        return source.stream().filter(s -> s.getWheelSize()==wheelSize).collect(Collectors.toList());
    }

    @Override
    public List<FoldingBike> findByGearsNumber(List<FoldingBike> source, int gearsNumber) {
        return source.stream().filter(s -> s.getGearsNumber()==gearsNumber).collect(Collectors.toList());
    }

    @Override
    public String create() {
        StringBuilder builder = new StringBuilder("FOLDING BIKE ");
        System.out.println("Please, enter brand name");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String value = reader.readLine();
            while (!Utils.checkInputStringValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value + "; ");
            System.out.println("Please, enter size of the wheels (in inch) ");
            value = reader.readLine();
            while (!Utils.checkInputIntegerValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value + "; ");
            System.out.println("Please, enter the number of gears");
            value = reader.readLine();
            while (!Utils.checkInputIntegerValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value + "; ");
            System.out.println("Please, enter the weight of the bike (in grams)");
            value = reader.readLine();
            while (!Utils.checkInputIntegerValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value + "; ");
            System.out.println("Please, enter the availability of lights at front and back (TRUE/FALSE) ");
            value = reader.readLine();
            while (!Utils.checkInputBooleanValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value + "; ");
            System.out.println("Please, enter a color");
            value = reader.readLine();
            while (!Utils.checkInputStringValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value + "; ");
            System.out.println("Please, enter the price");
            value = reader.readLine();
            while (!Utils.checkInputBigIntegerValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value);
            return builder.toString();
        }catch (IOException e){
            LOGGER.error("Could not create new folding bike: " + e.getMessage());
            return null;
        }
    }
}
