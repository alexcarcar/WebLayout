// Extend Vehicle to create a Truck specialization. (p 239)
class Truck extends Vehicle {
    private int cargocap; // cargo capacity in pounds

    // This is a constructor for Truck.
    Truck(int p, int f, int m, int c) {
        // Initialize using Vehicle's constructor
        super(p, f, m);
        cargocap = c;
    }

    // Accessor methods for cargocap.
    int getCargo() { return cargocap; }
    void putCargo(int c) { cargocap = c; }
}

class Vehicle {
    private int passengers;
    private int fuelcap;
    private int mpg;

    Vehicle() {
    }

    // This is a constructor for Vehicle. (p 129)
    Vehicle(int p, int f, int m) {
    	passengers = p;
    	fuelcap = f;
    	mpg = m;
    }

    // Display the range. (p 113)
    void printRange() {
        System.out.println("Range is " + range());
    }

    // Use a return value. (p 116)
    int range() {
        return mpg * fuelcap;
    }

    // Add a paramaterized method that computes the fuel for a distance
    double fuelneeded(int miles) {
        return (double) miles / mpg;
    }

    // Accessor methods for instance variables.
    int getPassengers() { return passengers; }
    void setPassengers(int p) { passengers = p; }
    int getFuelcap() { return fuelcap; }
    void setFuelcap(int f) { fuelcap = f; }
    int getMpg() { return mpg; }
    void setMpg(int m) { mpg = m; }
}

class TruckDemo {
    public static void main(String[] args) {
        // construct some trucks;
        Truck semi = new Truck(2, 200, 7, 44000);
        Truck pickup = new Truck(3, 28, 15, 2000);
        double gallons;
        int dist = 252;

        gallons = semi.fuelneeded(dist);
        System.out.println("Semi can carry "+semi.getCargo()+" pounds.");
        System.out.println("To go "+dist+" miles semi needs "+gallons+" gallons.");

        gallons = pickup.fuelneeded(dist);
        System.out.println("Pickup can carry "+pickup.getCargo()+" pounds.");
        System.out.println("To go "+dist+" miles pickup needs "+gallons+" gallons.");
        // Semi can carry 44000 pounds.
        // To go 252 miles semi needs 36.0 gallons.
        // Pickup can carry 2000 pounds.
        // To go 252 miles pickup needs 16.8 gallons.
    }
}