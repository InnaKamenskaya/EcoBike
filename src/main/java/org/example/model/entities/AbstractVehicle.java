package org.example.model.entities;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AbstractVehicle {
    private String brand;
    private Boolean isHasLights;
    private int weight;
    private String color;
    private BigDecimal price;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Boolean isHasLights() {
        return isHasLights;
    }

    public void setHasLights(Boolean hasLights) {
        isHasLights = hasLights;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractVehicle that = (AbstractVehicle) o;
        return isHasLights == that.isHasLights &&
                weight == that.weight &&
                brand.equals(that.brand) &&
                color.equals(that.color) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, isHasLights, weight, color, price);
    }

    @Override
    public String toString() {
        return "AbstractVehicle{" +
                "brand='" + brand + '\'' +
                ", isHasLights=" + isHasLights +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
