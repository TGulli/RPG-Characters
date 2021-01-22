package com.experisno.tgulli.hero;

/*
 * This class is a sub class of hero, and when creating a Ranger, Ranger will have most of the function from the Hero class.  */
public class Ranger extends Hero{
    /*
     * Ranger constructor sends predefined values to the Hero constructor.
     * Health: 120, Strength: 5, Dexterity: 10, Intelligence: 2  */
    public Ranger() {
        super(120, 5, 10, 2);
    }

    /*
     * When a mage is leveling up, a ranger got increased their data
     * Health: +20, Strength +2, Dexterity +5, Intelligence +1  */
    protected void updateData(){
        baseHealth += 20;
        baseStrength += 2;
        baseDexterity += 5;
        baseIntelligence++;
        level++;
        updateNextLevelxp(); //updates the xp for a new level.
    }
}
