package org.example.model.dao.impl;
import org.example.model.dao.ElectroVehicleDAO;
import org.example.model.entities.ElectroVehicle;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ElectroVehicleDAOImpl  implements ElectroVehicleDAO {

    private static ElectroVehicleDAOImpl electroVehicleDAO = new ElectroVehicleDAOImpl();

    private ElectroVehicleDAOImpl(){}

    static ElectroVehicleDAOImpl getInstance(){
        return electroVehicleDAO;
    }

    @Override
    public List<ElectroVehicle> findByBrand(List<ElectroVehicle> source, String brand) {
        return source.stream().filter(s -> s.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<ElectroVehicle> findByWeight(List<ElectroVehicle> source, int weight) {
        return source.stream().filter(s -> s.getWeight()==weight).collect(Collectors.toList());
    }

    @Override
    public List<ElectroVehicle> findByLights(List<ElectroVehicle> source, boolean isLights) {
        return source.stream().filter(s -> s.isHasLights()==isLights).collect(Collectors.toList());
    }

    @Override
    public List<ElectroVehicle> findByColor(List<ElectroVehicle> source, String color) {
        return source.stream().filter(s -> s.getBrand().equals(color)).collect(Collectors.toList());
    }

    @Override
    public List<ElectroVehicle> findByPrice(List<ElectroVehicle> source, BigDecimal price) {
        return source.stream().filter(s -> s.getPrice().equals(price)).collect(Collectors.toList());
    }

    @Override
    public List<ElectroVehicle> findByBatteryCapacity(List<ElectroVehicle> source, int batteryCapacity) {
        return source.stream().filter(s -> s.getBatteryCapacity()==batteryCapacity).collect(Collectors.toList());
    }

    @Override
    public List<ElectroVehicle> findByMaxSpeed(List<ElectroVehicle> source, int maxSpeed) {
        return source.stream().filter(s -> s.getMaxSpeed() == maxSpeed).collect(Collectors.toList());
    }
}
