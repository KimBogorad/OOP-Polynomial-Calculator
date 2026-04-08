package polycalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestIntegerScalar {

    //-----------Test Addition-----------
    @Test
    public void testAddTwoIntegerScalars() {
        Scalar i1 = new IntegerScalar(1);
        Scalar i2 = new IntegerScalar(-1);
        
        assertEquals(new IntegerScalar(0), i1.add(i2));
    }
    @Test
    public void testAddRationalScalarToIntegerScalar() {
        Scalar i1 = new IntegerScalar(1);
        Scalar r1 = new RationalScalar(1, 2);
        
        assertEquals(new RationalScalar(3,2), i1.add(r1));
    }
    //-----------Test Multiplication-----------
    @Test
    public void testMulTwoIntegerScalars() {
        Scalar i1 = new IntegerScalar(1);
        Scalar i2 = new IntegerScalar(-1);
        
        assertEquals(new IntegerScalar(-1), i1.mul(i2));
    }
    
    @Test
    public void testMulRationalScalarToIntegerScalar() {
        Scalar i1 = new IntegerScalar(1);
        Scalar r1 = new RationalScalar(1, 2);
        
        assertEquals(new RationalScalar(1,2), i1.mul(r1));
    }

    @Test
    public void testNeg(){
        Scalar i1 = new IntegerScalar(5);

        assertEquals(new IntegerScalar(-5), i1.neg());
    }
    

    @Test
    public void testPower() {
        Scalar s1 = new IntegerScalar(2);

        assertEquals(new IntegerScalar(16), s1.power(4));
    }

    @Test
    public void testSign() {
        Scalar s1 = new IntegerScalar(6);

        assertEquals(1, s1.sign());
    }

    @Test
    public void testEquals() {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new IntegerScalar(5);
        Scalar s3 = new IntegerScalar(3);

        assertTrue(s1.equals(s2));
        assertFalse(s3.equals(s2));
    }


    @Test
    public void testIntegerScalarRationalScalarEquals() {
        Scalar s1 = new IntegerScalar(1);
        Scalar s2 = new RationalScalar(3, 3);
        
        assertTrue(s1.equals(s2));
    }

    @Test
    public void testToString() {
        Scalar s1 = new IntegerScalar(5);
        
        assertEquals("5", s1.toString());
    }
}