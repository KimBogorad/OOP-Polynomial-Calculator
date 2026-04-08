package polycalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMonomial {

    @Test
    public void testAdd() {
        Monomial m1 = new Monomial(3, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(5));

        assertEquals(new Monomial(3, new IntegerScalar(8)), m1.add(m2));
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
