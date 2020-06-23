package org.example.model.dao;

import org.example.model.entities.AbstractVehicle;

import java.util.List;

/**
 * Data Access object for general type of bikes.
 *
 * @author Inna Kamenskaya.
 */

public interface VehicleDAO {
    /**
     * Finds all vehicles despite the type.
     * @return list of all vehicles.
     */
    List<AbstractVehicle> findAll(String source);

    /**
     * Tries to write all created vehicles into the file on the specified path.
     * @param source list of vehicles.
     * @param path path to the file.
     * @return true if recording was successful, false otherwise.
     */
    boolean insert(List<String> source, String path);
}
