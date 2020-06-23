package org.example.model.entities.impl;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.example.model.entities.AbstractVehicle;

import java.util.Objects;

public class FoldingBike extends AbstractVehicle implements Comparable<FoldingBike> {

    private int wheelSize;
    private int gearsNumber;

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getGearsNumber() {
        return gearsNumber;
    }

    public void setGearsNumber(int gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FoldingBike that = (FoldingBike) o;
        return wheelSize == that.wheelSize &&
                gearsNumber == that.gearsNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wheelSize, gearsNumber);
    }

    public boolean isContainsAllParams() {
        if (this.getBrand() == null) {
            return false;
        } else if (this.getWheelSize() == 0) {
            return false;
        } else if (this.getWeight() == 0) {
            return false;
        } else if (this.isHasLights() == null) {
            return false;
        } else if (this.getGearsNumber() == 0) {
            return false;
        } else if (this.getColor() == null) {
            return false;
        } else if (this.getPrice() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int compareTo(FoldingBike bike2) {
        return new CompareToBuilder()
                .append(this.getBrand(), bike2.getBrand())
                .append(this.getWheelSize(), bike2.getWheelSize())
                .append(this.getGearsNumber(), bike2.getGearsNumber())
                .append(this.getWeight(), bike2.getWeight())
                .append(this.isHasLights(), bike2.isHasLights())
                .append(this.getColor(), bike2.getColor())
                .append(this.getPrice(), bike2.getPrice())
                .toComparison();
    }

    @Override
    public String toString() {
        String aboutLights = isHasLights() ? "head/tail light." : "no head/tail light.";
        return "FOLDING BIKE" + " " +
                this.getBrand() + " with " + gearsNumber + " gear(s) and " + aboutLights
                + '\n' + "Price: " + getPrice() + " euros.";
    }
}
