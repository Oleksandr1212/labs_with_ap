package weapons;

import droids.Droid;

public class PositiveWeapon extends Weapon {
    private int healthBoost;
    private int damageBoost;

    public PositiveWeapon() {
        super("Positive Weapon", 5); // Бонус шкоди
        this.healthBoost = 20;
        this.damageBoost = 5;
    }

    @Override
    public void use(Droid droid) {
        droid.setHealth(droid.getHealth() + this.healthBoost);
        droid.setDamage(droid.getDamage() + this.damageBoost);
        System.out.println(droid.getName() + " отримав покращення: +" + healthBoost + " HP і +" + damageBoost + " Damage.");
    }
}
