import java.util.*;
public class Main {

    public static void main(String[] args) {
        ArrayList<Double> var = new ArrayList<>();
        ArrayList<Integer> pow = new ArrayList<>();
        var.add(3.);
        var.add(12.);
        var.add(4.);
        pow.add(2);
        pow.add(1);
        pow.add(0);
        ArrayList<Double> var2 = new ArrayList<>();
        ArrayList<Integer> pow2 = new ArrayList<>();
        var2.add(10.);
        var2.add(2.);
        var2.add(-41.);
        pow2.add(3);
        pow2.add(1);
        pow2.add(0);
        Polynom poly = new Polynom(var, pow);
        Polynom poly2 = new Polynom(var2, pow2);
        poly.printPoly();
        poly2.printPoly();
        Polynom poly3 = poly.minus(poly2);
        poly3.printPoly();
    }
}
