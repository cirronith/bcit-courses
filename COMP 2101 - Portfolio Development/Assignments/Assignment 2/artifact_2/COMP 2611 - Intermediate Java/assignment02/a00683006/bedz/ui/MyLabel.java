/**
 * Project: assignment02
 * File: MyLabel.java
 * Date: 23-Nov-07
 * Time: 6:54:04 PM
 */
package a00683006.bedz.ui;

import javax.swing.*;

/**
 * @author Steffen L. Norgren, A00683006
 *
 */
public class MyLabel extends JLabel {
	private static final long serialVersionUID = 12348129L;
	
	public MyLabel(String name) {
		super(name);
		setHorizontalAlignment(JLabel.RIGHT);
	}

	public MyLabel(ImageIcon name) {
		super(name);
		setHorizontalAlignment(JLabel.LEFT);
	}
}
