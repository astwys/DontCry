package com.resources.craftable.edible;

import com.resources.Edible;
import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 */
public class Chips extends Resource implements Edible{

    public Chips() {
        super("Chips", 5);
        resourcesNeeded.add("Potato");
        resourcesNeeded.add("Potato");
        resourcesNeeded.add("Fire");
    }

    @Override
    public ArrayList<String> neededToCraft() {
        return resourcesNeeded;
    }

    @Override
    public int restoreHungerBy() {
        return 8;
    }
}
