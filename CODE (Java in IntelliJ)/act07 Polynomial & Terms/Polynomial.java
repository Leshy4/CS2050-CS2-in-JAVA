
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Polynomial{
    private int exponentDegree = 0;
    private double coefficient = 0;
    private Term firstTerm;

    public Polynomial() {
        firstTerm = null;
    }

    // TODOd: return the maximum exponent value of the polynomial
    public int degree() {
        if (firstTerm == null)
            return 0;
        return firstTerm.getExponent();
    }

    // TODOd: return the number of terms of the polynomial
    public int size() {
        Term current = firstTerm;
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // TODOd: add the given term to the polynomial (see activity instructions for more detailed information)
    void addTerm(final Term term){
        Term newTerm = (Term) term.clone();
        if (firstTerm == null)
            firstTerm = newTerm;
        else {
            Term previous = null;
            Term current = firstTerm;
            while(current != null)
            {   if (newTerm.getExponent() > current.getExponent()){
                newTerm.setNext(current);}
                if (firstTerm == current)
                    firstTerm = newTerm;
                else {
                    previous.setNext(newTerm);
                    return;
                }
                if (newTerm.getExponent() == current.getExponent())
                {   current.add(newTerm);
                    return;
                }
                else {
                    previous = current;
                    current = current.getNext();
                }
            }
            previous.setNext(newTerm);
        }
    }

    // TODOd: add the terms of the given polynomial to the callee polynomial; hint: traverse the given
    //  polynomial and call addTerm to add each of its terms to the callee polynomial
    void add(final Polynomial other) {
        Term current = other.firstTerm;
        while(current != null){
            addTerm(current);
            current = current.getNext();
        }
    }

    @Override
    public boolean equals(Object obj)
    {   Term other = (Term) obj;
        if (this.exponentDegree == other.exponentDegree && Math.abs(this.coefficient - other.coefficient) <= TOLERANCE)
            return true;
        return false;
    }

    // TODOd: traverse the callee polynomial and call toString from each of its terms to generate
    //  a string representation of the polynomial; use the following examples to figure it out the
    //  format to use:
    //  8x^3 -2x^2 + 7x + 3.2
    @Override
    public String toString() {
        Term current = firstTerm;
        String out = "";
        while (current != null) {
            if (current == firstTerm)
                out += current;
            else if (current.getCoefficient() >= 0)
                out += " + " + current;
            else
                out += " " + current;
            current = current.getNext();
        }
        return out;
    }

    // TODOd: return the term with the given exponent; null if the term does not exist
    Term getTerm(int exponent) {
        Term current = firstTerm;
        while (current != null)
        {   if (current.getExponent() == exponent)
            return current;
            if (current.getExponent() < exponentDegree)
                return null;
            current = current.getNext();
        }
        return null;
    }

}
