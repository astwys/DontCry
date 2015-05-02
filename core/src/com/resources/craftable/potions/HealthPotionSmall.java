package com.resources.craftable.potions;

import com.resources.Potions;
import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 */
public class HealthPotionSmall extends Resource implements Potions {

    public HealthPotionSmall() {
        super("HealthPotion", 1);
        resourcesNeeded.add("RedFlower");
        resourcesNeeded.add("RedFlower");
        resourcesNeeded.add("YellowFlower");
    }

    @Override
    public ArrayList<String> neededToCraft() {
        return resourcesNeeded;
    }

    @Override
    public int restoreHealthBy() {
        return 10;
    }
}
