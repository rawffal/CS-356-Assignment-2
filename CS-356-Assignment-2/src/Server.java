import java.util.Observable;

import javax.swing.JTextArea;

/*
 * Subject
 */

/*
 * ¿ A Subject (object being observed) maintains a list of
	observers
	
¿ Observers get added to that list by subscribing to the
	subject
	
¿ Observers implement a common interface (an update()
	method)
	
¿ When a change occurs, the Subject iterates through the list
	of Observers and calls the update() method on them
 */

public class Server extends Observable {
	
	private String message = "";
	
	public Server()
	{
		message = "";
	}
	
	public void setTweet(String message)
	{
		this.message = message;
		setChanged();
		notifyObservers(message);
		
	}
	
	
}
