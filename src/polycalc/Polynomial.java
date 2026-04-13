package polycalc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial  {
    private Collection<Monomial> monomials;

    public Polynomial() {
        this.monomials = new ArrayList<>();
    }
    
    public static Polynomial build(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new Polynomial(); 
        }
        Polynomial poly = new Polynomial();
        String[] parts = input.trim().split("\\s+");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            try {
                Scalar scalar;
                if (part.contains("/")) {
                    String[] ratio = part.split("/");
                    if (ratio.length != 2) {
                        throw new IllegalArgumentException("Invalid rational format: " + part);
                    }
                    int num = Integer.parseInt(ratio[0]);
                    int den = Integer.parseInt(ratio[1]);
                    scalar = new RationalScalar(num, den);
                }
                else {
                    scalar = new IntegerScalar(Integer.parseInt(part));
                }
                if (scalar.sign() != 0) {
                    poly.monomials.add(new Monomial(i, scalar));
                }
            }
            catch (NumberFormatException e) {
                System.err.println("Error: Invalid number format at index " + i + ": " + part);
            }
            catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return poly;
    }

    public Polynomial add(Polynomial p){
        Polynomial result = new Polynomial();
        Map<Integer, Monomial> combined = new TreeMap<>();
        for (Monomial m : this.monomials) {
            combined.put(m.getExponent(), m);
        }
        for (Monomial m : p.monomials) {
            combined.merge(m.getExponent(), m, Monomial::add);
        }
        for (Monomial m : combined.values()) {
            // saving space
            if (m.sign() != 0) {
                result.monomials.add(m);
            }
        }
        return result;
    }

    public Polynomial mul(Polynomial p) {
        Polynomial result = new Polynomial();
        Map<Integer, Monomial> combinedMap = new TreeMap<>();
        for (Monomial m1 : this.monomials) {
            for (Monomial m2 : p.monomials) {
                Monomial product = m1.mul(m2);
                combinedMap.merge(product.getExponent(), product, Monomial::add);
            }
        }
        for (Monomial m : combinedMap.values()) {
            // saving space
            if (m.sign() != 0) {
                result.monomials.add(m);
            }
        }
        return result;
    }

    public Scalar evaluate(Scalar S){
        Scalar result = new IntegerScalar(0);
        for ( Monomial m : this.monomials) {
            result = result.add(m.evaluate(S));
        }
        return result;
    }

    public Polynomial derivative(){
        Polynomial result = new Polynomial();
        for ( Monomial m : this.monomials) {
            if (m.getExponent() != 0) {
                result.monomials.add(m.derivative());
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) {return false;}
        if (this == o) {return true;} 
        if (o instanceof Monomial) {
            if (this.monomials.size() == 1){
                Monomial thisMonomial = this.monomials.iterator().next();
                return thisMonomial.equals(o);
            }
            return false;
        }
        if(!(o instanceof Polynomial)){return false;}
        Polynomial other = (Polynomial) o;
        boolean sameSize = this.monomials.size() == other.monomials.size();
        boolean containsAll = this.monomials.containsAll(other.monomials);
        return (sameSize && containsAll); 
    }

    public Collection<Monomial> getMonomials(){
        return this.monomials;
    }

    @Override
    public String toString(){
        String expression = "";
        if (monomials.isEmpty()){
            return "0";
        }
        boolean isFirst = true;
        for (Monomial m: monomials){
            if(!isFirst && m.getCoefficient().sign() > 0){
                expression += "+";
            }
            expression += m.toString();
            isFirst = false;
        }
        return expression;
    }
}