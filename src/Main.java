import Vehicle.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgramMethods pm = new ProgramMethods();
        ArrayList<VehicleAbs> myVehicles = new ArrayList<>();

        while (true) {
            pm.chooseWorkingType();
            int program = scanner.nextInt();
            if (program == 1) {
                pm.getAdminInstruction();
                int adminChoice = scanner.nextInt();
                if (adminChoice == 1) {
                    VehicleAbs.getAvailableVehicles();
                    VehicleAbs.getCurrentlyRentedVehicles();
                } else if (adminChoice == 2) {
                    pm.chooseVehicleType();
                    int vehicleType = scanner.nextInt();
                    if (vehicleType == 1) {
                        CombustionVehicle.createCombustionVehicle();
                    } else if (vehicleType == 2) {
                        ElectricVehicle.createElectricVehicle();
                    } else if (vehicleType == 3) {
                        HybridVehicle.createHybridVehicle();
                    } else if (vehicleType == 9) {
                        break;
                    } else {
                        System.out.println("Wrong input. Please try again");
                    }
                } else if (adminChoice == 3) {
                    System.out.println("Enter VIN Number: ");
                    scanner.nextLine();
                    String vin = scanner.nextLine();
                    VehicleAbs vehicle = VehicleAbs.findVehicleByVin(vin);
                    if (vehicle != null) {
                        System.out.println("Current vehicle attributes:");
                        System.out.println(vehicle);
                        System.out.println();
                        VehicleAbs.updateVehicleBase(vehicle);
                        if (vehicle.getType() == VehicleType.ELECTRIC) {
                            ElectricVehicle.updateElectricPart((ElectricVehicle) vehicle);
                        } else if (vehicle.getType() == VehicleType.HYBRID) {
                            HybridVehicle.updateHybridPart((HybridVehicle) vehicle);
                        } else {
                            CombustionVehicle.updateCombustionPart((CombustionVehicle) vehicle);
                        }
                        System.out.println("Vehicle successfully updated.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                } else if (adminChoice == 4) {
                    System.out.println("Enter VIN Number: ");
                    scanner.nextLine();
                    String vin = scanner.nextLine();
                    VehicleAbs vehicle = VehicleAbs.findVehicleByVin(vin);
                    if (vehicle != null) {
                        VehicleAbs.removeFromAvailableVehicles(vehicle);
                        System.out.println("Vehicle successfully removed.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                } else if (adminChoice == 5) {
                    System.out.println("Enter VIN Number: ");
                    scanner.nextLine();
                    String vin = scanner.nextLine();
                    VehicleAbs vehicle = VehicleAbs.findVehicleByVin(vin);
                    System.out.println(vehicle);
                } else if (adminChoice == 6) {
                    pm.fillAvailableCars();
                } else if (adminChoice == 9) {
                    break;
                } else {
                    System.out.println("Wrong input. Please try again");
                }
            } else if (program == 2) {
                pm.getCustomerInstruction();
                int userChoice = scanner.nextInt();
                if (userChoice == 1) {
                    VehicleAbs.getAvailableVehicles();
                } else if (userChoice == 2) {
                    if (myVehicles.size() > 0) {
                        for (VehicleAbs vehicle : myVehicles) {
                            System.out.println("VIN Number: " + vehicle.getVinNumber() + " | " +
                                    vehicle.getMake() + " " + vehicle.getModel());
                        }
                    } else {
                        System.out.println("You have no Vehicles currently rented.");
                    }
                } else if (userChoice == 3) {
                    System.out.println("Enter VIN Number: ");
                    scanner.nextLine();
                    String vin = scanner.nextLine();
                    VehicleAbs vehicle = VehicleAbs.findAvailableVehicleByVin(vin);
                    if (vehicle != null) {
                        System.out.println(vehicle);
                    } else {
                        System.out.println("Vehicle not found.");
                    }

                } else if (userChoice == 4) {
                    System.out.println("Enter VIN Number: ");
                    scanner.nextLine();
                    String vin = scanner.nextLine();
                    VehicleAbs vehicle = VehicleAbs.findAvailableVehicleByVin(vin);
                    System.out.println("Enter amount of days you want to rent the Vehicle for: ");
                    int rentDays = scanner.nextInt();
                    if (vehicle != null) {
                        VehicleAbs.rentVehicle(vehicle, rentDays);
                        myVehicles.add(vehicle);
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                } else if (userChoice == 5) {
                    System.out.println("Enter VIN Number: ");
                    scanner.nextLine();
                    String vin = scanner.nextLine();
                    VehicleAbs vehicle = pm.getVehicleFromUserArray(vin, myVehicles);
                    if (vehicle != null) {
                        VehicleAbs.returnVehicle(vehicle);
                        VehicleAbs.removeFromCurrentlyRentedVehicles(vehicle);
                        myVehicles.remove(vehicle);
                        VehicleAbs.addToAvailableVehicles(vehicle);
                    } else {
                        System.out.println("Vehicle not found.");
                    }

                } else if (userChoice == 9) {
                    break;
                } else {
                    System.out.println("Wrong input. Please try again");
                }
            } else if (program == 9) {
                break;
            } else {
                System.out.println("Wrong input. Please try again.");
            }
        }
    }
}