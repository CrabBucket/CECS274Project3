package edu.project3;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Keeps track of your favorites
 * @author Thomas
 *
 */
public class Favorites {
	private ArrayList<Contact> fav = new ArrayList<Contact>();
	private ArrayList<FavoriteContactFrame> favC = new ArrayList<FavoriteContactFrame>();
	/**
	 * Adds a contact and keeps the list at a max of 6
	 * @param c - contact to be added
	 */
	public void add(String address,String name,String number,String email,String notes) {
		
		favC.add(new FavoriteContactFrame(address, 600, 400, name,number, email, notes));
		fav.add(0,new Contact(name,number,email,notes));
		if(fav.size()==6) {
			fav.remove(5);
			favC.remove(5);
		}
	}
	/**
	 * Removes specified name from favorites
	 * @param name - Name to be removed from favorites
	 * @throws InputMismatchException
	 */
	public void remove(String name) throws InputMismatchException {
		for(Contact c:fav) {
			if(name.equals(c.getName())) {
				favC.remove(fav.indexOf(c));
				fav.remove(c);
				return;
			}
			
		}
		throw new InputMismatchException();
	}
	
	
	/**
	 * Swaps a contact to a specified position
	 * @param name - name of contact to be swapped
	 * @param a position to swap contact to
	 */
	public void swap(String name,int a) {
		
		for(Contact c:fav) {
			if(c.getName()==name) {
				int index = fav.indexOf(c);
				fav.remove(c);
				fav.add(a-1,c);
				FavoriteContactFrame temp = favC.get(index);
				favC.remove(index);
				favC.add(a-1, temp);
				break;
			}
		}
		
		
	}
	/**
	 * Displays favorite of index a-1
	 * @param - Index to be displayed.
	 */
	public void display(int a) {
		favC.get(a-1).displayContactFrame();
		
	}

}
