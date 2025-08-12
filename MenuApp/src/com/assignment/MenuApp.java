package com.assignment;



import java.util.Scanner;

class mathOperations{
	public static void printTable(int number) {
		for(int i=0;i<=10;i++) {
			System.out.println(number + "*" + i + "=" +(number*i));
		}
	}
	public static void calculateFactorial(int number) {
		double fact=1;
		for(int i=number;i>1;i--) {
			fact=fact*i;
		}
		System.out.println(fact);
	}
	public static void checkPrime(int number) {
		boolean prime = true;
		if(number <= 1) {
			prime =false;
		}
		else {
			for(int i=2;i<=number/2;i++) {
				if(number % i ==0) {
					prime=false;
					break;
				}
			}
			if(prime) {
				System.out.println(number+ " is a prime number");
			}
			else {
				System.out.println(number+ " is not a prime number");
			}
		}
}
	public static void printFibonnaciSeries(int number) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter first series");
		int b = s.nextInt();
		System.out.println("Enter second series");
		int c = s.nextInt();
		for(int i=0;i<=number;i++) {
			System.out.println(b+ " ");
			int d= b+c;
			b=c;
			c=d;
		}
	}
}


public class MenuApp extends mathOperations{
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	mathOperations mathOps=new mathOperations();
	boolean st = true;
	char c;
	do {
		System.out.println("--------------Menu------------------");
		System.out.println("Press 1 To Print The Table");
		System.out.println("Press 2 To Calculate The Factorial");
		System.out.println("Press 3 To Calculate prime Number");
		System.out.println("press 4 To Print Fabinnocci Series");
		System.out.println("press 5 for exit");
		int choice=s.nextInt();
		switch(choice) {
		case 1:
		{
			System.out.println("Enter n value to print table");
			int n=s.nextInt();
			printTable(n);
		}
		break;
		case 2:
		{
			System.out.println("Enter f value to print factorial");
			int f=s.nextInt();
			calculateFactorial(f);
		}
		break;
		case 3:
		{
			System.out.println("Enter p value to check prime number");
			int p=s.nextInt();
			checkPrime(p);
		}
		break;
		case 4: 
		{
			System.out.println("Enter the series you want to print");
			int m=s.nextInt();
			printFibonnaciSeries(m);
		}
		break;
		case 5:
		{
			st=false;
			System.out.println("Thank You");
		}
		break;
		default:
			System.out.println("Invalid Input");
		}
		System.out.println("Do you want to continue? (Y/N)");
		c= s.next().charAt(0);
	}
	while(c=='Y' || c=='y');
	System.out.println("program ended");
	}
}