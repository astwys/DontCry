package com.resources.natural.minerals;

import com.resources.Resource;

import java.util.ArrayList;

/**
 * Created by michael on 3/30/15.
 */
public class Coal extends Resource {

    public Coal() {
        super("Coal", 1);
        // no resources needed
    }

    @Override
    public ArrayList<String> neededToCraft() {
        return null;
    }
}
