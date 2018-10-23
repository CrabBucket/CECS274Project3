package edu.project3;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Phone {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Log log = new Log();
		Favorites favorites = new Favorites();
		PhoneBook phone = new PhoneBook();
		System.out.println("Would you like to access your phone book? 'Yes' or 'No' ");
		
			while(true) {
				System.out.println("Please enter the number(1-5) of what you want to access:\n1. Phone book\n2. Favorites\n3. Calls\n4. Call History\n5: Exit phone");
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
						try {
							System.out.println("Enter the name of the Favorite you wish to change");
							String name = scan.nextLine();
							System.out.println("Enter the new Favorite number you wish to change the contact to.");
							int index = Integer.valueOf(scan.nextLine());
							favorites.swap(name, index);
						}
						catch(IndexOutOfBoundsException e) {
							System.out.println("Make sure you entered a number between 1 and 5 and that there are at least as many favorites you are trying to add.");
						}
					}
					else if (nextInput.equals("4")) {
						try {
							System.out.println("Enter the Number of the contact you wish to display.");
							int index = Integer.valueOf(scan.nextLine());
							favorites.display(index);
						}
						catch(IndexOutOfBoundsException e) {
							System.out.println("Make sure you entered a number between 1 and 5 and that there are at least as many favorites you are trying to add.");
						}
					}
					else if (nextInput.equals("5")) {
						break;
					}
				}
				else if (nextInput.equals("3")) {
					while(true){
						System.out.println("Enter a phone number, a name or a Favorite 1-5, to make or recieve a call. Type \"menu\" to go back to menu");
						String num = scan.nextLine();
						if(num.length()==1) {
							System.out.println("Is the call comming in or out? Type \"in\" for in and \"out\", for out.");
							String IO = scan.nextLine();
							if(IO.equals("in")) {
								IO="Incoming";
							}else {
								IO="Outgoing";
							}
							Date date = new Date();
							log.add(new Record(favorites.fav.get(Integer.valueOf(num)).getName(),date.toString(),IO));
						}else if(num.length()==10&&Character.isDigit(num.charAt(0))) {
							System.out.println("Is the call comming in or out? Type \"in\" for in and \"out\", for out.");
							
							String IO = scan.nextLine();
							if(IO.equals("in")) {
								IO="Incoming";
							}else {
								IO="Outgoing";
							}
							Date date = new Date();
							StringBuilder pNum = new StringBuilder(num);
							pNum.insert(0,"(");
							pNum.insert(4,")");
							pNum.insert(8,"-");
							log.add(new Record(pNum.toString(),date.toString(),IO));
						}else if(!Character.isDigit(num.charAt(0))) {
							if(num.equals("menu")) {
								break;
							}
							while(!phone.inBook(num)) {
								System.out.println("The name is not in the Phonebook, enter a name that exists in the Phone book or enter menu to go back to the menu.");
								num=scan.nextLine();
								if(num.equals("menu")) {
									break;
								}
							}
							if(num.equals("menu")) {
								break;
							}
							System.out.println("Is the call comming in or out? Type \"in\" for in and \"out\", for out.");
							
							String IO = scan.nextLine();
							if(IO.equals("in")) {
								IO="Incoming";
							}else {
								IO="Outgoing";
							}
							Date date = new Date();
							log.add(new Record(favorites.fav.get(Integer.valueOf(num)).getName(),date.toString(),IO));
						}
					}
				}
				else if (nextInput.equals("4")) {
					if(log.display()) {
						System.out.println("Do you wish to see more information?(Y/N)");
						String temp = scan.nextLine();
						if(temp.toLowerCase().equals("y")) {
							log.showDupe();
						}
					}
				}
				else if (nextInput.equals("5")) {
					break;
				}
				
				else {
					System.out.println("Please enter a number from 1 to 5");
					//continue;
				}
			
		}
	}	
}
