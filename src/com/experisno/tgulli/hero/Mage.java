package com.experisno.tgulli.hero;

/*
* This class is a sub class of hero, and when creating a Mage, Mage will have most of the function from the Hero class.  */
public class Mage extends Hero{
    /*
    * Mage constructor sends predefined values to the Hero constructor.
    * Health: 100, Strength: 2, Dexterity: 1, Intelligence: 10  */
    public Mage() {
        super(100, 2, 3, 10);
    }

    /*
    * When a mage is leveling up, a mage got increased their data
    * Health: +15, Strength +1, Dexterity +2, Intelligence +5  */
    protected void updateData(){
        baseHealth += 15;
        baseStrength += 1;
        baseDexterity += 2;
        baseIntelligence += 5;
        level++;
        updateNextLevelxp(); //updates the xp for a new level.
    }
}
