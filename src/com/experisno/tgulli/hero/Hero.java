package com.experisno.tgulli.hero;

import com.experisno.tgulli.item.Item;
import com.experisno.tgulli.item.armor.Armor;
import com.experisno.tgulli.item.weapon.Magic;
import com.experisno.tgulli.item.weapon.Melee;
import com.experisno.tgulli.item.weapon.Range;
import com.experisno.tgulli.item.weapon.Weapon;

import java.util.HashMap;
import java.util.Map;

/*
* Abstract class for all the hero types. This class has the most functionality for a hero, and says which functions
* the subclasses must have.*/
public abstract class Hero {
    protected int baseHealth;
    protected int baseStrength;
    protected int baseDexterity;
    protected int baseIntelligence;
    protected int level;
    private int xpForNextLevel;
    private int xp;
    // Stores the items to a hero. Maximum 4 items of a slot Type: weapon, body, head and legs.
    private final HashMap<SlotType, Item> items = new HashMap<>();

    /*
    * Constructor creates a hero with the given stats. Initially the level is set to 1, and xp to 0.
    * To level up, the xp must be bigger than xpForNextLevel, which is initially 100, and increases with 10% for each level.*/
    public Hero(int baseHealth, int baseStrength, int baseDexterity, int baseIntelligence) {
        this.baseHealth = baseHealth;
        this.baseStrength = baseStrength;
        this.baseDexterity = baseDexterity;
        this.baseIntelligence = baseIntelligence;

        xpForNextLevel = 100;
        level = 1;
        xp = 0;
    }

    public int getLevel(){
        return level;
    }

    /*
    * This function adds a item to a slot. If it is already a slot at the given place, the function replaces the item.*/
    public void addItem(Item item){
        items.put(item.getParticularSlotType(), item);
    }

    /*
    * Removes a item at a slot. If no item is at the slot, then the function just ignore the removing call.*/
    public void removeItem(Item item){
        items.remove(item.getParticularSlotType());
    }

    /*
     * Increases the criteria for next level with 10% */
    protected void updateNextLevelxp(){
        xpForNextLevel *= 1.1;
    }

    /*
     * Each subclass of Hero must have update data function, that updates the data if new level. */
    protected abstract void updateData();

    /*
    * Adds xp to a hero. Also checks if xp is big enough to level up.*/
    public void addXp(int addXp){
        xp += addXp;
        while (xp >= xpForNextLevel){
            xp -= xpForNextLevel;
            updateData();
        }
    }

    /*
    * Returns the xp criteria for leveling up to the next level*/
    public int getXpForNextLevel(){
        return xpForNextLevel;
    }

    /*
     * Returns the health, including the bonus health from items, if the hero has items that increases the health.*/
    public int getHealth(){
        int total = baseHealth;
        for (Map.Entry<SlotType, Item> set : items.entrySet()) {
            if (!set.getKey().equals(SlotType.WEAPON)){
                total += ((Armor)set.getValue()).getBonusHealth();
            }
        }
        return total;
    }

    /*
     * Returns the strength, including the bonus strength from items, if the hero has items that increases the strength.*/
    public int getStrength(){
        int total = baseStrength;
        for (Map.Entry<SlotType, Item> set : items.entrySet()) {
            if (!set.getKey().equals(SlotType.WEAPON)) {
                total += ((Armor) set.getValue()).getBonusStrength();
            }
        }
        return total;
    }

    /*
     * Returns the dexterity, including the bonus dexterity from items, if the hero has items that increases the dexterity.*/
    public int getDexterity(){
        int total = baseDexterity;
        for (Map.Entry<SlotType, Item> set : items.entrySet()) {
            if (!set.getKey().equals(SlotType.WEAPON)) {
                total += ((Armor) set.getValue()).getBonusDexterity();
            }
        }
        return total;
    }

    /*
     * Returns the intelligence, including the bonus intelligence from items, if the hero has items that increases the intelligence.*/
    public int getIntelligence(){
        int total = baseIntelligence;
        for (Map.Entry<SlotType, Item> set : items.entrySet()) {
            if (!set.getKey().equals(SlotType.WEAPON)) {
                total += ((Armor) set.getValue()).getBonusIntelligence();
            }
        }
        return total;
    }

    /*
     * Returns the damage the hero can make. If the hero has no weapon, then the damage is 0.
     * A weapon has a base damage, but a hero can have more damage if:
     * It is a magic weapon, the bonus damage is the intelligence to the hero multiplied with 3
     * It is a melee weapon, the bonus damage is the intelligence to the hero multiplied with 1.5
     * It is a range weapon, the bonus damage is the intelligence to the hero multiplied with 2  */
    public int getDamage(){
        if (!items.containsKey(SlotType.WEAPON)){
            return 0;
        }
        Weapon weapon = (Weapon) items.get(SlotType.WEAPON);
        int damage = weapon.getBaseDamage();

        if (weapon instanceof Magic){
            damage += getIntelligence()*3;
        } else if (weapon instanceof Melee){
            damage += getStrength()*1.5;
        } else if (weapon instanceof Range){
            damage += getDexterity()*2;
        }
        return damage;
    }

    /*
    * returns the stats/ the details to the hero as a string.*/
    public String getDetailsAsString(){
        String str = "";
        if (this instanceof Warrior){
            str += "Warrior details:";
        } else if (this instanceof Ranger){
            str += "Ranger details:";
        } else if (this instanceof Mage){
            str += "Mage details:";
        }
        str += "\nHP: " + getHealth();
        str += "\nStr: " + getStrength();
        str += "\nDex: " + getDexterity();
        str += "\nInt: " + getIntelligence();
        str += "\nLevel: " + level;
        if (items.containsKey(SlotType.WEAPON)){
            str += "\nDamage: " + getDamage();
        }
        str += "\nXp: " + xp;
        str += "\nXp to next: " + xpForNextLevel;
        return str + "\n";
    }
}
