
/**
 * Observer is also a custom made interface for the 
 * User View Panel. This is not the java built in 
 * Observer.
 * @author Charles Chuong
 *
 */

public interface Observer {

	// The observable in this parameter calls the custom made observable
	// not java's observable
	public void update(User user);

}
