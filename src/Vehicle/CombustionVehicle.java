package Vehicle;

import java.util.Scanner;

public class CombustionVehicle extends VehicleAbs {

    double fuelCapacity;
    double currentFuelLevel;
    double fuelEfficiency;

    public CombustionVehicle() {
    }

    public CombustionVehicle(String vinNumber, VehicleType type, String make, String model, double weight, int year,
                             double rentalPricePerDay, int numberOfSeats, int numberOfDoors, int horsePower,
                             TransmissionType transmissionType, double securityDeposit, double fuelCapacity,
                             double currentFuelLevel, double fuelEfficiency) {

        super(vinNumber, type, make, model, weight, year, rentalPricePerDay, numberOfSeats,
                numberOfDoors, horsePower, transmissionType, securityDeposit);
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.fuelEfficiency = fuelEfficiency;
    }

    public static void createCombustionVehicle() {
        Scanner scanner = new Scanner(System.in);
        CombustionVehicle cv = new CombustionVehicle();

        System.out.print("Enter VIN Number [String]: ");
        String vinNumber = scanner.nextLine();
        cv.setVinNumber(vinNumber);

        System.out.println("""
            Choose Vehicle type [int]:
            1. SEDAN,
            2. HATCHBACK,
            3. SUV,
            4. COUPE,
            5. CONVERTIBLE,
            6. MINIVAN,
            7. STATION_WAGON,
            8. SPORTS_CAR,
            9. LUXURY_CAR,
            10. COMPACT,
            11. MUSCLE,
            12. CROSSOVER,
            13. OFF_ROAD,
            14. MICROCAR,
            15. SUPERCAR,
            16. VINTAGE,
            17. ROADSTER,
            18. PICKUP_TRUCK
            """);
        int type = scanner.nextInt();
        scanner.nextLine();
        switch (type) {
            case 1 -> cv.setType(VehicleType.SEDAN);
            case 2 -> cv.setType(VehicleType.HATCHBACK);
            case 3 -> cv.setType(VehicleType.SUV);
            case 4 -> cv.setType(VehicleType.COUPE);
            case 5 -> cv.setType(VehicleType.CONVERTIBLE);
            case 6 -> cv.setType(VehicleType.MINIVAN);
            case 7 -> cv.setType(VehicleType.STATION_WAGON);
            case 8 -> cv.setType(VehicleType.SPORTS_CAR);
            case 9 -> cv.setType(VehicleType.LUXURY_CAR);
            case 10 -> cv.setType(VehicleType.COMPACT);
            case 11 -> cv.setType(VehicleType.MUSCLE);
            case 12 -> cv.setType(VehicleType.CROSSOVER);
            case 13 -> cv.setType(VehicleType.OFF_ROAD);
            case 14 -> cv.setType(VehicleType.MICROCAR);
            case 15 -> cv.setType(VehicleType.SUPERCAR);
            case 16 -> cv.setType(VehicleType.VINTAGE);
            case 17 -> cv.setType(VehicleType.ROADSTER);
            case 18 -> cv.setType(VehicleType.PICKUP_TRUCK);
            default -> System.out.println("Wrong input. Vehicle type was not set.");
        }

        System.out.print("Enter make [String]: ");
        String make = scanner.nextLine();
        cv.setMake(make);

        System.out.print("Enter model [String]: ");
        String model = scanner.nextLine();
        cv.setModel(model);

        System.out.print("Enter weight (in kg) [double]: ");
        double weight = scanner.nextDouble();
        cv.setWeight(weight);

        System.out.print("Enter production year [int]: ");
        int year = scanner.nextInt();
        cv.setYear(year);

        System.out.print("Enter Rent Price per Day (in PLN) [double]: ");
        double rentPrice = scanner.nextDouble();
        cv.setRentalPricePerDay(rentPrice);

        System.out.print("Enter number of seats [int]: ");
        int seats = scanner.nextInt();
        cv.setNumberOfSeats(seats);

        System.out.print("Enter number of doors [int]: ");
        int doors = scanner.nextInt();
        cv.setNumberOfDoors(doors);

        System.out.print("Enter horse power [int]: ");
        int horsePower = scanner.nextInt();
        cv.setHorsePower(horsePower);

        System.out.println("""
            Choose transmission type [int]:
            1. Manual
            2. Automatic""");
        int transmission = scanner.nextInt();
        scanner.nextLine();
        switch (transmission) {
            case 1 -> cv.setTransmissionType(TransmissionType.MANUAL);
            case 2 -> cv.setTransmissionType(TransmissionType.AUTOMATIC);
            default -> System.out.println("Wrong input. Transmission type was not set.");
        }

        System.out.print("Enter security deposit amount (in PLN) [double]: ");
        double securityDeposit = scanner.nextDouble();
        cv.setSecurityDeposit(securityDeposit);

        System.out.print("Enter fuel capacity (in l) [double]: ");
        double fuelCapacity = scanner.nextDouble();
        cv.setFuelCapacity(fuelCapacity);

        System.out.print("Enter current fuel level (in l) [double]: ");
        double fuelLevel = scanner.nextDouble();
        cv.setCurrentFuelLevel(fuelLevel);

        System.out.print("Enter fuel efficiency (in l/100km) [double]: ");
        double fuelEfficiency = scanner.nextDouble();
        cv.setFuelEfficiency(fuelEfficiency);

        VehicleAbs.addToAvailableVehicles(cv);
    }

    public static void updateCombustionPart(CombustionVehicle vehicle) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current fuel capacity: " + vehicle.getFuelCapacity());
        System.out.println("Change fuel capacity: ");
        String newFuelCap = scanner.nextLine();
        if (!newFuelCap.isEmpty()) {
            vehicle.setFuelEfficiency(Double.parseDouble(newFuelCap));
        }

        System.out.println("Current current fuel level: " + vehicle.getCurrentFuelLevel());
        System.out.println("Change current fuel level: ");
        String newFuelLevel = scanner.nextLine();
        if (!newFuelLevel.isEmpty()) {
            vehicle.setCurrentFuelLevel(Double.parseDouble(newFuelLevel));
        }

        System.out.println("Current fuel efficiency: " + vehicle.getFuelEfficiency());
        System.out.println("Change fuel efficiency: ");
        String newFuelEff = scanner.nextLine();
        if (!newFuelEff.isEmpty()) {
            vehicle.setFuelEfficiency(Double.parseDouble(newFuelEff));
        }
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nFuel Capacity: " + fuelCapacity + "l" +
                "\nCurrent Fuel Level: " + currentFuelLevel + "l" +
                "\nFuel Efficiency: " + fuelEfficiency + "l/100km";
    }
}
