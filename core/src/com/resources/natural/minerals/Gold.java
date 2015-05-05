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
public class Gold extends Resource {

	public Gold() {
		super("Gold", 1);
		// no resources needed
	}

	@Override
	public ArrayList<String> neededToCraft() {
		return null;
	}

}
