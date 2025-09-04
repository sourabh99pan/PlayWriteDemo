package com.interview.practice;

public class Palindrom {

	public static void main(String[] args) {
		String str ="MALAYALAM";
		boolean flag=true;
		int len=str.length();
		for(int i=0;i<len/2;i++)
		{
			if(str.charAt(i)==str.charAt(len-i-1))
			{
				continue;
			}
			else
			{
				flag=false;
			}
		}

		if(flag)
		{
			System.out.println("It is palindrom");
		}
		else
		{
			System.out.println("It is not a palindrom");
		}
	}

}
