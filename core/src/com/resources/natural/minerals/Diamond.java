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
public class Diamond extends Resource {

	public Diamond() {
		super("Diamond", 1);
		// no resources needed
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return null;
	}

}
