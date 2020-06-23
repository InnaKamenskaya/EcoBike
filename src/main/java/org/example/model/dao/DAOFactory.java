package org.example.model.dao;

/**
 * Interface that implements AbstractFactory GoF Pattern.
 * Contains getters of every entity DAO.
 * @author Inna Kamenskaya
 */
public interface DAOFactory {

    /**
     * Returns implementation of PeriodicalDao.
     * @return VehicleDAO implementation.
     */
    VehicleDAO getVehicleDAO();

    /**
     * Returns implementation of PeriodicalDao.
     * @return ElectroVehicle implementation.
     */
    ElectroVehicleDAO getElectroVehicleDAO();

    /**
     * Returns implementation of PeriodicalDao.
     * @return EBikeDAO implementation.
     */
    EBikeDAO getEBikeDAO();

    /**
     * Returns implementation of PeriodicalDao.
     * @return FoldingBikeDAO implementation.
     */
    FoldingBikeDAO getFoldingBikeDAO();

    /**
     * Returns implementation of PeriodicalDao.
     * @return SpeedelecDAO implementation.
     */
    SpeedelecDAO getSpeedelecDAO();

}
