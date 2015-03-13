/**
 * 
 */
package com.resources;

import java.util.ArrayList;

/**
 * @author michael
 *
 */
public interface Craftable {
	/*
	 * arraylist that includes all resources that are neededToCraft a craftable resource
	 * if the resource is natural the arraylist returns null
	 */
	public ArrayList<String> neededToCraft();
}