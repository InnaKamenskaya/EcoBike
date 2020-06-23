package org.example.model.entities;

import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.Objects;

public abstract class ElectroVehicle extends AbstractVehicle implements Comparable<ElectroVehicle>{

    private int maxSpeed;
    private int batteryCapacity;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectroVehicle that = (ElectroVehicle) o;
        return maxSpeed == that.maxSpeed &&
                batteryCapacity == that.batteryCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSpeed, batteryCapacity);
    }

    public boolean isContainsAllParams(){
        if (this.getBrand() == null){
            return false;
        }else if (this.getMaxSpeed() == 0){
            return false;
        }else if (this.getWeight() == 0){
            return false;
        }else if (this.isHasLights() == null){
            return false;
        }else if(this.getBatteryCapacity() == 0){
            return false;
        }else if(this.getColor() == null){
            return false;
        }else if(this.getPrice() == null){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public int compareTo(ElectroVehicle bike2) {
        return new CompareToBuilder()
                .append(this.getBrand(), bike2.getBrand())
                .append(this.getMaxSpeed(), bike2.getMaxSpeed())
                .append(this.getWeight(), bike2.getWeight())
                .append(this.isHasLights(), bike2.isHasLights())
                .append(this.getBatteryCapacity(), bike2.getBatteryCapacity())
                .append(this.getColor(), bike2.getColor())
                .append(this.getPrice(), bike2.getPrice())
                .toComparison();
    }
}
