package org.example.model.dao;

import org.example.model.entities.impl.Speedelec;

import java.util.List;

/**
 * Data Access object for speedelec.
 *
 * @author Inna Kamenskaya.
 */
public interface SpeedelecDAO {

    /**
     * Finds all Speedelecs in the file.
     *
     * @param source path to the file.
     * @return list Speedelec.
     */
    List<Speedelec> findAllSpeedelecs(String source);

    /**
     * Creates String which contains all the necessary fields that compose new speedelec.
     *
     * @return String which contains all the necessary fields that compose new speedelec.
     */
    String create();
}
