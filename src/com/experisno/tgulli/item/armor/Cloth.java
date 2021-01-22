package com.experisno.tgulli.item.armor;

import com.experisno.tgulli.hero.SlotType;

/* A cloth armor with the name, level and particular slot place as parameter.
 * The constructor sends the data to the parent class Armor.
 * It also updates the data based on the given level.*/
public class Cloth extends Armor {
    public Cloth(String name, int level, SlotType particularSlotType) {
        super(name, level, particularSlotType);
        updateData();
    }

    /* Updates the baseDamage based on the level.*/
    protected void updateData(){
        bonusHealth = 10 + 5*level;
        bonusIntelligence = 3 + 2*level;
        bonusDexterity = 1 + level;
        scaleBonus();
    }
}
