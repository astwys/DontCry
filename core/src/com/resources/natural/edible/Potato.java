package com.resources.natural.edible;

import com.resources.Edible;
import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 */
public class Potato extends Resource implements Edible{

    public Potato() {
        super("Potato", 1);
        // no resources needed
    }

    @Override
    public ArrayList<String> neededToCraft() {
        return null;
    }

    @Override
    public int restoreHungerBy() {
        return 5;
    }
}
