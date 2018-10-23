package edu.package3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Phone {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Phone_Book phone = new Phone_Book();
		System.out.println("Would you like to access your phone book? 'Yes' or 'No' ");
		String access = scan.nextLine();
		if (access.equalsIgnoreCase("Yes")) {
			try {
				System.out.println("Please select one:\n'Add'\n'Edit'\n'Delete'\n"
						+ "'Display'\n'Favorites'\n'Call History'\n"
						+ "What would you like to do?");
				String nextInput = scan.nextLine();
				if (nextInput.equalsIgnoreCase("Add")) {
					
				}
				else if (nextInput.equalsIgnoreCase("Edit")) {
					
				}
				else if (nextInput.equalsIgnoreCase("Delete")) {
					
				}
				else if (nextInput.equalsIgnoreCase("Display")) {
					
				}
				else if (nextInput.equalsIgnoreCase("Favorites")) {
					
				}
				else if (nextInput.equalsIgnoreCase("Call History")) {
					System.out.println("Call History");
				}
				else {
					System.out.println("Let's try this again.");
					//continue;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("You've entered in something wrong. Let's try again.");
				//continue;
			}
		}
		else {
			System.out.println("Maybe next time!");
		}
	}
}
