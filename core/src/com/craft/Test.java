package com.craft;

import java.util.ArrayList;

import com.craft.Craftingbook.ReturnForCraft;

public class Test {

	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		Craftingbook craft = new Craftingbook();
		ArrayList<String> arrayL = new ArrayList<String>();
		arrayL.add("Stone");
		arrayL.add("Gas");
		arrayL.add("Stone");
		ReturnForCraft rfc = craft.craft(arrayL);
	}

}
