package Car_driver;

public class RefuelingStationv2 implements Refueling {

    @Override
    public void fuel(FuelType fuelType) {

        switch (fuelType) {
            case FuelType.Diesel -> System.out.println("Diesel Fuel");
            case FuelType.GaseLine -> System.out.println("GaseLine Fuel");
        }
    }
}
