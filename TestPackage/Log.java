package edu.project3;
import java.util.ArrayList;




/**
 * Has an arraylist of records
 * Displays them
 * Displays addtional information on duplicates
 * @author Thomas
 *
 */
public class Log {
	ArrayList<Record> log = new ArrayList<Record>();
	/**
	 * Adds record to arraylist
	 * @param r - record to be added
	 */
	public void add(Record r) {
		log.add(r);
	}
	/**
	 * Prints the logbook to console, if there is two or more logs from the same ID makes them into 1 log entry
	 * @return - returns true if there are any duplicates false otherwise.
	 */
	public boolean display() {
		boolean dupe = false;
		//First for loop goes through the entire log.  
		for(int i=0;i<log.size();i++) {
			//Second for loop goes through all the remaining entries in the log, if you are at entry 5/10 it will go through 6,7,8,9,10
			for(int c=i+1;c<log.size();c++) {
				//If any record past the current record has the same ID we consolidate it into the first record then remove the addtional entries from the log
				if(log.get(i).getId()==log.get(c).getId()) {
					log.get(i).consolidate(log.get(c));
					log.remove(c);
					//We need to go back one since when you remove an entry from an ArrayList we do weird things to the indices
					c--;
					//Since we found a duplicate we want to return that the log has a duplicate into it
					dupe = true;
				}
			}
			if(log.get(i).size()==0) {
				//If the record is not a duplicate we just use the records toString
				System.out.println(log.get(i).toString());
			}else {
				//If the record is a duplicate we want to print ID (# of records).
				System.out.printf("%-10s(%d)%n",log.get(i).getId(),log.get(i).size());
			}
			
		}
		return dupe;
	}
	
}
