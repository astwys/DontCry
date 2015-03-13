/**
 * 
 */
package com.resources.natural;

import java.util.ArrayList;

import com.resources.Resource;

/**
 * @author michael
 *
 */
public class Diamond extends Resource {

	/**
	 * @param name
	 */
	public Diamond() {
		super("Diamond", 1);
		// no resources needed
	}

	/* (non-Javadoc)
	 * @see com.resources.Craftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		// TODO Auto-generated method stub
		return null;
	}

}
