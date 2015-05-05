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
public class Wood extends Resource{
	public Wood() {
		super("Wood", 1);
		// no resources needed
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return null;
	}
}
