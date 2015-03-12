package com.craft;

import java.util.ArrayList;
import com.resources.*;

/*Craft class
*created: 10.3.2015
*by: Max
*/

public class Craft{

	private Craftable crafting;
	private ArrayList<String> required;
	private boolean unlocked;

	public Craft(Craftable craft, ArrayList<String> req){
		required = new ArrayList<String>(req);
		crafting = craft;
	} 

	public Craftable getCrafting(){
		return crafting;
	}

	public int getNumberOfResources(){
		return required.size();
	}

	public String getResourceByIndex(int index){
		return required.get(index);
	}
	
	public void setUnlocked(boolean isUnlocked){
		unlocked = isUnlocked;
	}





}