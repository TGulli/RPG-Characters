package com.experisno.tgulli.item;

import com.experisno.tgulli.hero.SlotType;

/*
* Abstract class for items. A item is either an armor or a weapon.
* This abstract class have some shared functions, and contains abstract functions,
* which the subclasses must have a implementation for.*/
public abstract class Item {
    protected String name;
    protected int level;
    protected SlotType particularSlotType;

    /*All items has a name, level and particular place for the item, so the constructor takes that as parameters*/
    public Item(String name, int level, SlotType particularSlotType) {
        this.name = name;
        this.level = level;
        this.particularSlotType = particularSlotType;
    }

    public SlotType getParticularSlotType() {
        return particularSlotType;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    /*
    * Leveling up a item, and updates the items data based on the new level. */
    public void levelUp(){
        level++;
        updateData();
    }

    /*
    * Updates the data for a item based on the current level.*/
    protected abstract void updateData();

    /*
    * Returns a string with data from the item.*/
    public abstract String getDetailsAsString();
}
