package droids;

public class BattleDroid extends Droid {

    public BattleDroid(String name) {
        super(name, 100, 25); // Базові параметри: здоров'я = 100, шкода = 25
    }

    @Override
    public void attack(Droid opponent) {
        System.out.println(name + " атакує " + opponent.getName() + " і завдає " + damage + " шкоди.");
        opponent.takeDamage(damage);
    }

    @Override
    public String toString() {
        return "Бойовий дроїд: " + name + ", Здоров'я: " + health + ", Шкода: " + damage;
    }
}
