package com.resources.natural.edible;

import com.resources.Edible;
import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 *
 * flowers should be relatively rare
 */
public class RedFlower extends Resource implements Edible {

    public RedFlower() {
        super("RedFlower", 1);
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
