package droids;

public class MedicDroid extends Droid {
    private int healAmount; // Кількість здоров'я, яку може відновити медичний дроїд

    public MedicDroid(String name) {
        super(name, 80, 10); // Менше здоров'я і шкоди, ніж у бойового дроїда
        this.healAmount = 30; // Відновлює 30 одиниць здоров'я
    }

    public void heal(Droid ally) {
        if (ally.isAlive()) {
            ally.setHealth(ally.getHealth() + healAmount);
            System.out.println(this.name + " вилікував " + ally.getName() + " на " + healAmount + " HP.");
        } else {
            System.out.println(ally.getName() + " вже мертвий і не може бути вилікуваний.");
        }
    }

    @Override
    public void attack(Droid opponent) {
        System.out.println(this.name + " атакує " + opponent.getName() + " і завдає " + this.damage + " шкоди.");
        opponent.takeDamage(this.damage);
    }

    @Override
    public String toString() {
        return "Медичний дроїд: " + name + ", Здоров'я: " + health + ", Шкода: " + damage + ", Лікування: " + healAmount;
    }
}
