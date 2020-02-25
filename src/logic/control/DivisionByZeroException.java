package logic.control;

public class DivisionByZeroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8704622932496184836L;
	
	public DivisionByZeroException() {
		super(DivisionByZeroException.class.getSimpleName());
	}
}
