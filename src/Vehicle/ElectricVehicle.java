package Vehicle;

import java.util.Scanner;

public class ElectricVehicle extends VehicleAbs {

    double batteryCapacity;
    int currentBatteryLevel;
    int electricRange;

    public ElectricVehicle() {
    }

    public ElectricVehicle(String vinNumber, VehicleType type, String make, String model, double weight, int year,
                           double rentalPricePerDay, int numberOfSeats, int numberOfDoors, int horsePower,
                           TransmissionType transmissionType, double securityDeposit, double batteryCapacity,
                           int currentBatteryLevel, int electricRange) {

        super(vinNumber, type, make, model, weight, year, rentalPricePerDay, numberOfSeats,
                numberOfDoors, horsePower, transmissionType, securityDeposit);
        this.batteryCapacity = batteryCapacity;
        this.currentBatteryLevel = currentBatteryLevel;
        this.electricRange = electricRange;
    }

    public static void createElectricVehicle() {
        Scanner scanner = new Scanner(System.in);
        ElectricVehicle ev = new ElectricVehicle();

        System.out.print("Enter VIN Number [String]: ");
        String vinNumber = scanner.nextLine();
        ev.setVinNumber(vinNumber);

        ev.setType(VehicleType.ELECTRIC);

        System.out.print("Enter make [String]: ");
        String make = scanner.nextLine();
        ev.setMake(make);

        System.out.print("Enter model [String]: ");
        String model = scanner.nextLine();
        ev.setModel(model);

        System.out.print("Enter weight (in kg) [double]: ");
        double weight = scanner.nextDouble();
        ev.setWeight(weight);

        System.out.print("Enter production year [int]: ");
        int year = scanner.nextInt();
        ev.setYear(year);

        System.out.print("Enter Rent Price per Day (in PLN) [double]: ");
        double rentPrice = scanner.nextDouble();
        ev.setRentalPricePerDay(rentPrice);

        System.out.print("Enter number of seats [int]: ");
        int seats = scanner.nextInt();
        ev.setNumberOfSeats(seats);

        System.out.print("Enter number of doors [int]: ");
        int doors = scanner.nextInt();
        ev.setNumberOfDoors(doors);

        System.out.print("Enter horse power [int]: ");
        int horsePower = scanner.nextInt();
        ev.setHorsePower(horsePower);

        System.out.println("""
            Choose transmission type [int]:
            1. Manual
            2. Automatic""");
        int transmission = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character
        switch (transmission) {
            case 1 -> ev.setTransmissionType(TransmissionType.MANUAL);
            case 2 -> ev.setTransmissionType(TransmissionType.AUTOMATIC);
            default -> System.out.println("Wrong input. Transmission type was not set.");
        }

        System.out.print("Enter security deposit amount (in PLN) [double]: ");
        double securityDeposit = scanner.nextDouble();
        ev.setSecurityDeposit(securityDeposit);

        System.out.print("Enter battery capacity (in kWh) [double]: ");
        double batterCapacity = scanner.nextDouble();
        ev.setBatteryCapacity(batterCapacity);

        System.out.print("Enter current battery level (in %) [int]: ");
        int batteryLevel = scanner.nextInt();
        ev.setCurrentBatteryLevel(batteryLevel);

        System.out.print("Enter electric range [int]: ");
        int range = scanner.nextInt();
        ev.setElectricRange(range);

        VehicleAbs.addToAvailableVehicles(ev);
    }

    public static void updateElectricPart(ElectricVehicle vehicle) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current battery capacity: " + vehicle.getBatteryCapacity());
        System.out.println("Change battery capacity: ");
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
                "\nbatteryCapacity: " + batteryCapacity + "kWh" +
                "\nCurrent Battery Level: " + currentBatteryLevel + "%" +
                "\nElectric Range: " + electricRange + "km";
    }
}
