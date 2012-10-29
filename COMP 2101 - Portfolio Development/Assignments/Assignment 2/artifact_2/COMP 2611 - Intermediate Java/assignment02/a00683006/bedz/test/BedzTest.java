/**
 * Project: assignment02
 * File: BedzTest.java
 * Date: 24-Sep-07
 * Time: 2:17:55 AM
 */
package a00683006.bedz.test;

import a00683006.bedz.data.*;
import a00683006.bedz.ui.*;

/**
 * This class holds the information for the console user interface as
 * well as the entire BedAndBreakfast Database. This class allows you
 * to print out information about the rooms, guests, and reservations.
 * @author Steffen L. Norgren, A00683006
 *
 */
public class BedzTest {
	
	private BedAndBreakfast db;
	private Console view;

	/**
	 * Set the database and console
	 * @param db
	 * @param view 
	 */
	public BedzTest(BedAndBreakfast db, Console view) {
		this.db = db;
		this.view = view;
		
		new MainWindow(db);
	}
	
	/**
	 * Print out all the rooms.
	 */
	public void showRooms() {
		view.print(db.getRoom());
	}

	/**
	 * Print out all the guests.
	 */
	public void showGuests() {
		view.print(db.getGuests().values());
	}

	/**
	 * Print out all the reservations.
	 */
	public void showReservations() {
		view.print(db.getReservations().values());
	}
}