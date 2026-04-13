package polycalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/* 
changes relative to hw1:
added new test class to new class RealScalar.
*/
public class TestRealScalar {

    //-----------Test Addition-----------
    @Test
    public void testAddTwoRealScalars() {
        Scalar i1 = new RealScalar(2.4);
        Scalar i2 = new RealScalar(2.6);
        
        assertEquals(new RealScalar(5.0), i1.add(i2));
    }
    @Test
    public void testAddRationalScalarToRealScalar() {
        Scalar r1 = new RealScalar(1);
        Scalar r2 = new RationalScalar(1, 2);
        
        assertEquals(new RealScalar(1.5), r1.add(r2));
    }
    @Test
    public void testAddIntegerScalarToRealScalar() {
        Scalar r1 = new RealScalar(2.4756);
        Scalar i1 = new IntegerScalar(1);
        
        assertEquals(new RealScalar(3.4756), r1.add(i1));
    }
    //-----------Test Multiplication-----------
    @Test
    public void testMulTwoRealScalars() {
        Scalar r1 = new RealScalar(1);
        Scalar r2 = new RealScalar(-1);
        
        assertEquals(new RealScalar(-1), r1.mul(r2));
    }
    
    @Test
    public void testMulRationalScalarToRealScalar() {
        Scalar r1 = new RealScalar(1);
        Scalar r2 = new RationalScalar(1, 2);
        
        assertEquals(new RealScalar(0.5), r1.mul(r2));
    }
    @Test
    public void testMulIntegerScalarToRealScalar() {
        Scalar r1 = new RealScalar(4.566789);
        Scalar i1 = new IntegerScalar(5);
       
        assertEquals(new RealScalar(22.833945), r1.mul(i1));
    }
    @Test
    public void testNeg(){
        Scalar r1 = new RealScalar(5);

        assertEquals(new RealScalar(-5), r1.neg());
    }
    

    @Test
    public void testPower() {
        Scalar s1 = new RealScalar(2);

        assertEquals(new RealScalar(16), s1.power(4));
    }

    @Test
    public void testSign() {
        Scalar s1 = new RealScalar(6);

        assertEquals(1, s1.sign());
    }

    @Test
    public void testEquals() {
        Scalar s1 = new RealScalar(5);
        Scalar s2 = new RealScalar(5);
        Scalar s3 = new RealScalar(3);

        assertTrue(s1.equals(s2));
        assertFalse(s3.equals(s2));
    }
    @Test
    public void testRealScalarIntegerScalarEquals() {
        Scalar s1 = new RealScalar(5.0);
        Scalar s2 = new IntegerScalar(5);
        
        assertTrue(s1.equals(s2));
    }

    @Test
    public void testRealScalarRationalScalarEquals() {
        Scalar s1 = new RealScalar(0.5);
        Scalar s2 = new RationalScalar(1, 2);
        
        assertTrue(s1.equals(s2));
    }



    @Test
    public void testToString() {
        Scalar s1 = new RealScalar(5);
        
        assertEquals("5", s1.toString());
    }
}