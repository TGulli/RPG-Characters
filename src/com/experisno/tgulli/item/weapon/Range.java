package com.experisno.tgulli.item.weapon;

/*A range weapon with the name and level as parameter. The constructor sends the data to the parent class Weapon.
* It also updates the data based on the given level.*/
public class Range extends Weapon {
    public Range(String name, int level) {
        super(name, level);
        updateData();
    }

    /* Updates the baseDamage based on the level.*/
    protected void updateData() {
        baseDamage = 5 + (level * 3);
    }
}
