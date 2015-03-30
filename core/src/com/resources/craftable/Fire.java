package com.resources.craftable;

import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 */
public class Fire extends Resource {

    public Fire() {
        super("Fire", 1);
        resourcesNeeded.add("Coal");
        resourcesNeeded.add("Coal");
    }

    @Override
    public ArrayList<String> neededToCraft() {
        return resourcesNeeded;
    }
}
