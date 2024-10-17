
public class RatioFraction implements Fraction {
    int num;
    int den;
    /**
     * This constructor produces the fraction n/d.
     *
     * @param n the numerator
     * @param d the denominator (non-zero)
     * @throws UsingZeroToDivideException if the result would have a zero
     *                                    denominator.
     */
    public RatioFraction(int n, int d) {
       num=n;
       den=d;
       normalize();
    }
    public RatioFraction(){
        num=0;
        den=1;

    }
    
    /**
     * This method returns the fraction expressed as a String in the form
     * "snnnndddd" where s is the sign (i.e. - if negative) nnnn are the digits
     * of the numerator and dddd are the digits of the denominator.
     *
     * @return String the string representation.
     */
    public String toString() {
        return num +"÷"+den;
    }

    /**
     * This method determines the greatest common divisor (gcd) of two positive
     * integers. Note that if we call gcd(num, den) or gcd(den, num), it is
     * the same because the algorithm here is smart enough to differentiate
     * between which is smaller and which is larger.
     *
     * @param n first input
     * @param m second input
     * @return the greater common divisor
     */
    private int gcd(int n, int m) {
        if (n == 0 | m == 0) {
            n = 1;
        } else {
            while (n != m) {
                if (n > m) {
                    n = n - m;
                } else {
                    m = m - n;
                }
            }
        }
        return n;
    }

    private void normalize(){
        if(den==0){
            throw new UsingZeroToDivideException();
        }

        if(den<0){
            den*=-1;
            num*=-1;
        }

        int g = gcd(num, den);
        num /= g;
        den /= g;
    }
    
    public int getNumerator() {
        return num;
    }
    public int getDenominator() {
        return den;
    }
    public Fraction add(Fraction f) {
        return new RatioFraction(this.num * f.getDenominator() + den*f.getNumerator(), den * f.getDenominator());
    }
    public Fraction subtract(Fraction f) {
        return new RatioFraction(this.num * f.getDenominator() - den*f.getNumerator(), den * f.getDenominator());
    }
    public Fraction multiply(Fraction f) {
        return new RatioFraction(this.num * f.getNumerator(), den * f.getDenominator());
    }
    public Fraction divide(Fraction f) {
        return new RatioFraction(this.num * f.getDenominator(), den * f.getNumerator());
    }
    public int compareTo(Fraction f) {
        Fraction diff;
        diff= subtract(f);
        return Integer.compare(diff.getNumerator(), 0);
    }

}
