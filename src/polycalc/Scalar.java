package polycalc;

/* 
changes relative to hw1:
expanded the interface to expand double-dispatch logic to the new type - RealScalar.
*/
public abstract class Scalar {
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s); 
    public abstract Scalar neg(); 
    public abstract Scalar power(int exponent);
    public abstract int sign();

    @Override
    public abstract boolean equals(Object o);
    @Override
    public abstract String toString();

    //helper methods:
    public abstract Scalar addToInteger(IntegerScalar s);
    public abstract Scalar addToRational(RationalScalar s);
    public abstract Scalar addToReal(RealScalar s);
    public abstract Scalar mulInteger(IntegerScalar s);
    public abstract Scalar mulRational(RationalScalar s);
    public abstract Scalar mulReal(RealScalar s);
}