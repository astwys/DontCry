/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public abstract class Resource implements Craftable, IfCraftable{
	ArrayList<String> resourcesNeeded;
	
	public Resource(String name) {
		name=name;
		
		if (isNatural()) {
			resourcesNeeded=new ArrayList<String>();
		}
	}
}