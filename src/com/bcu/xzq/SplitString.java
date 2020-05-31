package com.bcu.xzq;

import java.util.LinkedList;

public class SplitString {	//Singleton

	private SplitString() {
		// TODO Auto-generated constructor stub
	}
	
	public static LinkedList<String> getSplitString(String string){
		LinkedList<String> linkedList = new LinkedList<String>();
		String[] tt=string.split("\\s+");
        for(String s:tt)
        {
        	linkedList.add(s);
        }
		return linkedList;
	}
}
