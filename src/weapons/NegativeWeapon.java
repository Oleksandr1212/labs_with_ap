package weapons;

import droids.Droid;

public class NegativeWeapon extends Weapon {
    private int healthReduction;
    private int damageReduction;

    public NegativeWeapon() {
        super("Negative Weapon", -5); // Зменшення шкоди
        this.healthReduction = 20;
        this.damageReduction = 5;
    }

    @Override
    public void use(Droid droid) {
        droid.setHealth(droid.getHealth() - this.healthReduction);
        droid.setDamage(droid.getDamage() - this.damageReduction);
        System.out.println(droid.getName() + " отримав погіршення: -" + healthReduction + " HP і -" + damageReduction + " Damage.");
    }
}
