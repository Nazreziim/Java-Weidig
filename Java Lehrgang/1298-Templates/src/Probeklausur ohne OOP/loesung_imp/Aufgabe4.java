package loesung_imp;

//Name:
//Dienstgrad:

import java.util.Scanner;

public class Aufgabe4 {
	
	public static void main(String[] args) {
		
		Scanner eingabe = new Scanner(System.in);
		
		System.out.print("Name Spieler 1 => ");	
		String name1 = eingabe.nextLine();
		
		System.out.print("Name Spieler 2 => ");
		String name2 = eingabe.nextLine();
		
		System.out.print("Punkte Spieler 1: ");
		int punkteSpieler1 = eingabe.nextInt();
		
		System.out.print("Punkte Spieler 2: ");
		int punkteSpieler2 = eingabe.nextInt();
		
		spielrunde(name1,name2,punkteSpieler1,punkteSpieler2);
	}

	
	/*
	Hier ist Ihre Methode "spielrunde" zu ergänzen.
	*/
	private static void spielrunde(String name1, String name2,
			int punkteSpieler1, int punkteSpieler2) {
		
		final int grenzwert = 100;
		
		if (punkteSpieler1 == punkteSpieler2)
		{
			System.out.println("unentschieden");
		}
		else if (punkteSpieler1 > punkteSpieler2)
		{
			if ((punkteSpieler1 - punkteSpieler2) > grenzwert )
			{
				System.out.println(name2 + " gewinnt ");
			}
			else
			{
				System.out.println(name1 + " gewinnt ");
			}
		}
		else 
		{
			if ((punkteSpieler2 - punkteSpieler1) > grenzwert )
			{
				System.out.println(name1 + " gewinnt ");
			}
			else
			{
				System.out.println(name2 + " gewinnt ");
			}
		}		
		
	}
	
}
