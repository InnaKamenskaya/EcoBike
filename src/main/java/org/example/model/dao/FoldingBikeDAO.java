package org.example.model.dao;

import java.math.BigDecimal;
import java.util.List;

import org.example.model.entities.impl.FoldingBike;

/**
 * Data Access object for folding bikes.
 *
 * @author Inna Kamenskaya.
 */
public interface FoldingBikeDAO {

    /**
     * Finds all FoldingBikes in the file.
     *
     * @param source path to the file.
     * @return list FoldingBikes.
     */
    List<FoldingBike> findAllFoldingBikes(String source);

    /**
     * Finds list of FoldingBikes by its brand name.
     *
     * @param source the list to be searched.
     * @param brand  brand name to be searched for.
     * @return list FoldingBikes.
     */
    List<FoldingBike> findByBrand(List<FoldingBike> source, String brand);

    /**
     * Finds list of FoldingBikes by its weight.
     *
     * @param source the list to be searched.
     * @param weight weight to be searched for.
     * @return list FoldingBikes.
     */
    List<FoldingBike> findByWeight(List<FoldingBike> source, int weight);

    /**
     * Finds list of FoldingBikes by availability of lights at front and back.
     *
     * @param source   the list to be searched.
     * @param isLights does FoldingBikes has lights.
     * @return list FoldingBikes.
     */
    List<FoldingBike> findByLights(List<FoldingBike> source, boolean isLights);

    /**
     * Finds list of FoldingBikes by its color.
     *
     * @param source the list to be searched.
     * @param color  color to be searched for.
     * @return list FoldingBikes.
     */
    List<FoldingBike> findByColor(List<FoldingBike> source, String color);

    /**
     * Finds list of FoldingBikes by its price.
     *
     * @param source the list to be searched.
     * @param price  price to be searched for.
     * @return list FoldingBikes.
     */
    List<FoldingBike> findByPrice(List<FoldingBike> source, BigDecimal price);

    /**
     * Finds list of FoldingBikes by its size of wheels.
     *
     * @param source    the list to be searched.
     * @param wheelSize size of wheels to be searched for.
     * @return list FoldingBikes.
     */
    List<FoldingBike> findByWheelSize(List<FoldingBike> source, int wheelSize);

    /**
     * Finds list of FoldingBikes by its number of gears.
     *
     * @param source      the list to be searched.
     * @param gearsNumber number of gears to be searched for
     * @return list FoldingBikes.
     */
    List<FoldingBike> findByGearsNumber(List<FoldingBike> source, int gearsNumber);

    /**
     * Creates String which contains all the necessary fields that compose new folding bike.
     *
     * @return String which contains all the necessary fields that compose new folding bike.
     */
    String create();
}
