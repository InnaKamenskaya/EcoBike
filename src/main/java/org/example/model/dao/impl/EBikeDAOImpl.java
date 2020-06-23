package org.example.model.dao.impl;

import org.apache.log4j.Logger;
import org.example.model.dao.EBikeDAO;
import org.example.model.entities.AbstractVehicle;
import org.example.model.entities.impl.EBike;
import org.example.util.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class EBikeDAOImpl implements EBikeDAO {

    private static final Logger LOGGER = Logger.getLogger(EBikeDAOImpl.class);
    private static EBikeDAOImpl eBikeDAO = new EBikeDAOImpl();

    private EBikeDAOImpl(){}

    static EBikeDAOImpl getInstance(){
        return eBikeDAO;
    }

    @Override
    public List<EBike> findAllEBike(String source) {
        List<AbstractVehicle> vehicles = VehicleDAOImpl.getInstance().findAll(source);
        ArrayList<EBike> dest = new ArrayList<>();
        for (AbstractVehicle vehicle : vehicles){
            if (vehicle instanceof EBike){
                dest.add((EBike) vehicle);
            }
        }
        return dest;
    }

    @Override
    public String create(){
        StringBuilder builder = new StringBuilder("E-BIKE ");
        System.out.println("Please, enter brand name");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String value = reader.readLine();
            while (!Utils.checkInputStringValue(value)){
                System.out.println("Try again ...");
                value = reader.readLine();
            }
            builder.append(value + "; ");
            System.out.println("Please, enter the maximum speed (in km/h)  ");
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
            System.out.println("Please, enter the battery capacity (in mAh)");
            value = reader.readLine();
            while (!Utils.checkInputIntegerValue(value)){
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
            LOGGER.error("Could not create new e-bike: " + e.getMessage());
            return null;
        }
    }
}
