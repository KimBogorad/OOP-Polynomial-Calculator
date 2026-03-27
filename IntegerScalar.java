public class IntegerScalar extends Scalar {
    private int number;

    //methods:
    public IntegerScalar(int number) {
        this.number = number;
    }

    public Scalar add(Scalar s) {
        s.addToInteger(this.number);
    }

    public Scalar mul(Scalar s) {
        return new IntegerScalar(this.number); \\placeholder!!
    }

    public Scalar neg() {
        return IntegerScalar(-this.number);
    }

    public Scalar power(int exponent) {
        return IntegerScalar(Math.pow(this.number, exponent));
    }

    public int sign()
    {
        return this.number >= 0 ? (this.number == 0 ? 0 : 1) : -1;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!o.instanceOf(IntegerScalar)) return false;
        IntegerScalar other = IntegerScalar(o);
        return this.number = other.number;
    }
    @Override
    public String toString() {
        String s = String.valueOf(this.number);
    }

    //helper methods:
    public Scalar addToInteger(int number) {
        return new Scalar(this.number + number);
    }
    public Scalar addToRational(int numerator, int denominator) {
        return new Scalar((this.number * denominator) + numerator, denominator);
    }
}

