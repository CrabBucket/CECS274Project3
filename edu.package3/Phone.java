package CECS274;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import CECS274.PhoneBook;
import CECS274.Contact;
import CECS274.Favorites;
import CECS274.Record;

public class Phone extends PhoneBook{

	public static void main(String[] args) {
		String name;
		String number;
		String email;
		String notes;
		Scanner scan = new Scanner(System.in);
		PhoneBook phone = new PhoneBook();
		//Checks if you want to use the phone book
		System.out.println("Would you like to access your phone book? 'Yes' or 'No' ");
		String access = scan.nextLine();
		if (access.equalsIgnoreCase("Yes")) {
			while (true) {
				//Displays a list of options for the user to pick from and will execute
				//an action based off the desired choice
				//If input is incorrect, will tell user and loop back to prompt user again
				try {
					System.out.println("Please select one:\n'Add'\n'Edit'\n'Delete'\n"
							+ "'Display'\n'Favorites'\n'Call History'\n'Finish'\n"
							+ "What would you like to do?");
					String nextInput = scan.nextLine();
					if (nextInput.equalsIgnoreCase("Add")) {
						System.out.println("Are you sure you want to add? 'y'/'n'");
						nextInput = scan.nextLine();
						if (nextInput.equalsIgnoreCase("y")) {
							phone.addContact();
						}
					}
					else if (nextInput.equalsIgnoreCase("Edit")) {
						System.out.println("Are you sure you want to edit? 'y'/'n'");
						nextInput = scan.nextLine();
						if (nextInput.equalsIgnoreCase("y")) {
							System.out.println("Enter a contact to edit.");
							nextInput = scan.nextLine();
							phone.editContact(nextInput);
						}
					}
					else if (nextInput.equalsIgnoreCase("Delete")) {
						System.out.println("Are you sure you want to delete? 'y'/'n'");
						nextInput = scan.nextLine();
						if (nextInput.equalsIgnoreCase("y")) {
							System.out.println("Enter a contact to delete.");
							nextInput = scan.nextLine();
							phone.deleteContact(nextInput);
						}
					}
					else if (nextInput.equalsIgnoreCase("Display")) {
						phone.display();
					}
					else if (nextInput.equalsIgnoreCase("Favorites")) {
						
					}
					else if (nextInput.equalsIgnoreCase("Call History")) {
						
					}
					else if (nextInput.equalsIgnoreCase("Finish")) {
						break;
					}
					else {
						System.out.println("Let's try this again.");
						continue;
					}
				}
				catch (InputMismatchException e) {
					System.out.println("You've entered in something wrong. Let's try again.");
					continue;
				}
				catch (NoSuchElementException e) {
					System.out.println("The entry couldn't be found.");
					continue;
				}
			}
		}
		else {
			System.out.println("Maybe next time!");
		}
		scan.close();
	}
}
