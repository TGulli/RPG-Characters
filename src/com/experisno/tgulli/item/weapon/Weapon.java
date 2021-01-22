package com.experisno.tgulli.item.weapon;

import com.experisno.tgulli.hero.SlotType;
import com.experisno.tgulli.item.Item;

/* A weapon is an abstract class of a given weapon, which extends a item.
* This class has some functions for all the weapon class made as subclasses.
* A weapon class is a parent class for Magic, Melee or Range class.*/
public abstract class Weapon extends Item {
    protected int baseDamage;

    /* A weapon has a name and a level, and takes that as parameters in the constructor.
    * When all weapons has slotType weapon, this class creates a item with the given name and level, and weapon as slottype.*/
    public Weapon(String name, int level) {
        super(name, level, SlotType.WEAPON);
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    /* Returns the details for a weapon as a string.*/
    public String getDetailsAsString(){
        String str = "Item stats for: " + name;
        if (this instanceof Magic){
            str += "\nWeapon type: Magic";
        } else if (this instanceof Melee){
            str += "\nWeapon type: Melee";
        } else if (this instanceof Range){
            str += "\nWeapon type: Range";
        }
        str += "\nWeapon level: " + level;
        str += "\nDamage: " + baseDamage;
        return str + "\n";
    }
}
