package newyeargiftapp.models;

public abstract class Sweets {
    private double weight;
    private double sugarContent;

    public Sweets(double weight, double sugarContent) {
        this.weight = weight;
        this.sugarContent = sugarContent;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    @Override
    public String toString() {
        return "Солодощі: вага = " + weight + ", вміст цукру = " + sugarContent;
    }
}
