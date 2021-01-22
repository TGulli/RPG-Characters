package com.experisno.tgulli.item.armor;

import com.experisno.tgulli.hero.SlotType;
import com.experisno.tgulli.item.Item;

/* An armor is an abstract class of a given armor, which extends a item.
 * This class has some functions for all the armor class made as subclasses.
 * An armor class is a parent class of a cloth, leather or plate class.*/
public abstract class Armor extends Item {
    protected int bonusHealth;
    protected int bonusStrength;
    protected int bonusDexterity;
    protected int bonusIntelligence;

    /* An armor has name, level and particular slot type as parameters in the constructor, and pass this values to
     * the item constructor.*/
    public Armor(String name, int level, SlotType particularSlotType) {
        super(name, level, particularSlotType);
    }

    /* Scaling the bonus down to 80% if it is head or down to 60% if it is legs.*/
    protected void scaleBonus() {
        double scaling = 1;

        if (particularSlotType == SlotType.BODY){
            return;
        } else if (particularSlotType == SlotType.HEAD){
            scaling = 0.8;
        } else if (particularSlotType == SlotType.LEGS){
            scaling = 0.6;
        }

        bonusHealth = (int) ((double)bonusHealth * scaling);
        bonusStrength *= scaling;
        bonusDexterity *= scaling;
        bonusIntelligence *= scaling;

    }

    public int getBonusHealth() {
        return bonusHealth;
    }

    public int getBonusStrength() {
        return bonusStrength;
    }

    public int getBonusDexterity() {
        return bonusDexterity;
    }

    public int getBonusIntelligence() {
        return bonusIntelligence;
    }

    /* Returns the details for an armor as a string.*/
    public String getDetailsAsString(){
        String str = "Item stats for: " + name;
        if (this instanceof Cloth){
            str += "\nArmor type: Cloth";
        } else if (this instanceof Plate){
            str += "\nArmor type: Plate";
        } else if (this instanceof Leather){
            str += "\nArmor type: Leather";
        }
        str += "\nSlot: " + particularSlotType;
        str += "\nArmor level: " + level;
        str += "\nBonus HP: " + bonusHealth;
        str += "\nBonus STR: " + bonusStrength;
        str += "\nBonus Dex: " + bonusDexterity;
        str += "\nBonus Int: " + bonusIntelligence;
        return str + "\n";
    }
}
