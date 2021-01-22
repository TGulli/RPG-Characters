package com.experisno.tgulli.hero;
/*
 * This class is a sub class of hero, and when creating a Warrior, Warrior will have most of the function from the Hero class.  */
public class Warrior extends Hero{
    /*
     * Warrior constructor sends predefined values to the Hero constructor.
     * Health: 150, Strength: 10, Dexterity: 3, Intelligence: 1  */
    public Warrior() {
        super(150, 10, 3, 1);
    }

    /*
     * When a Warrior is leveling up, a Warrior got increased their data
     * Health: +30, Strength +5, Dexterity +2, Intelligence +1  */
    protected void updateData(){
        baseHealth += 30;
        baseStrength += 5;
        baseDexterity += 2;
        baseIntelligence++;
        level++;
        updateNextLevelxp(); //updates the xp for a new level.
    }

}
