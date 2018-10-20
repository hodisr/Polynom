/*
    A class for the Polynom object
 */
import java.util.ArrayList;
import java.util.Set;
import java.util.Hashtable;


public class Polynom implements Comparable<Polynom>{
    private Hashtable<Integer, Variable> _polynom = new Hashtable<>(); // Holds the integers and Variables in Hashmap for quick get of the items
    private int _maxPower;

    // Class initializer
    public Polynom(ArrayList<Double> variables, ArrayList<Integer> power){
        this._maxPower = 0;
        this.setPolynom(variables, power);
    }

    // Class blank initializer
    public Polynom(){
        this._maxPower = 0;
    }

    //Getters and setter for the class variabls
    public int getMaxPower(){
        return this._maxPower;
    }

    public void setMaxPower(int pow){
        this._maxPower = pow;
    }

    private void setPolynom(ArrayList<Double> variables, ArrayList<Integer> power){
        for (int i=0; i<power.size(); i++) {
            Variable curr = new Variable(variables.get(i), power.get(i));
            this._polynom.put(curr.getPower(), curr);
            if (this._maxPower < curr.getPower())
                this._maxPower = curr.getPower();
        }
    }
    // Complete compareTo method
    public int compareTo(Polynom other){
        Polynom sub = this.minus(other);
        if (sub._polynom.isEmpty())
            return 0;
        else{
            if (this.getMaxPower() == other.getMaxPower()){

            }
            return 0;
        }
    }

    public void pp(){
        Set<Integer> keys = this._polynom.keySet();
        for (Integer key : keys) {

        }
    }
    public void printPoly(){
        if (this._polynom.isEmpty()){
            System.out.println("Empty Poly");
            return;
        }

        int pow = this._maxPower;
        Variable curr;
        while (pow >= 0){
            if (this._polynom.containsKey(pow)){
                curr = this._polynom.get(pow);
                curr.printVar();
            }
            pow--;
        }
        System.out.println();

    }
    private void addVariable(Variable var) {
        if (this._polynom.containsKey(var.getPower())) {
            var.addToVar(this._polynom.get(var.getPower()).getVariable());
            if (var.getVariable() == 0)
                this._polynom.remove(var.getPower());
            else
                this._polynom.replace(var.getPower(), var);
        }
        else {
            this._polynom.put(var.getPower(), var);
        }
    }

    private void subtractFromVariable(Variable var){
        if (this._polynom.containsKey(var.getPower())) {
            var.subtractFromVar(this._polynom.get(var.getPower()).getVariable());
            if (var.getVariable() == 0)
                this._polynom.remove(var.getPower());
            else
                this._polynom.replace(var.getPower(), var);
        }
        else {
            var.setVariable(var.getVariable() * -1);
            this._polynom.put(var.getPower(), var);
        }
    }

    public Polynom plus(Polynom other){
        Set<Integer> keys = other._polynom.keySet();
        for (Integer key : keys) {
            this.addVariable(other._polynom.get(key));
        }
        return this;
    }
    
    public Polynom minus(Polynom other){
        Set<Integer> keys = other._polynom.keySet();
        for (Integer key : keys) {
            this.subtractFromVariable(other._polynom.get(key));
        }
        return this;
    }

    public Polynom derivate(){
        Polynom derPoly = new Polynom();
        Set<Integer> keys = this._polynom.keySet();
        Variable curr;
        for (Integer key : keys){
            curr = this._polynom.get(key);
            curr.derivateVar();
            if (curr.getVariable() != 0){
                if (curr.getPower() > derPoly.getMaxPower())
                    derPoly.setMaxPower(curr.getPower());
                derPoly._polynom.put(curr.getPower(), curr);
            }
        }
        return derPoly;
    }

}
