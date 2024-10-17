/**
 * This class is a program to serve as a testbed for the Fraction interface
 * and the RatioFraction class.
 *
 * @author D. Hughes
 * @version 1.0 (Feb. 2016)
 * @see Fraction
 * @see RatioFraction
 */

public class TestFractionTwo {
    /**
     * The constructor that uses System.out.println(...) to print the fractions.
     */
    public TestFractionTwo() {
        System.out.println("Run this class for testing purposes only.");
        System.out.println("A jar needs to be created and imported into the other project to run the same class there.");

        Fraction f, g, h;  // fractions for testing
        f = new RatioFraction(1, 3);
        g = new RatioFraction(2, 3);

        h = f.add(g);
        System.out.println("1/3 + 2/3 = " + h.toString());
        h = f.subtract(g);
        System.out.println("1/3 - 2/3 = " + h.toString());
        h = f.multiply(g);
        System.out.println("1/3 * 2/3 = " + h.toString());
        h = f.divide(g);
        System.out.println("1/3 ÷ 2/3 = " + h.toString());
        System.out.println();

        int r = f.compareTo(g);
        System.out.println("1/3 < 2/3 = " + (r < 0));
        System.out.println("1/3 = 2/3 = " + (r == 0));
        System.out.println("1/3 > 2/3 = " + (r > 0));
        System.out.println();

        r = f.compareTo(f);
        System.out.println("1/3 < 1/3 = " + (r < 0));
        System.out.println("1/3 = 1/3 = " + (r == 0));
        System.out.println("1/3 > 1/3 = " + (r > 0));
        System.out.println();

        r = f.compareTo(f);
        System.out.println("1/3 < 1/3 = " + (r < 0));
        System.out.println("1/3 = 1/3 = " + (r == 0));
        System.out.println("1/3 > 1/3 = " + (r > 0));
        System.out.println();

        f = new RatioFraction();
        g = new RatioFraction(1, 1);
        h = f.divide(g);
        System.out.println("0/1 ÷ 1/1 = " + h.toString());
        System.out.println("1/1 ÷ 0/1 = ");
        try {
            h = g.divide(f);
            System.out.println(h.toString());
        } catch (UsingZeroToDivideException e) {
            System.out.println("1 ÷ 0 = Unfortunately, we cannot divide by zero!");
        }
    }

    public static void main(String[] args) {
        TestFractionTwo tft = new TestFractionTwo();
    }
}