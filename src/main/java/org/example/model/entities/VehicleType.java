package org.example.model.entities;

import org.example.model.entities.impl.EBike;
import org.example.model.entities.impl.FoldingBike;
import org.example.model.entities.impl.Speedelec;
import org.example.util.Utils;

import java.math.BigDecimal;

public enum  VehicleType {

    E_BIKE {
        @Override
        public AbstractVehicle buildVehicle(String source) {
            EBike bike = new EBike();
            String[] param = Utils.parseString(source);
            bike.setBrand(param[0]);
            bike.setMaxSpeed(Integer.parseInt(param[1]));
            bike.setWeight(Integer.parseInt(param[2]));
            bike.setHasLights(Boolean.parseBoolean(param[3]));
            bike.setBatteryCapacity(Integer.parseInt(param[4]));
            bike.setColor(param[5]);
            bike.setPrice(new BigDecimal(param[6]));
            return bike;
        }
    }, SPEEDELEC {
        @Override
        public AbstractVehicle buildVehicle(String source) {
            Speedelec bike = new Speedelec();
            String[] param = Utils.parseString(source);
            bike.setBrand(param[0]);
            bike.setMaxSpeed(Integer.parseInt(param[1]));
            bike.setWeight(Integer.parseInt(param[2]));
            bike.setHasLights(Boolean.parseBoolean(param[3]));
            bike.setBatteryCapacity(Integer.parseInt(param[4]));
            bike.setColor(param[5]);
            bike.setPrice(new BigDecimal(param[6]));
            return bike;
        }
    }, FOLDING_BIKE {
        @Override
        public AbstractVehicle buildVehicle(String source) {
            FoldingBike bike = new FoldingBike();
            String[] param = Utils.parseString(source);
            bike.setBrand(param[0]);
            bike.setWheelSize(Integer.parseInt(param[1]));
            bike.setGearsNumber(Integer.parseInt(param[2]));
            bike.setWeight(Integer.parseInt(param[3]));
            bike.setHasLights(Boolean.parseBoolean(param[4]));
            bike.setColor(param[5]);
            bike.setPrice(new BigDecimal(param[6]));
            return bike;
        }
    };

    public abstract AbstractVehicle buildVehicle(String source) ;
}