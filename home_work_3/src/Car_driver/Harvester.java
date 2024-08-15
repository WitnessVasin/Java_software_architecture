package Car_driver;

import javax.swing.plaf.synth.SynthUI;
import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping {

    private Refueling refueling;

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
    }

    public void setRefuelingStation(Refueling refueling) {
        this.refueling = refueling;
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }


    public void sweeping() {
        System.out.println("Авомобиль метет улицу.");
    }


    @Override
    public void wipMirrors() {

    }

    @Override
    public void wipWindshield() {

    }

    @Override
    public void wipHeadlights() {

    }

    @Override
    public void fuel() {
        if (fuelType != null) {
            if (refueling != null) {
                refueling.fuel(fuelType);
            } else {
                System.out.println("Refueling station is not set.");
            }
        } else {
            System.out.println("fuelType is null");
        }
    }
}