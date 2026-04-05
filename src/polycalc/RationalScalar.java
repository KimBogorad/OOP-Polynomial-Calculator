package polycalc;
public class RationalScalar extends Scalar{
    private int numerator;
    private int denominator;
    
    public RationalScalar(int numerator,int denominator){
        int common = gcd(numerator, denominator);
        this.numerator = (denominator > 0 ? numerator : -numerator) / common;
        this.denominator = Math.abs(denominator) / common;
    }

    @Override
    public Scalar add(Scalar s){
        return s.addToRational(this);
    }

    @Override
    public Scalar mul(Scalar s){
        return s.mulRational(this);
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        int newNum = s.numerator * this.numerator ;
        int newDen = s.denominator * this.denominator;
        return new RationalScalar(newNum, newDen).reduce();
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        int newNum = this.numerator * s.getNumber();
        return new RationalScalar(newNum, this.denominator).reduce();
    }

    public Scalar reduce() {
        if (this.denominator == 1) {
            return new IntegerScalar(this.numerator);
        }
        return this;
    }

    @Override
    public Scalar addToRational(RationalScalar s) {
        int newNum = (s.numerator * this.denominator) + (this.numerator * s.denominator);
        int newDen = s.denominator * this.denominator;
        return new RationalScalar(newNum, newDen).reduce();
    }

    @Override
    public Scalar addToInteger(IntegerScalar s) {
        int newNum = this.numerator + (s.getNumber() * this.denominator);
        return new RationalScalar(newNum, this.denominator).reduce();
    }


    private int gcd(int numerator,int denominator){
        return Math.abs(denominator == 0 ? numerator : gcd(denominator, numerator % denominator));
    }

    @Override
    public Scalar neg(){
        return new RationalScalar(-this.numerator, this.denominator).reduce();
    }

    @Override 
    public Scalar power(int exponent){
        if (exponent < 0) 
            throw new IllegalArgumentException("exponent must be non-negative. Instead received: " + exponent);
        int newNum = (int) Math.pow(this.numerator, exponent);
        int newDen = (int) Math.pow(this.denominator, exponent);
        return new RationalScalar(newNum, newDen).reduce();
    }
    
    @Override
    public int sign(){
        return Integer.compare(this.numerator,0);
    }

    @Override
    public String toString(){
        return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        } 
        if (!(o instanceof RationalScalar)){
            return false;
        }
        RationalScalar other = (RationalScalar) o;
        return (this.numerator == other.numerator) && (this.denominator == other.denominator);
    }

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }
}