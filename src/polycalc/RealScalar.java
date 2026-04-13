package polycalc;

/* 
changes relative to hw1:
created a new class to support the expansion of the system to real numbers.
*/
public class RealScalar extends Scalar {
    private double number;

    public RealScalar(double number) {
        this.number = number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addToReal(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulReal(this);
    }

    @Override
    public Scalar neg() {
        return new RealScalar(-this.number);
    }

    @Override
    public Scalar power(int exponent) {
        if (exponent < 0) 
            throw new IllegalArgumentException("exponent must be non-negative. Instead received: " + exponent);
        return new RealScalar((double)Math.pow(this.number, exponent));
    }

    @Override
    public int sign()
    {
        return Double.compare(this.number, 0);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) {return false;}
        if (this == o) {return true;}
        if(o instanceof IntegerScalar) {
            return this.number == ((IntegerScalar)o).getNumber();
        }
        if (o instanceof RationalScalar) {
            int num = ((RationalScalar)o).getNumerator();
            int den = ((RationalScalar)o).getDenominator();
            return (this.number == (double)num/den); //עובד עם דאבל ואינט
        }
        if (o instanceof RealScalar) {
            RealScalar other = (RealScalar)o;
            return this.number == other.number;
        }
        return false;  
    }

    @Override
    public String toString() {
        return Double.toString(this.number);
    }
    
    public double getNumber(){
        return this.number;
    }

    @Override
    public Scalar addToInteger(IntegerScalar s) {
        return new RealScalar(this.number + s.getNumber());
    }

    @Override
    public Scalar addToRational(RationalScalar s) {
        double newNum = this.number + (double)s.getNumerator()/s.getDenominator();
        return new RealScalar(newNum);
    }

    @Override
    public Scalar addToReal(RealScalar s) {
        return new RealScalar(this.number + s.number);
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new RealScalar(this.number * s.getNumber());
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        return new RealScalar(this.number * ((double)s.getNumerator()/s.getDenominator()));
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        return new RealScalar(this.number * s.number);
    }
}

