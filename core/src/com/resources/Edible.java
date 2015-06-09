package com.resources;

/**
 * this interface is only used to differentiate between the different resource groups
 * Created by michael on 3/30/15.
 */
public interface Edible {

    /**
     *
     * @return the value by which the hunger value is increased
     */
    public int restoreHungerBy();
}
