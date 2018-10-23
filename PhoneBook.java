package edu.package3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

/**
 * Contains an arraylist of contacts and modifies it
 * displays contacts in alphabetical order
 * @author Thomas McSwain
 *
 */
public class PhoneBook {
	private ArrayList<Contact> book = new ArrayList<Contact>();
	/**
	 * Adds a contact to book arraylist
	 * 
	 */
	public void add(Contact c) {
		
		book.add(c);
		
	}
	/**
	 * Checks to see if the name is in the phonebook
	 * @param name - name to be checked
	 * @return - returns true if it finds the name in the phonebook.
	 */
	public boolean inBook(String name) {
		for(Contact c:book) {
			if(c.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Removes contact with the name, name.
	 * @throws InputMismatchException - Throws exception when name is not found in the Phonebook
	 */
	public void remove(String name) throws InputMismatchException{
		
		for(Contact c:book) {
			if(name.equals(c.getName())) {
				book.remove(c);
				return;
			}
			
		}
		throw new InputMismatchException();
	}
	/**
	 * Finds the contact with name:name then replaces it with a new contact with new names.
	 * 
	 * @param name
	 * @param newName
	 * @param number
	 * @param email
	 * @param notes
	 * @throws InputMismatchException
	 */
	public void edit(String name,String newName,String number,String email,String notes) throws InputMismatchException{
		
		for(Contact c:book) {
			if(name.equals(c.getName())) {
				int index = book.indexOf(c);
				book.remove(c);
				book.add(index,new Contact(newName,number,email,notes));
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
	/**
	 * Looks for a contact in the phone book with number num and returns it's name if no contact is found returns NA
	 * @param number - to be searched
	 * @return - returns the name of the contact or NA if the contact isn't found.
	 */
	public String findName(String number) {
		for(Contact c:book) {
			if(c.getNum().equals(number)) {
				return c.getName();
			}
			
		}
		return "NA";
	}
	
}
