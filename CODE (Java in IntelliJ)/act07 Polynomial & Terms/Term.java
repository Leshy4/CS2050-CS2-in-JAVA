// Christopher welch                   * Description: Activity 07 - Term

public class Term {

    private double coefficient;
    private int    exponent;
    private Term   next;

    private static final double TOLERANCE = 0.00000001;
    private static final double DEFAULT_COEFFICIENT = 0;

    public Term(double coefficient, int exponent) {
        if (Math.abs(coefficient) <= TOLERANCE)
            this.coefficient = DEFAULT_COEFFICIENT;
        else
            this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }

    public Term(double coefficient) {
        this(coefficient, 0);
    }

    public Term() {
        this(1, 0);
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public Term getNext() {
        return next;
    }

    public void setNext(final Term next) {
        this.next = next;
    }

    // TODOd: add the given term's coefficient to the callee term's coefficient if and only if they have the same exponent value
    public void add(final Term other) {
        if (this.exponent == other.exponent)
            this.coefficient += other.coefficient;
    }

    // TODOd: two terms are considered to be equal if they have the same values for their coefficient and exponent; note that coefficient is a
    //  floating-point value, so make sure you accept a TOLERANCE when comparing two coefficients for equality
    @Override
    public boolean equals(Object obj) {
        Term other = (Term) obj;
        if (this.exponent == other.exponent && Math.abs(this.coefficient - other.coefficient) <= TOLERANCE)
            return true;
        return false;
    }

    // TODOd: use the following examples to figure it out the format to use:
    //  8x^3
    //  -2x^2
    //  7x
    //  3.2
    @Override
    public String toString() {
        String out = "";
        if (exponent == 0)
            out += coefficient + "";
        else if (exponent == 1)
            out += coefficient + "x";
        else
            out += coefficient + "x^" + exponent;
        return out;
    }

    // TODOd: return a new term that has the same coefficient and exponent of the callee term
    @Override
    public Object clone()  {
        return new Term(coefficient, exponent);
    }
}