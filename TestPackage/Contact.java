package edu.project3;


/**
*Stores and modifies following information:
*Name
*Number
*Email
*Notes
*@author Thomas McSwain
*/
public class Contact implements Comparable<Contact> {
	private String name;
	private String number;
	private String email;
	private String notes;
	/**
	 * 
	 * @param name - name
	 * @param number - contact number in the form XXXXXXXXXXX
	 * @param email - contact email
	 * @param notes - any notes on the contact
	 */
	public Contact(String name,String number,String email,String notes){
		this.name=name;
		this.number=number;
		this.email=email;
		this.notes=notes;
	}
	/**
	 * 
	 * @return - returns name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return formated string 
	 */
	public String toString() {
		StringBuilder pNum = new StringBuilder(number);
		pNum.insert(0,"(");
		pNum.insert(4,")");
		pNum.insert(8,"-");
		return String.format("%-20s%-20s%-20s%-20s",name,pNum.toString(),email,notes);
	
	}
	/**
	 * compares this contact to contact c based on lexographicval order of name.
	 * @param c - Some other contact it compares to
	 * @return - returns -1 if it comes first 0 if its the same 1 if its greater than
	 */
	public int compareTo(Contact c) {
		
		return name.compareTo(c.getName());
	}
	
	
}
