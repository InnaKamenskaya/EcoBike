package org.example.model.entities;

public class VehicleFactory {
    public static AbstractVehicle getVehicle(VehicleType vehicleType, String source) {
        return vehicleType.buildVehicle(source);
    }
}
