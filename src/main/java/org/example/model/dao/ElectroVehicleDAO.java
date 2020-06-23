package org.example.model.dao;

import org.example.model.entities.ElectroVehicle;

import java.math.BigDecimal;
import java.util.List;

/**
 * Data Access object for electro bikes.
 *
 * @author Inna Kamenskaya.
 */
public interface ElectroVehicleDAO {

    /**
     * Finds list of ElectroVehicles by its brand name.
     *
     * @param source the list to be searched.
     * @param brand  brand name.
     * @return list ElectroVehicles.
     */
    List<ElectroVehicle> findByBrand(List<ElectroVehicle> source, String brand);

    /**
     * Finds list of ElectroVehicles by its weight.
     *
     * @param source the list to be searched.
     * @param weight weight to be searched for.
     * @return list ElectroVehicles.
     */
    List<ElectroVehicle> findByWeight(List<ElectroVehicle> source, int weight);

    /**
     * Finds list of ElectroVehicles by availability of lights at front and back.
     *
     * @param source   the list to be searched.
     * @param isLights does ElectroVehicle has lights.
     * @return list ElectroVehicles.
     */
    List<ElectroVehicle> findByLights(List<ElectroVehicle> source, boolean isLights);

    /**
     * Finds list of ElectroVehicles by color.
     *
     * @param source the list to be searched.
     * @param color  color to be searched for.
     * @return list ElectroVehicles.
     */
    List<ElectroVehicle> findByColor(List<ElectroVehicle> source, String color);

    /**
     * Finds list of ElectroVehicles by price.
     *
     * @param source the list to be searched.
     * @param price  price to be searched for.
     * @return list ElectroVehicles.
     */
    List<ElectroVehicle> findByPrice(List<ElectroVehicle> source, BigDecimal price);

    /**
     * Finds list of ElectroVehicles by battery capacity.
     *
     * @param source   the list to be searched.
     * @param capacity battery capacity to be searched for.
     * @return list ElectroVehicles.
     */
    List<ElectroVehicle> findByBatteryCapacity(List<ElectroVehicle> source, int capacity);

    /**
     * Finds list of ElectroVehicles by max speed.
     *
     * @param source   the list to be searched.
     * @param maxSpeed max speed to be searched for.
     * @return list ElectroVehicles.
     */
    List<ElectroVehicle> findByMaxSpeed(List<ElectroVehicle> source, int maxSpeed);
}
