package org.example.model.dao.impl;

import org.apache.log4j.Logger;
import org.example.model.dao.VehicleDAO;
import org.example.model.entities.AbstractVehicle;
import org.example.model.entities.VehicleFactory;
import org.example.model.entities.VehicleType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {


    private static final Logger LOGGER = Logger.getLogger(VehicleDAOImpl.class);
    private static VehicleDAOImpl vehicleDAO = new VehicleDAOImpl();

    private VehicleDAOImpl(){}

    static VehicleDAOImpl getInstance(){
        return vehicleDAO;
    }

    @Override
    public List<AbstractVehicle> findAll(String source) {
        List<String> list = FileDataSource.readFile(source);
        List<AbstractVehicle> vehicles = new ArrayList<>();
        for (String str : list){
            if (str.contains("FOLDING BIKE")){
                vehicles.add(VehicleFactory.getVehicle(VehicleType.FOLDING_BIKE, str));
            }else if (str.contains("E-BIKE")){
                vehicles.add(VehicleFactory.getVehicle(VehicleType.E_BIKE, str));
            }else {
                vehicles.add(VehicleFactory.getVehicle(VehicleType.SPEEDELEC, str));
            }
        }
        return vehicles;
    }

    @Override
    public boolean insert(List<String> source, String path) {
        try {
            for(String s : source){
                Files.write(Paths.get(path), "\n".getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(path), s.getBytes(), StandardOpenOption.APPEND);
            }
            return true;
        }catch (IOException e){
            LOGGER.error( "Can't write to file: " + e.getMessage());
            return false;
        }
    }
}
