package org.example.model.entities.impl;

import org.example.model.entities.ElectroVehicle;

public class EBike extends ElectroVehicle {

    @Override
    public String toString() {
        String aboutLights = isHasLights() ? "head/tail light." : "no head/tail light.";
        return "E-BIKE" + " " +
                this.getBrand() + " with "  + this.getBatteryCapacity() + " mAh battery and " + aboutLights
                + '\n' + "Price: " + this.getPrice() + " euros.";

    }
}
