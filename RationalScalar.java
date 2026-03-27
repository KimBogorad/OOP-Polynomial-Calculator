public class RationalScalar extends Scalar{
    private int numerator;
    private int denominator;
    //Lehosid Banaim lefi tzorech
    RationalScalar(int numerator,int denominator){
        int _gcd = gcd(numerator,denominator)
        if (denominator == 0) {
            throw new ExceptionType("Denominator is 0");
        }
        else if (numerator * denominator > 0){
            this.numerator = Math.abs(numerator/_gcd);
        }
        else{
            this.numerator = -Math.abs(numerator/_gcd);
        }
        this.denominator = Math.abs(denominator/_gcd);
    }

    public Scalar add(Scalar s){

    }
    private gcd(int numerator,int denominator){
        return Math.abs(denominator == 0 ? numerator : gcd(denominator, numerator % denominator));
    } 
    public Scalar mul(Scalar s)
    public Scalar neg(){
        return RationalScalar(-this.numerator, this.denominator);
    } 
    public Scalar power(int exponent){
        return RationalScalar(Math.Pow(this.numerator,exponent), Math.Pow(this.denominator,exponent));
    }
    public int sign(){
        return Integer.Compare(this.numerator,0);
    }

}