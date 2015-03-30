package com.resources.natural.edible;

import com.resources.Edible;
import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 *
 * yellow flowers should be extremly rare
 */
public class YellowFlower extends Resource implements Edible {

    public YellowFlower() {
        super("YellowFlower", 1);
    }

    @Override
    public ArrayList<String> neededToCraft() {
        return null;
    }

    @Override
    public int restoreHungerBy() {
        return 1;
    }
}
