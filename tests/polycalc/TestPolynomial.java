package polycalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class TestPolynomial {

    @Test
    public void testBuild() {
        Polynomial p1 = new Polynomial();
        p1 = Polynomial.build("1 -2 0 3/4");

        Monomial m1 = new Monomial(0, new IntegerScalar(1));
        Monomial m2 = new Monomial(1, new IntegerScalar(-2));
        Monomial m3 = new Monomial(3, new RationalScalar(3,4));

        assertEquals(new ArrayList<Monomial>(List.of(m1, m2, m3)), p1.getMonomials());
    }

    @Test
    public void testAdd() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = Polynomial.build("1 2 3");
        p2 = Polynomial.build("1 2 3");

        Monomial m1 = new Monomial(0, new IntegerScalar(2));
        Monomial m2 = new Monomial(1, new IntegerScalar(4));
        Monomial m3 = new Monomial(2, new IntegerScalar(6));

        assertEquals(new ArrayList<Monomial>(List.of(m1, m2, m3)), (p1.add(p2)).getMonomials());
    }

    @Test
    public void testMul() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = Polynomial.build("1 0 3");
        p2 = Polynomial.build("1 2 3");

        Monomial m1 = new Monomial(0, new IntegerScalar(1));
        Monomial m2 = new Monomial(1, new IntegerScalar(2));
        Monomial m3 = new Monomial(2, new IntegerScalar(6));
        Monomial m4 = new Monomial(3, new IntegerScalar(6));
        Monomial m5 = new Monomial(4, new IntegerScalar(9));

        assertEquals(new ArrayList<Monomial>(List.of(m1, m2, m3, m4, m5)), (p1.mul(p2)).getMonomials());
    }

    @Test
    public void testEvaluate() {
        Polynomial p1 = new Polynomial();
        p1 = Polynomial.build("2 4/5 5");

        assertEquals(new IntegerScalar(131), p1.evaluate(new IntegerScalar(5)));
    }

    @Test
    public void testDerivative() {
        Polynomial p1 = new Polynomial();
        p1 = Polynomial.build("1 -2 3/4 5");
        Polynomial p2 = new Polynomial();
        p2 = Polynomial.build("-2 3/2 15");

        assertEquals(p2, p1.derivative());

    }

    @Test
    public void testEquals() {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial p3 = new Polynomial();
        p1 = Polynomial.build("1 -2 3/4 5");
        p2 = Polynomial.build("1 -2 3/4 5");
        p3 = Polynomial.build("2 3 4 5");

        assertTrue(p1.equals(p2));
        assertFalse(p2.equals(p3));

    }

    @Test
    public void testToString() {
        Polynomial p1 = new Polynomial();
        p1 = Polynomial.build("1 -2 3/4 5");
        Polynomial p2 = p1.derivative();

        assertEquals("1-2x+(3/4)x^2+5x^3", p1.toString());
        assertEquals("-2+(3/2)x+15x^2", p2.toString());
    }
}
