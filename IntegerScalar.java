public class IntegerScalar extends Scalar {
    private int number;

    public IntegerScalar(int number) {
        this.number = number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addToInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(-this.number);
    }

    @Override
    public Scalar power(int exponent) {
        return new IntegerScalar((int)Math.pow(this.number, exponent));
    }

    @Override
    public int sign()
    {
        return Integer.compare(this.number, 0);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o){
            return true;
        }
        if (!(o instanceof IntegerScalar)){
            return false;
        }
        IntegerScalar other = (IntegerScalar)o;
        return this.number == other.number;
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }

    @Override
    public Scalar addToInteger(IntegerScalar s) {
        return new IntegerScalar(this.number + s.number);
    }

    @Override
    public Scalar addToRational(RationalScalar s) {
        return new RationalScalar((this.number * s.getDenominator()) + s.getNumerator(), s.getDenominator()).reduce();
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new IntegerScalar(this.number * s.number);
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        return new RationalScalar(this.number * s.getNumerator(), s.getDenominator()).reduce();
    }
    
    public int getNumber(){
        return this.number;
    }
}

