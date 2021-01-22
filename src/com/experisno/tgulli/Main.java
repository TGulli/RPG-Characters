package com.experisno.tgulli;

import com.experisno.tgulli.hero.Mage;
import com.experisno.tgulli.hero.Ranger;
import com.experisno.tgulli.hero.SlotType;
import com.experisno.tgulli.hero.Warrior;
import com.experisno.tgulli.item.armor.Armor;
import com.experisno.tgulli.item.armor.Cloth;
import com.experisno.tgulli.item.armor.Leather;
import com.experisno.tgulli.item.armor.Plate;
import com.experisno.tgulli.item.weapon.Magic;
import com.experisno.tgulli.item.weapon.Melee;
import com.experisno.tgulli.item.weapon.Range;
import com.experisno.tgulli.item.weapon.Weapon;

public class Main {

    public static void main(String[] args) {
//        testHeros();
//        testItems();
//        testHeroWithItem();
        demonstration();
    }

    public static void demonstration(){
        // Creates a warrior character
        System.out.println("Creating a warrior character:");
        Warrior war = new Warrior();
        war.addXp(1140);
        System.out.println(war.getDetailsAsString());

        // Creates a mage character
        System.out.println("Creating a mage character:");
        Mage mag = new Mage();
        mag.addXp(1400);
        System.out.println(mag.getDetailsAsString());

        // Creates a ranger character
        System.out.println("Creating a ranger character:");
        Ranger ran = new Ranger();
        ran.addXp(2000);
        System.out.println(ran.getDetailsAsString());

        // Creates weapons
        System.out.println("\nCreating a melee weapon:");
        Weapon axe = new Melee("Great Axe of the Exiled", 5);
        System.out.println(axe.getDetailsAsString());
        System.out.println("\nCreating a range weapon:");
        Weapon range = new Range("Long Bow of the Lone Wolf", 10);
        System.out.println(range.getDetailsAsString());
        System.out.println("\nCreating a magic weapon:");
        Weapon magic = new Magic("Magic weapon", 10);
        System.out.println(magic.getDetailsAsString());

        //Creates armor
        System.out.println("\nCreating a cloth armor:");
        Armor cloth = new Cloth("Cloth leggings of the Magi", 10, SlotType.LEGS);
        System.out.println(cloth.getDetailsAsString());

        System.out.println("\nCreating a plate armor:");
        Armor plate = new Plate("Plate chest of the Juggernaut", 15, SlotType.BODY);
        System.out.println(plate.getDetailsAsString());

        System.out.println("\nCreating a leather armor:");
        Armor helmet = new Leather("Leather helmet", 1, SlotType.HEAD);
        System.out.println(helmet.getDetailsAsString());

        // Adding items to characters.
        System.out.println("Adding melee weapon, plate armor and helmet armor to warrior.");
        war.addItem(axe);
        war.addItem(plate);
        war.addItem(helmet);
        System.out.println(war.getDetailsAsString());

        System.out.println("Adding range weapon, cloth armor to mage.");
        mag.addItem(range);
        mag.addItem(cloth);
        System.out.println(mag.getDetailsAsString());

        // Changing items, and remove some items
        System.out.println("Removes the weapon and the leather to the warrior");
        war.removeItem(axe);
        war.removeItem(helmet);
        System.out.println("Creating plate from the future");
        Armor futurePlate = new Plate("Plate from the future", 500, SlotType.BODY);
        System.out.println("Adding a new plate (changing the plate) to warrior");
        war.addItem(futurePlate);
        System.out.println(war.getDetailsAsString());

        // Attacking
        System.out.println("Warrior attacking with damage: " + war.getDamage());
        System.out.println("Mage attacking with damage: " + mag.getDamage());
    }


    public static void testHeroWithItem(){
        Warrior war = new Warrior();
        war.addXp(1140); // Level 9
        System.out.println(war.getDetailsAsString());
        System.out.println();

        Weapon axe = new Melee("Great Axe of the Exiled", 5);
        System.out.println(axe.getDetailsAsString());
        Armor plate = new Plate("Plate chest of the Juggernaut", 5, SlotType.BODY);
        System.out.println(plate.getDetailsAsString());

        war.addItem(axe);
        war.addItem(plate);

        System.out.println();
        System.out.println(war.getDetailsAsString());
    }

    public static void testItems(){
        Weapon axe = new Melee("Great Axe of the Exiled", 5);
        System.out.println(axe.getDetailsAsString());
        Weapon w = new Range("Long Bow of the Lone Wolf", 10);
        System.out.println(w.getDetailsAsString());
        Armor cloth = new Cloth("Cloth leggings of the Magi", 10, SlotType.LEGS);
        System.out.println(cloth.getDetailsAsString());
        Armor plate = new Plate("Plate chest of the Juggernaut", 15, SlotType.BODY);
        System.out.println(plate.getDetailsAsString());
    }

    public static void testHeros(){
        Warrior war = new Warrior();
        war.addXp(1140);

        System.out.println(war.getDetailsAsString());


        System.out.println();
        Mage mag = new Mage();
        mag.addXp(1400);
        System.out.println(mag.getDetailsAsString());

        System.out.println();
        Ranger ran = new Ranger();
        ran.addXp(2000);

        System.out.println(ran.getDetailsAsString());

    }
}
