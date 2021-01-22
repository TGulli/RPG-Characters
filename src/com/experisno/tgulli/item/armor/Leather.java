package com.experisno.tgulli.item.armor;

import com.experisno.tgulli.hero.SlotType;

/* A leather armor with the name, level and particular slot place as parameter.
 * The constructor sends the data to the parent class Armor.
 * It also updates the data based on the given level.*/public class Leather extends Armor {
    public Leather(String name, int level, SlotType particularSlotType) {
        super(name, level, particularSlotType);
        updateData();
    }

    /* Updates the baseDamage based on the level.*/
    protected void updateData(){
        bonusHealth = 20 + 8*level;
        bonusDexterity = 3 + 2*level;
        bonusStrength = 1 + level;
        scaleBonus();
    }
}
