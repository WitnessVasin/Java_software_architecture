package Car_driver;

public class RefuelingStation implements Refueling {

    @Override
    public void fuel(FuelType fuelType) {
        if (fuelType == null) {
            System.out.println("Fuel type is null");
            return;
        }

        switch (fuelType) {
            case Diesel -> System.out.println("Diesel Fuel");
            case GaseLine -> System.out.println("Gasoline Fuel");
            default -> System.out.println("Unknown Fuel Type");
        }
    }
}
