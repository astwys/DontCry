/**
 * 
 */
package com.resources.natural.minerals;

import java.util.ArrayList;

import com.resources.Resource;

/**
 * @author michael
 *
 */
public class Stone extends Resource {
	
	public Stone() {
		super("Stone", 1);
		// no resources needed
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return null;
	}

}
