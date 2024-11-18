package weapons;

import droids.Droid;

public abstract class Weapon {
    protected String name;
    protected int damageBonus;

    public Weapon(String name, int damageBonus) {
        this.name = name;
        this.damageBonus = damageBonus;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public abstract void use(Droid droid);

    @Override
    public String toString() {
        return name;
    }
}
