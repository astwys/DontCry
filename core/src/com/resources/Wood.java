/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public class Wood extends Resource{
	String name="Wood";
	
	public Wood(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isNatural() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see com.resources.IfCraftable#neededToCraft()
	 */
	@Override
	public ArrayList<String> neededToCraft() {
		// TODO Auto-generated method stub
		return null;
	}
}
