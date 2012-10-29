/**
 * Project: lab04
 * File: DataException.java
 * Date: 8-Oct-07
 * Time: 7:21:22 PM
 */
package a00683006.bedz.data;

/**
 * @author Steffen L. Norgren, A00683006
 *
 */
public class DataException extends Exception {
	private static final long serialVersionUID = 192873981237L;
	
	private String data;
	
	/**
	 * Exception skeleton
	 * @param data
	 */
	public DataException(String data) {
		super(data);
		this.data = data;
	}
	
	/**
	 * Return the data passed to the exception
	 * @return data
	 */
	public String getData() {
		return data;
	}
}
