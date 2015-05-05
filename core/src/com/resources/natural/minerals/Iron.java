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
public class Iron extends Resource{

	public Iron() {
		super("Iron", 1);
		// no resources needed
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return null;
	}

}
