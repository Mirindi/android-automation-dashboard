package com.cristi8.automationdashboard;

public class MyGridItem {
	public MyGridItem(int i, String s)
	{
		ValueInt = i;
		ValueStr = s;
	}
	public int ValueInt;
	public String ValueStr;
	
	public String toString()
	{
		return ValueStr;
		
	}
}
