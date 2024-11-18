package newyeargiftapp.models;

public class Candy extends Sweets {
    public Candy(double weight, double sugarContent) {
        super(weight, sugarContent);
    }

    @Override
    public String toString() {
        return "Цукерка: вага = " + getWeight() + ", вміст цукру = " + getSugarContent();
    }
}