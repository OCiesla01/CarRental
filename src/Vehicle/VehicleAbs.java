package Vehicle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class VehicleAbs {

    String vinNumber;
    VehicleType type;
    String make;
    String model;
    double weight;
    int year;
    double rentalPricePerDay;
    int numberOfSeats;
    int numberOfDoors;
    int horsePower;
    TransmissionType transmissionType;
    boolean isRented = false;
    double securityDeposit;
    static ArrayList<VehicleAbs> availableVehicles = new ArrayList<>();
    static ArrayList<VehicleAbs> currentlyRentedVehicles = new ArrayList<>();

    public VehicleAbs() {
    }

    public VehicleAbs(String vinNumber, VehicleType type, String make, String model, double weight, int year,
                      double rentalPricePerDay, int numberOfSeats, int numberOfDoors, int horsePower,
                      TransmissionType transmissionType, double securityDeposit) {
        this.vinNumber = vinNumber;
        this.type = type;
        this.make = make;
        this.model = model;
        this.weight = weight;
        this.year = year;
        this.rentalPricePerDay = rentalPricePerDay;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.horsePower = horsePower;
        this.transmissionType = transmissionType;
        this.securityDeposit = securityDeposit;

        availableVehicles.add(this);
    }

    public static void rentVehicle(VehicleAbs vehicle, int rentDays) {
        calculateRentalCost(vehicle, rentDays);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to rent the vehicle: " + vehicle.make + " " + vehicle.model + "\n" +
                "Please enter (R)ent or (C)ancel ");
        String decision = scanner.nextLine();
        if (confirmRental(decision)) {
            availableVehicles.remove(vehicle);
            currentlyRentedVehicles.add(vehicle);
            vehicle.setRented(true);
            System.out.println("Car successfully rented.");
        } else {
            System.out.println("Rental has been cancelled.");
        }
    }

    private static void calculateRentalCost(VehicleAbs vehicle, int rentDays) {
        double price = 0;
        if (rentDays <= 7) {
            price = (vehicle.rentalPricePerDay * rentDays);
        } else if (rentDays > 7 && rentDays <= 14) {
            price =  (vehicle.rentalPricePerDay * rentDays) * 0.9;
        } else if (rentDays > 14 && rentDays <= 31) {
            price =  (vehicle.rentalPricePerDay * rentDays) * 0.85;
        } else if (rentDays > 31) {
            price = ((vehicle.rentalPricePerDay * rentDays) * 0.8);
        }

        double totalCost = price + vehicle.securityDeposit;

        System.out.println("Rental cost: " + price + " PLN" +
                "\nSecurity deposit: " + vehicle.securityDeposit + " PLN" +
                "\nTotal: " + totalCost + " PLN");
    }

    private static boolean confirmRental(String decision) {
        return decision.toLowerCase().charAt(0) == 'r';
    }

    public static void returnVehicle(VehicleAbs vehicle) {
        vehicle.setRented(false);
        System.out.println("Vehicle successfully returned");
    }

    public static void updateVehicleBase(VehicleAbs vehicle) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new values for specific attributes (leave blank for no change):");

        System.out.println("Current VIN Number: " + vehicle.getVinNumber());
        System.out.println("Change VIN Number: ");
        String newVin = scanner.nextLine();
        if (!newVin.isEmpty()) {
            vehicle.setVinNumber(newVin);
        }

        System.out.println("Current make: " + vehicle.getMake());
        System.out.println("Change make: ");
        String newMake = scanner.nextLine();
        if (!newMake.isEmpty()) {
            vehicle.setMake(newMake);
        }

        System.out.println("Current model: " + vehicle.getModel());
        System.out.println("Change model: ");
        String newModel = scanner.nextLine();
        if (!newModel.isEmpty()) {
            vehicle.setModel(newModel);
        }

        System.out.println("Current weight: " + vehicle.getWeight());
        System.out.println("Change weight: ");
        String newWeight = scanner.nextLine();
        if (!newWeight.isEmpty()) {
            vehicle.setWeight(Double.parseDouble(newWeight));
        }

        System.out.println("Current year: " + vehicle.getYear());
        System.out.println("Change year: ");
        String newYear = scanner.nextLine();
        if (!newYear.isEmpty()) {
            vehicle.setYear(Integer.parseInt(newYear));
        }

        System.out.println("Current rental price: " + vehicle.getRentalPricePerDay());
        System.out.println("Change rental price: ");
        String newRentalPrice = scanner.nextLine();
        if (!newRentalPrice.isEmpty()) {
            vehicle.setRentalPricePerDay(Double.parseDouble(newRentalPrice));
        }

        System.out.println("Current number of seats: " + vehicle.getNumberOfSeats());
        System.out.println("Change number of seats: ");
        String newSeats = scanner.nextLine();
        if (!newSeats.isEmpty()) {
            vehicle.setNumberOfSeats(Integer.parseInt(newSeats));
        }

        System.out.println("Current number of doors: " + vehicle.getNumberOfDoors());
        System.out.println("Change number of doors: ");
        String newDoors = scanner.nextLine();
        if (!newDoors.isEmpty()) {
            vehicle.setNumberOfDoors(Integer.parseInt(newDoors));
        }

        System.out.println("Current horse power: " + vehicle.getHorsePower());
        System.out.println("Change horse power: ");
        String newHorse = scanner.nextLine();
        if (!newHorse.isEmpty()) {
            vehicle.setHorsePower(Integer.parseInt(newHorse));
        }

        System.out.println("Current security deposit: " + vehicle.getSecurityDeposit());
        System.out.println("Change security deposit: ");
        String newSec = scanner.nextLine();
        if (!newSec.isEmpty()) {
            vehicle.setSecurityDeposit(Double.parseDouble(newSec));
        }
    }

    public static VehicleAbs findVehicleByVin(String vin) {
        for (VehicleAbs vehicle : VehicleAbs.getAllVehicles()) {
            if (Objects.equals(vehicle.getVinNumber(), vin)) {
                return vehicle;
            }
        }
        return null;
    }

    public static VehicleAbs findAvailableVehicleByVin(String vin) {
        for (VehicleAbs vehicle : VehicleAbs.getAllAvailableVehicles()) {
            if (Objects.equals(vehicle.getVinNumber(), vin)) {
                return vehicle;
            }
        }
        return null;
    }

    public static ArrayList<VehicleAbs> getAllVehicles() {
        ArrayList<VehicleAbs> allVehicles = new ArrayList<>();
        allVehicles.addAll(availableVehicles);
        allVehicles.addAll(currentlyRentedVehicles);
        return allVehicles;
    }

    public static ArrayList<VehicleAbs> getAllAvailableVehicles() {
        return new ArrayList<>(availableVehicles);
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(double rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public double getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(double securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public static void addToAvailableVehicles(VehicleAbs vehicle) {
        availableVehicles.add(vehicle);
    }

    public static void removeFromAvailableVehicles(VehicleAbs vehicleAbs) {
        availableVehicles.remove(vehicleAbs);
    }

    public static void getAvailableVehicles() {
        System.out.println("Available Vehicles: ");
        if (availableVehicles.size() != 0) {
            for (VehicleAbs vehicle : availableVehicles) {
                System.out.println("VIN Number: " + vehicle.vinNumber + " | " + vehicle.make + " " + vehicle.model);
            }
        } else {
            System.out.println("No Vehicles Available at the moment.");
        }

    }

    public static void addToCurrentlyRentedVehicles(VehicleAbs vehicle) {
        currentlyRentedVehicles.add(vehicle);
    }

    public static void removeFromCurrentlyRentedVehicles(VehicleAbs vehicle) {
        currentlyRentedVehicles.remove(vehicle);
    }

    public static void getCurrentlyRentedVehicles() {
        System.out.println("Currently rented Vehicles: ");
        if (currentlyRentedVehicles.size() != 0) {
            for (VehicleAbs vehicle : currentlyRentedVehicles) {
                System.out.println("VIN Number: " + vehicle.vinNumber + " | " + vehicle.make + " " + vehicle.model);
            }
        } else {
            System.out.println("No Vehicles are rented at the moment.");
        }

    }

    @Override
    public String toString() {
        return make + " " + model + ", " + year +
                "\nVIN Number: " + vinNumber +
                "\nType: " + type +
                "\nWeight: " + weight + "kg" +
                "\nRental Price per Day: " + rentalPricePerDay + "PLN" +
                "\nNumber of Seats: " + numberOfSeats +
                "\nNumber of Doors: " + numberOfDoors +
                "\nHorse Power: " + horsePower +
                "\nTransmission Type: " + transmissionType +
                "\nCurrently rented: " + isRented +
                "\nSecurity Deposit: " + securityDeposit + "PLN";
    }
}
