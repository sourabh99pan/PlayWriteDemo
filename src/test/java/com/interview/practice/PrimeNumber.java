package com.interview.practice;

public class PrimeNumber {

	public static void main(String[] args) {
		int n =101;
		boolean flag=true;
		
		for (int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				flag=false;
			}
		}

		if(flag)
		{
			System.out.println("number is prime");
		}
		else
		{
			System.out.println("number is not a prime");
		}
	}

}
