package newyeargiftapp.models;

public class Chocolate extends Sweets {
    public Chocolate(double weight, double sugarContent) {
        super(weight, sugarContent);
    }

    @Override
    public String toString() {
        return "Шоколад: вага = " + getWeight() + ", вміст цукру = " + getSugarContent();
    }
}