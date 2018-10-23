package CECS274;


/**
*Stores and modifies following information:
*Name
*Number
*Email
*Notes
*@author Thomas McSwain
*/
public class Contact extends PhoneBook implements Comparable<Contact>{
	private String name;
	private String number;
	private String email;
	private String notes; 
	
	/**
	 * Default constructor to allow inheritance
	 */
	public Contact() {
		
	}
	
	/**
	 * Constructor that builds a contact
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
	 * Changes the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Changes the number
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Changes the email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Changes the note
	 * @param note
	 */
	public void setNote(String note) {
		this.notes = note;
	}
	
	/**
	 * Readable Contact
	 * @return formatted string 
	 */
	public String toString() {
		StringBuilder pNum = new StringBuilder(number);
		pNum.insert(0,"(");
		pNum.insert(4,")");
		pNum.insert(8,"-");
		return String.format("%-20s%-20s%-20s\t%-20s",name,pNum.toString(),email,notes);
	
	}
	
	/**
	 * Compares this contact to Contact c based on lexicographical order of name.
	 * @param c - Some other contact it compares to
	 * @return - returns -1 if it comes first 0 if its the same 1 if its greater than
	 */
	public int compareTo(Contact c) { 
		return name.compareTo(c.getName());
	}
}