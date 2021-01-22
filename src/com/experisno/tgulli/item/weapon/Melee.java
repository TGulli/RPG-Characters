package com.experisno.tgulli.item.weapon;

/*A melee weapon with the name and level as parameter. The constructor sends the data to the parent class Weapon.
 * It also updates the data based on the given level.*/
public class Melee extends Weapon {
    public Melee(String name, int level) {
        super(name, level);
        updateData();
    }

    /* Updates the baseDamage based on the level.*/
    protected void updateData() {
        baseDamage = 15 + (level * 2);
    }
}
