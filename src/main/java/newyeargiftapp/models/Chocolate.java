package newyeargiftapp.models;

public class Chocolate extends Sweets {
    public Chocolate(double weight, double sugarContent) {
        super(weight, sugarContent);
    }

    @Override
    public String toString() {
        return "Chocolate{weight=" + getWeight() + ", sugarContent=" + getSugarContent() + "}";
    }
}
