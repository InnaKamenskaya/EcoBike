package org.example.model.dao.impl;

import org.example.model.dao.*;

public class FileDAOFactory implements DAOFactory {

    private static final FileDAOFactory FACTORY =new FileDAOFactory();

    private FileDAOFactory(){}

    public static FileDAOFactory getInstance() {
        return FACTORY;
    }

    @Override
    public VehicleDAO getVehicleDAO() {
        return VehicleDAOImpl.getInstance();
    }

    @Override
    public ElectroVehicleDAO getElectroVehicleDAO() {
        return ElectroVehicleDAOImpl.getInstance();
    }

    @Override
    public EBikeDAO getEBikeDAO() {
        return EBikeDAOImpl.getInstance();
    }

    @Override
    public FoldingBikeDAO getFoldingBikeDAO() {
        return FoldingBikeDAOImpl.getInstance();
    }

    @Override
    public SpeedelecDAO getSpeedelecDAO() {
        return SpeedelecDAOImpl.getInstance();
    }
}
