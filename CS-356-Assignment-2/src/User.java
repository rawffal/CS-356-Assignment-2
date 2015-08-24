import java.util.ArrayList;
import java.util.HashMap;import java.util.Observable;
import java.util.Observer;


/*
 * 1) Unique ID
 * 2) a list of users that are following this id
 * 3) a list of users that the ID is following
 * 4) a news feed list that contains a list of Twitter messages
 */

public class User extends Observable {

	private static int userCounter = 0;
	
	private String id = null;
	private ArrayList<User> usersFollowing; //list of ids following this user
	private ArrayList<User> usersFollowed; //list of ids followed by this user
	private ArrayList<String> newsFeed;
	
	public User(String id)
	{
		this.id = id;
		usersFollowing = new ArrayList<User>();
		usersFollowed = new ArrayList<User>();
		newsFeed = new ArrayList<String>();
		++userCounter;
	}
	
	public String toString()
	{
		return this.id;
	}
	
	//add users that are followed by this user
	public void addFollowed(User id)
	{
		usersFollowed.add(id);
		notifyObservers(id);
	}
	
	public ArrayList<User> getFollowing()
	{
		return usersFollowing;
	}
	
	public ArrayList<User> getFollowed()
	{
		return usersFollowed;
	}
	
	public ArrayList<String> getNewsFeed()
	{
		return newsFeed;
	}

	public static String getTotalUsers()
	{
		String result = Integer.toString(userCounter);
		return result;
	}

	
	
	
	
}
