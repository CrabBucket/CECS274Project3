package edu.project3;
import java.util.ArrayList;

/**
 * 
 * Keeps track of the name and date of calls
 * Consolidates one record into a multi record
 * @author Thomas
 *
 */
public class Record {
	private String id;
	private String date;
	private String IO;
	private ArrayList<Record> multiRecord = new ArrayList<Record>();
	/**
	 * Constructor that sets all instance variables
	 * @param id - Name or number
	 * @param date - Date and time of call
	 * @param IO -Incoming or outgoing call.
	 */
	public Record(String id, String date, String IO) {
		this.id=id;
		this.date = date;
		this.IO=IO;
	}
	/**
	 * returns this record's id
	 * @return id of this record
	 */
	public String getId() {
		return id;
	}
	/**
	 * Returns formated string of the record.
	 * @return - formated string
	 */
	public String toString() {
		return String.format("%s %n%-20s%s", id,date,IO);
	}
	/**
	 * Consolidates a record to a multi record
	 * @param r - record to be consolidated
	 */
	public void consolidate(Record r) {
		multiRecord.add(r);
	}
	/**
	 * returns the size of the multirecord.
	 * @return - Returns the size of multirecord.
	 */
	public int size() {
		return multiRecord.size();
	}
}
