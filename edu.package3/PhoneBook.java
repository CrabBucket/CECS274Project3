package CECS274;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Models an electronic phone book that will store a contact's:
 * name
 * phone number
 * email
 * any notes
 * along with activities such as:
 * adding a new contact
 * modifying contacts
 * displaying all contacts in alphabetical order
 * @author Richie Ear
 *
 */
public class PhoneBook {
	Scanner scan = new Scanner(System.in);
	private ArrayList<Contact> book = new ArrayList<Contact>();
	private String nextInput;
	private String newName;
	private String newNumber;
	private String newEmail;
	private String newNotes;
	
	/**
	 * Helper method to find a give Contact in "book"
	 * @param name - name of contact being searched for
	 * @return i - the index at which the name entered corresponds to in "book"
	 */
	private int find(String name) {
		for (int i = 0; i < book.size(); i++) {
			if (name.equals(book.get(i).getName())) {
				return i;
			}
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * Adds a contact to the "book" ArrayList
	 */ 
	public void addContact() {
		System.out.println("Enter a name");
		newName = scan.nextLine();
		System.out.println("Enter a number");
		newNumber = scan.nextLine();
		System.out.println("Enter an email");
		newEmail = scan.nextLine();
		System.out.println("Enter a note or enter a '0' if nothing to note");
		newNotes = scan.nextLine();
		Contact c = new Contact(newName, newNumber, newEmail, newNotes);
		book.add(c);	
	}
	
	/**
	 * General method to edit a Contact
	 * Asks for which category to edit
	 * @param name - name of the contact to edit
	 * @throws InputMismatchException
	 */
	public void editContact(String name) throws InputMismatchException{
		//Checks to see if name matches in the "book", if not will throw exception
		if (book.get(this.find(name)).getName().equalsIgnoreCase(name)) {
			System.out.println("'Name'\n'Number'\n'Email'\n'Note'\n"
					+ "What do you want to edit?");
			nextInput = scan.nextLine();
			if (nextInput.equalsIgnoreCase("Name")) {
				System.out.println("Edit the name here");
				newName = scan.nextLine();
				book.get(this.find(name)).setName(newName);
			}
			if (nextInput.equalsIgnoreCase("Number")) {
				System.out.println("Edit the number here");
				newNumber = scan.nextLine();
				book.get(this.find(name)).setNumber(newNumber);
			}
			if (nextInput.equalsIgnoreCase("Email")) {
				System.out.println("Edit the email here");
				newEmail = scan.nextLine();
				book.get(this.find(name)).setEmail(newEmail);
			}
			if (nextInput.equalsIgnoreCase("Note")) {
				System.out.println("Edit the notes here");
				newNotes = scan.nextLine();
				book.get(this.find(name)).setNote(newNotes);
			}
		}
		else {
			throw new InputMismatchException();
		}
	}
	
	/**
	 * Removes contact with the name, name.
	 * @param name - name of contact to be removed
	 * @throws InputMismatchException - Throws exception when name is not found in the Phonebook
	 */
	public void deleteContact(String name) throws InputMismatchException{
		for(Contact c:book) {
			if(name.equals(c.getName())) {
				book.remove(c);
				return;
			}
			
		}
		throw new InputMismatchException();
	}
	/**
	 * Sorts phonebook lexographical order.
	 */
	public void sort() {
		Collections.sort(book);
	}
	/**
	 * Prints formated contacts in the phonebook to console.
	 */
	public void display() {
		for(Contact c:book) {
			System.out.println(c.toString());
		}
	}
	
	public int size() {
		return book.size();
	}
}
//		
//	public String toString() {
//		String everything = String.format("");
//		for (int i = 0; i < Contacts.size(); i++) {
//			everything += Contacts.get(i) + "%n";
//		}
//		return everything;
//	}
