import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/*
 * Subject
 */


public class Server extends Observable {

	private ArrayList<Observer> followers; //observers
	
	
	public Server()
	{
		followers = new ArrayList<Observer>();
	}
}
