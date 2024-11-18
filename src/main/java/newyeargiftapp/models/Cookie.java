package newyeargiftapp.models;

public class Cookie extends Sweets {

    public Cookie(double weight, double sugarContent) {
        super(weight, sugarContent);
    }

    @Override
    public String toString() {
        return "Печиво: вага = " + getWeight() + ", вміст цукру = " + getSugarContent();
    }
}
