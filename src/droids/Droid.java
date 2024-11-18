package droids;

public abstract class Droid {
    protected String name; // Назва дроїда
    protected int health;  // Здоров'я
    protected int damage;  // Шкода

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        System.out.println(name + " отримав " + amount + " шкоди. Здоров'я: " + health);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    // Абстрактний метод для атаки
    public abstract void attack(Droid opponent);
}
