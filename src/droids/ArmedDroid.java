package droids;

import weapons.Weapon;

public class ArmedDroid extends Droid {
    private Weapon weapon;

    public ArmedDroid(String name, Weapon weapon) {
        super(name, 100, 20); // Базові параметри: здоров'я = 100, шкода = 20
        this.weapon = weapon;
    }

    @Override
    public void attack(Droid opponent) {
        int totalDamage = this.damage + this.weapon.getDamageBonus();
        System.out.println(this.name + " атакує " + opponent.getName() + " і завдає " + totalDamage + " шкоди.");
        opponent.takeDamage(totalDamage);

        // Використання зброї після атаки
        weapon.use(this);
    }

    @Override
    public String toString() {
        return "Озброєний дроїд: " + name + ", Здоров'я: " + health + ", Шкода: " + damage + ", Зброя: " + weapon;
    }
}
