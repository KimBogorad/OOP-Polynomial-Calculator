package polycalc;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    //constructor:

    public Monomial(int exponent, Scalar coefficient) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative. Instead received: " + exponent);
        }
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    //class methods:

    public Monomial add(Monomial m) {
        if(this.exponent != m.exponent) {
            throw new IllegalArgumentException("Monomials must be of same exponent. Instead recieved: " + this.exponent + ", " + m.exponent);
        }
        Scalar sum = this.coefficient.add(m.coefficient);
        return new Monomial(exponent, sum);
    }

    public Monomial mul(Monomial m) {
        int new_ex = this.exponent + m.exponent;
        Scalar new_co = this.coefficient.mul(m.coefficient);
        return new Monomial(new_ex, new_co);
    }

    public Scalar evaluate(Scalar s) {
        Scalar res = s.power(this.exponent);
        res = res.mul(this.coefficient);
        return res;
    }

    public Monomial derivative() {
        int new_ex = Math.max(this.exponent-1, 0);
        Scalar exp = new IntegerScalar(this.exponent); 
        Scalar new_co = this.coefficient.mul(exp); 
        return new Monomial(new_ex, new_co);
    }

    public int sign() {
        return this.coefficient.sign();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {return false;}
        if(this == o) {return true;}
        if (!(o instanceof Monomial)) {return false;}
        return (((Monomial)o).exponent == this.exponent && ((Monomial)o).coefficient.equals(this.coefficient));
    }

    @Override
    public String toString() {
        String s = "";
        if (this.coefficient.equals(new IntegerScalar(0))) {
            return s;
        }
        if (this.exponent == 0) {
            return this.coefficient.toString();
        }
        if (this.coefficient.equals(new IntegerScalar(-1))) {
            s += "-";
        }
        else if (!(this.coefficient.equals(new IntegerScalar(1)))) {
            s += this.coefficient.toString();
            if(s.contains("/"))
                s = "(" + s + ")";
        }
        s += (this.exponent == 1) ? "x" : "x^" + this.exponent;
        return s;
    }
}
