package com.experisno.tgulli.hero;

import com.experisno.tgulli.item.armor.Armor;
import com.experisno.tgulli.item.armor.Plate;
import com.experisno.tgulli.item.weapon.Melee;
import com.experisno.tgulli.item.weapon.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void testCreateWarrior(){
        int xp = 1140;
        Warrior war = new Warrior();
        war.addXp(xp);
        assertEquals(9, war.getLevel());
        assertEquals(390, war.getHealth());
        assertEquals(50, war.getStrength());
        assertEquals(19, war.getDexterity());
        assertEquals(9, war.getIntelligence());
    }

    @Test
    void testCreateMage(){ // Almost from paper
        int xp = 1400;
        Mage mage = new Mage();
        mage.addXp(xp);
        assertEquals(10, mage.getLevel());
        assertEquals(235, mage.getHealth());
        assertEquals(2+1*(mage.getLevel()-1), mage.getStrength());
        assertEquals(3+2*(mage.getLevel()-1), mage.getDexterity());
        assertEquals(10+5*(mage.getLevel()-1), mage.getIntelligence());
    }

    @Test
    void testCreateRanger(){
        int xp = 2000;
        Ranger ranger = new Ranger();
        ranger.addXp(xp);
        assertEquals(12, ranger.getLevel());
        assertEquals(340, ranger.getHealth());
        assertEquals(27, ranger.getStrength());
        assertEquals(65, ranger.getDexterity());
        assertEquals(13, ranger.getIntelligence());
    }

    @Test
    void testAddItemsToHero(){
        Warrior war = new Warrior();
        war.addXp(1140);
        Weapon melee = new Melee("Great Axe of the Exiled", 5);
        Armor plate = new Plate("Plate chest of the Juggernaut", 5, SlotType.BODY);
        war.addItem(melee);
        war.addItem(plate);
        assertEquals(9, war.getLevel());
        assertEquals(480, war.getHealth());
        assertEquals(63, war.getStrength());
        assertEquals(25, war.getDexterity());
        assertEquals(9, war.getIntelligence());
        assertEquals(119, war.getDamage());
    }

    @Test
    void testRemoveItemsFromHero(){
        Warrior war = new Warrior();
        war.addXp(1140);
        Weapon melee = new Melee("Great Axe of the Exiled", 5);
        war.addItem(melee);
        war.removeItem(melee);
        assertEquals(0, war.getDamage());
    }

}