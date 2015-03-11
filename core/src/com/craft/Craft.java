package com.craft;

import java.util.ArrayList;
import com.resources.*;

/*Craft class
*created: 10.3.2015
*by: Max
*/

public class Craft{

	private Craftable crafting;
	private ArrayList<Resource> required;

	public Craft(Craftable craft, ArrayList<Resource> req){
		required = new ArrayList<Resource>(req);
		crafting = craft;
	} 

	public Craftable getCrafting(){
		return crafting;
	}

	public int getNumberOfResources(){
		return required.size();
	}

	public Resource getResourceByIndex(int index){
		return required.get(index);
	}





}