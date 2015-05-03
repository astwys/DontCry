package com.resources.craftable.potions;

import com.resources.Potions;
import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 */
public class HealthPotionBig extends Resource implements Potions {

    public HealthPotionBig() {
        super("HealthPotionBig", 1);
        resourcesNeeded.add("RedFlower");
        resourcesNeeded.add("HealthPotion");
        resourcesNeeded.add("Apple");
    }

    @Override
    public ArrayList<String> neededToCraft() {
        return resourcesNeeded;
    }

    @Override
    public int restoreHealthBy() {
        return 20;
    }
}
