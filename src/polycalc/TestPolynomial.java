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
    public void 
}
