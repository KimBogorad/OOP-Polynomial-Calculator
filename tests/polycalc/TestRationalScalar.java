package polycalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRationalScalar {

    @Test
    public void testZeroDenominatorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RationalScalar(5, 0);
        });
}

    //-----------Test Addition-----------
    @Test
    public void testAddTwoRationalScalars() {
        Scalar r1 = new RationalScalar(1, 2);
        Scalar r2 = new RationalScalar(4,5);
    
        assertEquals(new RationalScalar(13,10), r2.add(r1));
    }
    @Test
    public void testAddIntegerScalarToRationalScalar() {
        Scalar i1 = new IntegerScalar(1);
        Scalar r1 = new RationalScalar(1, 2);
        
        assertEquals(new RationalScalar(3,2), r1.add(i1));
    }
    
    //-----------Test Multiplication-----------
    @Test
    public void testMulTwoRationalScalars() {
        Scalar r1 = new RationalScalar(1, 2);
        Scalar r2 = new RationalScalar(4,5);
    
        assertEquals(new RationalScalar(2,5), r2.mul(r1));
    }
    @Test
    public void testMulIntegerScalarToRationalScalar() {
        Scalar i1 = new IntegerScalar(1);
        Scalar r1 = new RationalScalar(1, 2);
        
        assertEquals(new RationalScalar(1,2), r1.mul(i1));
    }

    @Test
    public void testNeg(){
        RationalScalar i1 = new RationalScalar(5, 17);
        
        assertEquals(new RationalScalar(-5,17), i1.neg());
    }

    @Test
    public void testPower() {
        Scalar s1 = new RationalScalar(5, 4);

        assertEquals(new RationalScalar(25, 16), s1.power(2));
    }

    @Test
    public void testSign() {
        Scalar s1 = new RationalScalar(5, 6);

        assertEquals(1, s1.sign());
    }

    @Test
    public void testEquals() {
        Scalar s1 = new RationalScalar(5, 4);
        Scalar s2 = new RationalScalar(6, 10);
        Scalar s3 = new RationalScalar(3, 5);

        assertTrue(s2.equals(s3));
        assertFalse(s1.equals(s3));
    }

    @Test
    public void testToString() {
        Scalar s2 = new RationalScalar(1,2);
        
        assertEquals("1/2", s2.toString());
    }
}
