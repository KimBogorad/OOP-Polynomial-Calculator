package polycalc;
public class Main {
    public static void main(String[] args) {
        testScalarsToString(); //V
        testScalarsEquals(); //V
        testMonomialToString();
        testMonomialDerivative();
    }
    public static void testScalarsToString() {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new RationalScalar(1,2);
        System.out.println("s1: " + s1.toString());
        System.out.println("s2: " + s2.toString());
    }
    public static void testScalarsEquals() {
        IntegerScalar s1 = new IntegerScalar(1);
        RationalScalar s2 = new RationalScalar(3, 3);
        System.out.println(s1.equals(s2));
    }
    public static void testMonomialToString() {
        int ex = 5;
        Scalar co = new RationalScalar(0,1);
        Monomial m = new Monomial(ex, co);
        System.out.println("test monomial toString(): "+ m.toString());
    }
    public static void testMonomialDerivative() {
        int ex = 1;
        Scalar co = new RationalScalar(7,1);
        Monomial m = new Monomial(ex, co);
        System.out.println("Monomial Derivative:");
        System.out.println("Before: " + m.toString());
        System.out.println("After: " + m.derivative().toString());
    }
}