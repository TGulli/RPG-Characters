package com.experisno.tgulli.item;

import com.experisno.tgulli.hero.*;
import com.experisno.tgulli.item.armor.Armor;
import com.experisno.tgulli.item.armor.Cloth;
import com.experisno.tgulli.item.armor.Leather;
import com.experisno.tgulli.item.armor.Plate;
import com.experisno.tgulli.item.weapon.Magic;
import com.experisno.tgulli.item.weapon.Melee;
import com.experisno.tgulli.item.weapon.Range;
import com.experisno.tgulli.item.weapon.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testCreateMeleeWeapon(){
        Weapon melee = new Melee("Great Axe of the Exiled", 5);
        assertEquals(SlotType.WEAPON, melee.getParticularSlotType());
        assertEquals(5, melee.getLevel());
        assertEquals(25, melee.getBaseDamage());
    }

    @Test
    void testCreateMagicWeapon(){ // not from paper
        Weapon magic = new Magic("Magic weapon", 8);
        assertEquals(SlotType.WEAPON, magic.getParticularSlotType());
        assertEquals(8, magic.getLevel());
        assertEquals(25+(8*2), magic.getBaseDamage());
    }

    @Test
    void testCreateRangeWeapon(){
        Weapon range = new Range("Long Bow of the Lone Wolf", 10);
        assertEquals(SlotType.WEAPON, range.getParticularSlotType());
        assertEquals(10, range.getLevel());
        assertEquals(35, range.getBaseDamage());
    }

    @Test
    void testCreateClothArmor(){
        Armor cloth = new Cloth("Cloth leggings of the Magi", 10, SlotType.LEGS);
        assertEquals(SlotType.LEGS, cloth.getParticularSlotType());
        assertEquals(10, cloth.getLevel());
        assertEquals(36, cloth.getBonusHealth());
        assertEquals(6, cloth.getBonusDexterity());
        assertEquals(13, cloth.getBonusIntelligence());
    }

    @Test
    void testCreatePlateArmor(){
        Armor plate = new Plate("Plate chest of the Juggernaut", 15, SlotType.BODY);
        assertEquals(SlotType.BODY, plate.getParticularSlotType());
        assertEquals(15, plate.getLevel());
        assertEquals(210, plate.getBonusHealth());
        assertEquals(33, plate.getBonusStrength());
        assertEquals(16, plate.getBonusDexterity());
    }

    @Test
    void testCreateLeatherArmor(){ // Not from paper
        Armor leather = new Leather("Leather head armor", 4, SlotType.HEAD);
        assertEquals(SlotType.HEAD, leather.getParticularSlotType());
        assertEquals(4, leather.getLevel());
        assertEquals((int) ((20+(8*4))*0.8), leather.getBonusHealth());
        assertEquals((int) ((1+(1*4))*0.8), leather.getBonusStrength());
        assertEquals((int) ((3+(2*4))*0.8), leather.getBonusDexterity());
    }
}