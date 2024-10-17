import BasicIO.ASCIIDataFile;

public class Car {
    public static final String[] CATEGORIES = new String[]{"Economy", "Full Size", "Van", "SUV"};
    private static final double[] RATES = new double[]{0.25, 0.50, 1.00, 1.25};
    public String plate;
    public int mileage;
    public int category;

    //Add three more instance variables
    public Car(ASCIIDataFile input) {
        plate = input.readString();
        mileage = input.readInt();
        category = input.readInt();

    }

    public String getLicence() {return plate;// returning empty string to get rid of the error of missing return statement.
    }

    public int getMileage() {
        return mileage; // returning 0 to get rid of the error of missing return statement.
    }


    public int getCategory() {
        return category; // returning 0 to get rid of the error of missing return statement.
    }

    /**
     * returns the rate of the car.
     *
     * @return For now, it will only return 0.0.
     */
    public double getRate() {
        return RATES[category]; // keep it for now and will be updated for next lab
    }

    /**
     * Will update the mileage after a car is returned and calculate the charge.
     *
     * @param m the new mileage.
     * @return For now, it will only return 0.
     */
    public double returned(int m) {
        return RATES[category] * (m-mileage);
    }
}