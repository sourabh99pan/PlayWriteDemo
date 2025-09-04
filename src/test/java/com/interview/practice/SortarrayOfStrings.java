package com.interview.practice;

import java.util.*;

public class SortarrayOfStrings {

	public static void main(String[] args) {
		
		String str ="Java Python Selenium Selenium Java Java";
		String strArr [] = str.split(" ");
		HashMap<String, Integer> hm = new <String, Integer>HashMap();
		HashMap<String, Integer> lhm =new <String, Integer>LinkedHashMap();
		ArrayList<Integer> al = new <Integer>ArrayList();
		for(int i=0;i<strArr.length;i++)
		{
			if(hm.containsKey(strArr[i]))
			{
				hm.put(strArr[i], hm.get(strArr[i])+1);
			}
			else
			{
				hm.put(strArr[i],1);
			}
		}

		for(Map.Entry<String, Integer> e:hm.entrySet())
		{
			al.add(e.getValue());
		}
		
		Collections.sort(al);
		
		for(int i=0;i<al.size();i++)
		{
		
		for(Map.Entry<String, Integer> e1:hm.entrySet())
		{
			if(e1.getValue()==al.get(i))
			{
				lhm.put(e1.getKey(), al.get(i));
			}
		}
	}
		

		for(Map.Entry<String, Integer> e2:lhm.entrySet())
		{
			System.out.println(e2.getKey()+" "+e2.getValue());
		}
	}

}
