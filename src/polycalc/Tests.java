package polycalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    //-----------Test IntegerScalar & RationalScalar-----------

    @Test
    public void testAddTwoScalars() {
        Scalar i1 = new IntegerScalar(1);
        Scalar i2 = new IntegerScalar(-1);
        Scalar r1 = new RationalScalar(1, 2);
        Scalar r2 = new RationalScalar(4,5);
        
        assertEquals(new IntegerScalar(0), i1.add(i2));
        assertEquals(new RationalScalar(13,10), r2.add(r1));
        assertEquals(new RationalScalar(3,2), i1.add(r1));
    }

    @Test
    public void testScalarsToString() {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new RationalScalar(1,2);
        
        assertEquals("5", s1.toString());
        assertEquals("1/2", s2.toString());
    }

    @Test
    public void testScalarsEquals() {
        IntegerScalar s1 = new IntegerScalar(1);
        RationalScalar s2 = new RationalScalar(3, 3);
        
        assertTrue(s1.equals(s2));
    }

    @Test
    public void testMonomialToString() {
        int ex = 5;
        Scalar co = new IntegerScalar(0); // Using an IntegerScalar of 0
        Monomial m = new Monomial(ex, co);
        
        assertEquals("", m.toString());
    }

    @Test
    public void testMonomialDerivative() {
        int ex = 1;
        Scalar co = new RationalScalar(7,1);
        Monomial m = new Monomial(ex, co);
        
        // The derivative of 7x^1 is 7x^0. We expect a Monomial with exponent 0 and coef 7
        Monomial expectedDerivative = new Monomial(0, new RationalScalar(7, 1));
        
        assertEquals(expectedDerivative, m.derivative());
    }
}