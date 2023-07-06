import Vehicle.*;

import java.util.ArrayList;
import java.util.Objects;

public class ProgramMethods {

    public void chooseWorkingType() {
        System.out.println("""
                Choose role:
                1. Admin
                2. User
                9. Exit program.
                """);
    }

    public void getAdminInstruction() {
        System.out.println("""
                Your role: Admin
                1. Show all Vehicles (available + rented).
                2. Add new Vehicle.
                3. Modify existing Vehicle.
                4. Delete existing Vehicle.
                5. Show Vehicle details.
                6. Fill shop with example vehicles.
                9. Exit program.
                """);
    }

    public void getCustomerInstruction() {
        System.out.println("""
                Your role: User
                1. Show available Vehicles.
                2. Show my Vehicles.
                3. Show Vehicle details.
                4. Rent a Vehicle.
                5. Return rented Vehicle.
                9. Exit program.
                """);
    }

    public void fillAvailableCars() {
        CombustionVehicle cv1 = new CombustionVehicle(
                "VIN0001",
                VehicleType.SEDAN,
                "Toyota",
                "Corolla",
                1200,
                2022,
                240.00,
                5,
                5,
                150,
                TransmissionType.AUTOMATIC,
                400.00,
                50,
                45,
                10
        );

        CombustionVehicle cv2 = new CombustionVehicle(
                "VIN0002",
                VehicleType.SUV,
                "Ford",
                "Explorer",
                1800.00,
                2021,
                320.00,
                7,
                5,
                250,
                TransmissionType.AUTOMATIC,
                500,
                70,
                40,
                11.8
        );

        CombustionVehicle cv3 = new CombustionVehicle(
                "VIN0003",
                VehicleType.HATCHBACK,
                "Volkswagen",
                "Golf",
                1100.00,
                2023,
                220,
                5,
                5,
                120,
                TransmissionType.AUTOMATIC,
                300,
                45,
                45,
                8.0
        );

        CombustionVehicle cv4 = new CombustionVehicle(
                "VIN0004",
                VehicleType.COUPE,
                "Chevrolet",
                "Camaro",
                1600.00,
                2022,
                480,
                4,
                3,
                300,
                TransmissionType.AUTOMATIC,
                600,
                65,
                50,
                11.1
        );

        CombustionVehicle cv5 = new CombustionVehicle(
                "VIN0005",
                VehicleType.PICKUP_TRUCK,
                "Ford",
                "F-150",
                2000.00,
                2023,
                400,
                5,
                5,
                250,
                TransmissionType.AUTOMATIC,
                600,
                80,
                45,
                13.3
        );

        VehicleAbs.addToAvailableVehicles(cv1);
        VehicleAbs.addToAvailableVehicles(cv2);
        VehicleAbs.addToAvailableVehicles(cv3);
        VehicleAbs.addToAvailableVehicles(cv4);
        VehicleAbs.addToAvailableVehicles(cv5);

        ElectricVehicle ev1 = new ElectricVehicle(
                "VIN0006",
                VehicleType.ELECTRIC,
                "Tesla",
                "Model S",
                2000.00,
                2022,
                350,
                5,
                5,
                600,
                TransmissionType.AUTOMATIC,
                500,
                85,
                60,
                400
        );

        ElectricVehicle ev2 = new ElectricVehicle(
                "VIN0007",
                VehicleType.ELECTRIC,
                "Nissan",
                "Leaf",
                1500.00,
                2023,
                150,
                5,
                5,
                150,
                TransmissionType.AUTOMATIC,
                250,
                40,
                90,
                270
        );

        ElectricVehicle ev3 = new ElectricVehicle(
                "VIN0008",
                VehicleType.ELECTRIC,
                "BMW",
                "i3",
                1200.00,
                2022,
                220,
                4,
                5,
                170,
                TransmissionType.AUTOMATIC,
                400,
                42,
                75,
                280
        );

        ElectricVehicle ev4 = new ElectricVehicle(
                "VIN0009",
                VehicleType.ELECTRIC,
                "Chevrolet",
                "Bolt EV",
                1600.00,
                2023,
                200,
                5,
                5,
                200,
                TransmissionType.AUTOMATIC,
                400,
                66,
                95,
                380
        );

        ElectricVehicle ev5 = new ElectricVehicle(
                "VIN0010",
                VehicleType.ELECTRIC,
                "Hyundai",
                "Kona Electric",
                1700.00,
                2022,
                170,
                5,
                5,
                201,
                TransmissionType.AUTOMATIC,
                300,
                64,
                99,
                415
        );

        VehicleAbs.addToAvailableVehicles(ev1);
        VehicleAbs.addToAvailableVehicles(ev2);
        VehicleAbs.addToAvailableVehicles(ev3);
        VehicleAbs.addToAvailableVehicles(ev4);
        VehicleAbs.addToAvailableVehicles(ev5);

        HybridVehicle hv1 = new HybridVehicle(
                "VIN0011",
                VehicleType.HYBRID,
                "Toyota",
                "Prius",
                1300.00,
                2022,
                160,
                5,
                5,
                121,
                TransmissionType.AUTOMATIC,
                300,
                43,
                25,
                3.9,
                5.0,
                80,
                40
        );

        HybridVehicle hv2 = new HybridVehicle(
                "VIN0012",
                VehicleType.HYBRID,
                "Honda",
                "Acord Hybrid",
                1500.00,
                2023,
                190,
                5,
                5,
                212,
                TransmissionType.AUTOMATIC,
                350,
                55,
                35,
                5.4,
                4.5,
                89,
                45
        );

        HybridVehicle hv3 = new HybridVehicle(
                "VIN0013",
                VehicleType.HYBRID,
                "Ford",
                "Escape Hybrid",
                1700.00,
                2022,
                210,
                5,
                5,
                200,
                TransmissionType.AUTOMATIC,
                400,
                52,
                30,
                6.3,
                6.0,
                75,
                35
        );

        HybridVehicle hv4 = new HybridVehicle(
                "VIN0014",
                VehicleType.HYBRID,
                "Lexus",
                "RX Hybrid",
                2000.00,
                2023,
                300,
                5,
                5,
                308,
                TransmissionType.AUTOMATIC,
                500,
                65,
                40,
                6.8,
                5.5,
                44,
                50
        );

        HybridVehicle hv5 = new HybridVehicle(
                "VIN0015",
                VehicleType.HYBRID,
                "Kia",
                "Nitro Hybrid",
                1400.00,
                2022,
                180,
                5,
                5,
                139,
                TransmissionType.AUTOMATIC,
                300,
                45,
                20,
                4.9,
                4.8,
                98,
                30
        );

        VehicleAbs.addToAvailableVehicles(hv1);
        VehicleAbs.addToAvailableVehicles(hv2);
        VehicleAbs.addToAvailableVehicles(hv3);
        VehicleAbs.addToAvailableVehicles(hv4);
        VehicleAbs.addToAvailableVehicles(hv5);

        System.out.println("Example Vehicles have been added to the shop.");
    }

    public void chooseVehicleType() {
        System.out.println("""
                1. Add Combustion Vehicle.
                2. Add Electric Vehicle.
                3. Add Hybrid Vehicle.""");
    }

    public VehicleAbs getVehicleFromUserArray(String vin, ArrayList<VehicleAbs> array) {
        for (VehicleAbs vehicle : array) {
            if (Objects.equals(vehicle.getVinNumber(), vin)) {
                return vehicle;
            }
        }
        return null;
    }

}
