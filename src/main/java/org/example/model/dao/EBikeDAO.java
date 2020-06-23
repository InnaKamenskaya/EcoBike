package org.example.model.dao;

import org.example.model.entities.impl.EBike;
import java.util.List;

/**
 * Data Access object for e-bikes.
 *
 * @author Inna Kamenskaya.
 */
public interface EBikeDAO {

    /**
     * Finds all e-bikes in the file.
     * @param source  path to the file.
     * @return list of EBikes.
     */
    List<EBike> findAllEBike(String source);

    /**
     * Creates String which contains all the necessary fields that compose new e-bike.
     * @return String which contains all the necessary fields that compose new e-bike.
     */
    String create();
}
