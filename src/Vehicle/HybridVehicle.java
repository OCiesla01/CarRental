package Vehicle;

import java.util.Scanner;

public class HybridVehicle extends VehicleAbs {

    double fuelCapacity;
    double currentFuelLevel;
    double fuelEfficiency;
    double batteryCapacity;
    int currentBatteryLevel;
    int electricRange;

    public HybridVehicle() {
    }

    public HybridVehicle(String vinNumber, VehicleType type, String make, String model, double weight, int year,
                         double rentalPricePerDay, int numberOfSeats, int numberOfDoors, int horsePower,
                         TransmissionType transmissionType, double securityDeposit, double fuelCapacity,
                         double currentFuelLevel, double fuelEfficiency, double batteryCapacity,
                         int currentBatteryLevel, int electricRange) {

        super(vinNumber, type, make, model, weight, year, rentalPricePerDay, numberOfSeats,
                numberOfDoors, horsePower, transmissionType, securityDeposit);
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.fuelEfficiency = fuelEfficiency;
        this.batteryCapacity = batteryCapacity;
        this.currentBatteryLevel = currentBatteryLevel;
        this.electricRange = electricRange;
    }

    public static void createHybridVehicle() {
        Scanner scanner = new Scanner(System.in);
        HybridVehicle hv = new HybridVehicle();

        System.out.print("Enter VIN Number [String]: ");
        String vinNumber = scanner.nextLine();
        hv.setVinNumber(vinNumber);

        hv.setType(VehicleType.HYBRID);

        System.out.print("Enter make [String]: ");
        String make = scanner.nextLine();
        hv.setMake(make);

        System.out.print("Enter model [String]: ");
        String model = scanner.nextLine();
        hv.setModel(model);

        System.out.print("Enter weight (in kg) [double]: ");
        double weight = scanner.nextDouble();
        hv.setWeight(weight);

        System.out.print("Enter production year [int]: ");
        int year = scanner.nextInt();
        hv.setYear(year);

        System.out.print("Enter Rent Price per Day (in PLN) [double]: ");
        double rentPrice = scanner.nextDouble();
        hv.setRentalPricePerDay(rentPrice);

        System.out.print("Enter number of seats [int]: ");
        int seats = scanner.nextInt();
        hv.setNumberOfSeats(seats);

        System.out.print("Enter number of doors [int]: ");
        int doors = scanner.nextInt();
        hv.setNumberOfDoors(doors);

        System.out.print("Enter horse power [int]: ");
        int horsePower = scanner.nextInt();
        hv.setHorsePower(horsePower);

        System.out.println("""
            Choose transmission type [int]:
            1. Manual
            2. Automatic""");
        int transmission = scanner.nextInt();
        scanner.nextLine();
        switch (transmission) {
            case 1 -> hv.setTransmissionType(TransmissionType.MANUAL);
            case 2 -> hv.setTransmissionType(TransmissionType.AUTOMATIC);
            default -> System.out.println("Wrong input. Transmission type was not set.");
        }

        System.out.print("Enter security deposit amount (in PLN) [double]: ");
        double securityDeposit = scanner.nextDouble();
        hv.setSecurityDeposit(securityDeposit);

        System.out.print("Enter fuel capacity (in l) [double]: ");
        double fuelCapacity = scanner.nextDouble();
        hv.setFuelCapacity(fuelCapacity);

        System.out.print("Enter current fuel level (in l) [double]: ");
        double fuelLevel = scanner.nextDouble();
        hv.setCurrentFuelLevel(fuelLevel);

        System.out.print("Enter fuel efficiency (in l/100km) [double]: ");
        double fuelEfficiency = scanner.nextDouble();
        hv.setFuelEfficiency(fuelEfficiency);

        System.out.print("Enter battery capacity (in kWh) [double]: ");
        double batterCapacity = scanner.nextDouble();
        hv.setBatteryCapacity(batterCapacity);

        System.out.print("Enter current battery level (in %) [int]: ");
        int batteryLevel = scanner.nextInt();
        hv.setCurrentBatteryLevel(batteryLevel);

        System.out.print("Enter electric range [int]: ");
        int range = scanner.nextInt();
        hv.setElectricRange(range);

        VehicleAbs.addToAvailableVehicles(hv);
    }

    public static void updateHybridPart(HybridVehicle vehicle) {
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

        System.out.println("Current battery capacity: " + vehicle.getBatteryCapacity());
        System.out.println("Change fuel capacity: ");
        String newBatteryCap = scanner.nextLine();
        if (!newBatteryCap.isEmpty()) {
            vehicle.setBatteryCapacity(Double.parseDouble(newBatteryCap));
        }

        System.out.println("Current current battery level: " + vehicle.getCurrentBatteryLevel());
        System.out.println("Change current battery level: ");
        String newCurrentBatteryLevel = scanner.nextLine();
        if (!newCurrentBatteryLevel.isEmpty()) {
            vehicle.setCurrentBatteryLevel(Integer.parseInt(newCurrentBatteryLevel));
        }

        System.out.println("Current electric range: " + vehicle.getElectricRange());
        System.out.println("Change electric range: ");
        String newElectricRange = scanner.nextLine();
        if (!newElectricRange.isEmpty()) {
            vehicle.setElectricRange(Integer.parseInt(newElectricRange));
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

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getCurrentBatteryLevel() {
        return currentBatteryLevel;
    }

    public void setCurrentBatteryLevel(int currentBatteryLevel) {
        if (currentBatteryLevel > 100) {
            this.currentBatteryLevel = 100;
        } else if (currentBatteryLevel < 0) {
            this.currentBatteryLevel = 0;
        } else {
            this.currentBatteryLevel = currentBatteryLevel;
        }
    }

    public int getElectricRange() {
        return electricRange;
    }

    public void setElectricRange(int electricRange) {
        this.electricRange = electricRange;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nFuel Capacity: " + fuelCapacity + "l" +
                "\nCurrent Fuel Level:" + currentFuelLevel + "l" +
                "\nFuel Efficiency: " + fuelEfficiency + "l/100km" +
                "\nBattery Capacity: " + batteryCapacity + "kWh" +
                "\nCurrent Battery Level: " + currentBatteryLevel + "%" +
                "\nElectric Range: " + electricRange + "km";
    }
}
