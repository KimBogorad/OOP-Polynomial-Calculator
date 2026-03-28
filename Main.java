public class Main {
    public static void main(String[] args) {
        Scalar s1 = new IntegerScalar(5);
        Scalar s2 = new RationalScalar(1,2);
        System.out.println("s1: " + s1.toString());
        System.out.println("s2: " + s2.toString());
    }
}