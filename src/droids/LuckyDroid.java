package droids;

import java.util.Random;

public class LuckyDroid extends Droid {
    private static final double LUCKY_CHANCE = 0.1;

    public LuckyDroid(String name) {
        super(name, 100, 5); // Базові параметри здоров'я та шкоди
    }

    @Override
    public void attack(Droid opponent) {
        Random rand = new Random();
        if (rand.nextDouble() < LUCKY_CHANCE) {
            System.out.println(this.name + " використовує свою удачу і миттєво вбиває противника!");
            opponent.setHealth(0); // Встановлюємо здоров'я противника на 0
        } else {
            System.out.println(this.name + " атакує звичайним ударом.");
            // Викликаємо атаку батьківського класу
            opponent.takeDamage(this.getDamage());
            System.out.println(this.name + ": можливо, пощастить іншим разом.");
        }
    }

    @Override
    public String toString() {
        return "LuckyDroid: " + name + ", Здоров'я: " + health + ", Шкода: " + damage;
    }
}
