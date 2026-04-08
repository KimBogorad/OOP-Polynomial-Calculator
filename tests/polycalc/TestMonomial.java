package polycalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMonomial {

    @Test
    public void testNegativeExponentThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Monomial(-2, new IntegerScalar(5));
        });
}

    @Test
    public void testAddDifferentExponentsThrowsException() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(5));
        
        assertThrows(IllegalArgumentException.class, () -> {
            m1.add(m2);
        });
}

    @Test
    public void testAdd() {
        Monomial m1 = new Monomial(3, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(5));

        assertEquals(new Monomial(3, new IntegerScalar(8)), m1.add(m2));
    }

    @Test
    public void testMul() {
        Monomial m1 = new Monomial(3, new IntegerScalar(5));
        Monomial m2 = new Monomial(4, new IntegerScalar(6));

        assertEquals(new Monomial(7, new IntegerScalar(30)), m1.mul(m2));

    }

    @Test
    public void testEvaluate() {
        Monomial m1 = new Monomial(4, new IntegerScalar(2));
        
        assertEquals(new IntegerScalar(32), m1.evaluate(new IntegerScalar(2)));
    }

    @Test
    public void testDerivative() {
        int ex = 1;
        Scalar co = new RationalScalar(7,1);
        Monomial m = new Monomial(ex, co);
        
        // The derivative of 7x^1 is 7x^0. We expect a Monomial with exponent 0 and coef 7
        Monomial expectedDerivative = new Monomial(0, new RationalScalar(7, 1));
        
        assertEquals(expectedDerivative, m.derivative());
    }

    @Test
    public void testSign() {
        Monomial m1 = new Monomial(7, new IntegerScalar(11));

        assertEquals(1, m1.sign());
    }

    @Test
    public void testEquals() {
        Monomial m1 = new Monomial(3, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(2));
        Monomial m3 = new Monomial(3, new IntegerScalar(3));

        assertTrue(m1.equals(m3));
        assertFalse(m1.equals(m2));
    }

    @Test
    public void testMonomialToString() {
        int ex = 5;
        Scalar co = new IntegerScalar(0); // Using an IntegerScalar of 0
        Monomial m = new Monomial(ex, co);
        
        assertEquals("", m.toString());
    }

    
}
