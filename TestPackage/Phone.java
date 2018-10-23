package edu.project3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Phone {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Favorites favorites = new Favorites();
		PhoneBook phone = new PhoneBook();
		System.out.println("Would you like to access your phone book? 'Yes' or 'No' ");
		
			while(true) {
				System.out.println("Please enter the number of what you want to access:\n1. Phone book\n2. Favorites\n3. Calls\n4. Call History\n5: Exit phone");
				String nextInput = scan.nextLine();
				if (nextInput.equals("1")) {
					while(true) {
						System.out.println("Welcome to the Phonebook, would you like to:\n1. Add a contact\n2. Delete a contact\n3. Edit a contact\n4. Alphabetize and Display phonebook\n5: Exit Phonebook");
						String nextInput1 = scan.nextLine();
						if(nextInput1.equals("1")) {
							System.out.println("What is the name of the contact you wish to add?");
							String name = scan.nextLine();
							System.out.println("What is the phone number of the contact you wish to add?");
							String number = scan.nextLine();
							System.out.println("What is the email of the contact you wish to add?");
							String email = scan.nextLine();
							System.out.println("Enter any notes you want on this contact, if there are no notes press enter.");
							String notes = scan.nextLine();
							
							phone.add(new Contact(name,number,email,notes));
						}
						else if (nextInput1.equals("2")) {
							try{
								System.out.println("What is the name of the contact you wish to remove?");
								String name = scan.nextLine();
								phone.remove(name);
							}catch(InputMismatchException e){
								System.out.println("Name not found ensure you are spelling the name correct and that the contact you are looking for exists then try again.");
							}
						}
						else if (nextInput1.equals("3")) {
							try{
								System.out.println("What is the name of the contact you wish to edit?");
								String name = scan.nextLine();
								System.out.println("What is the new name of the contact?");
								String newName = scan.nextLine();
								System.out.println("What is the new phone number of the contact?");
								String number = scan.nextLine();
								System.out.println("What is the new email of the contact?");
								String email = scan.nextLine();
								System.out.println("Enter any notes you want on the new contact, if there are no notes press enter.");
								String notes = scan.nextLine();
								phone.edit(name,newName,number,email,notes);
							}catch(InputMismatchException e){
								System.out.println("Name not found ensure you are spelling the name correct and that the contact you are looking for exists then try again.");
							}
						}
						else if (nextInput1.equals("4")) {
							phone.sort();
							phone.display();
						}
						else if (nextInput1.equals("5")) {
							break;
						}
						else {
							System.out.println("Please enter a number from 1 to 5");
						}
					}
				}
				else if (nextInput.equals("2")) {
					System.out.println("Welcome to Favorites, would you like to:\n1. Add a Favorite\n2. Remove a Favorite\n3.Change prefeerence\n4.Display a Favorite\n5: Exit Favorites");
					if (nextInput.equals("1")) {
						System.out.println("What is the name of the contact you wish to add?");
						String name = scan.nextLine();
						System.out.println("What is the phone number of the contact you wish to add?");
						String number = scan.nextLine();
						System.out.println("What is the email of the contact you wish to add?");
						String email = scan.nextLine();
						System.out.println("Enter any notes you want on this contact, if there are no notes press enter.");
						String notes = scan.nextLine();
						System.out.println("Enter the file address of a picture for this person");
						String address = scan.nextLine();
						favorites.add(address,name,number, email, notes);
					}
					else if (nextInput.equals("2")) {
						try {
							System.out.println("What is the name of the Favorite you wish to remove?");
							String name = scan.nextLine();
							favorites.remove(name);
						}catch(InputMismatchException e){
							System.out.println("Name not found ensure you are spelling the name correct and that the contact you are looking for exists then try again.");
						}
					}
					else if (nextInput.equals("3")) {
						
					}
					else if (nextInput.equals("4")) {
						
					}
					else if (nextInput.equals("5")) {
						break;
					}
				}
				else if (nextInput.equals("3")) {
					
				}
				else if (nextInput.equals("4")) {
					
				}
				else if (nextInput.equals("5")) {
					
				}
				
				else {
					System.out.println("Please enter a number from 1 to 5");
					//continue;
				}
			
		}
	}	
}
