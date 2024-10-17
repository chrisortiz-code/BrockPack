/**
 * This class is a program to serve as a testbed for the Fraction interface
 * and the RatioFraction class.
 *
 * @author D. Hughes
 * @version 1.0 (Feb. 2016)
 * @see Fraction
 * @see RatioFraction
 */

public class TestFractionOne {
    /**
     * The constructor that uses System.out.println(...) to print the fractions.
     */
    public TestFractionOne() {
        System.out.println("Run this class for testing purposes only.");
        System.out.println("A jar needs to be created and imported into the other project to run the same class there.");
        Fraction f;
        f = new RatioFraction(1, 3);
        System.out.println("1 ÷ 3 = " + f);
        f = new RatioFraction(3, 9);
        System.out.println("3 ÷ 9 = " + f);
        f = new RatioFraction(9, 3);
        System.out.println("9 ÷ 3 = " + f);
        f = new RatioFraction(-1, 3);
        System.out.println("-1 ÷ 3 = " + f);
        f = new RatioFraction(1, -3);
        System.out.println("1 ÷ -3 = " + f);
        f = new RatioFraction(-1, -3);
        System.out.println("-1 ÷ -3 = " + f);
        f = new RatioFraction(0, 3);
        System.out.println("0 ÷ 3 = " + f);
        try {
            f = new RatioFraction(1, 0);
            System.out.println("1 ÷ 0 = " + f);
        } catch (UsingZeroToDivideException e) {
            System.out.println("1 ÷ 0 = Unfortunately, we cannot divide by zero!");
        }
    }

    public static void main(String[] args) {
        TestFractionOne tfo = new TestFractionOne();
    }
}