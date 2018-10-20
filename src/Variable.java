public class Variable {
    private double _variable;
    private int _power;

    public Variable(double variable, int power){
        setPower(power);
        setVariable(variable);
    }

    public int getPower() {
        return _power;
    }

    public double getVariable() {
        return _variable;
    }

    public void setPower(int _power) {
        this._power = _power;
    }

    public void setVariable(double _variable) {
        this._variable = _variable;
    }

    public void addToVar(double var){
        this._variable += var;
    }

    public void subtractFromVar(double var){
        this._variable -= var;
    }

    public void derivateVar(){
        if (this.getPower() > 0) {
            double pow = (double) this.getPower();
            this.setVariable(this.getVariable() * pow);
            this.setPower(this.getPower() - 1);
        }
        if (this.getPower() == 0){
            this.setVariable(0);
        }
    }

    public void printVar(){
        if (this.getVariable() == 0)
            return;

        if (this.getPower() > 0) {
            if (this.getVariable() > 0)
                System.out.printf("+%.2fx^%d ", this.getVariable(), this.getPower());
            else
                System.out.printf("%.2fx^%d ",this.getVariable(),this.getPower());
        }
        else {
            if (this.getVariable() > 0)
                System.out.printf("+%.2f ", this.getVariable());
            else
                System.out.printf("%.2f ", this.getVariable());
        }
    }
}
