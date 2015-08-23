import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


/*
 * 1) Unique ID
 * 2) a list of users that are following this id
 * 3) a list of users that the ID is following
 * 4) a news feed list that contains a list of Twitter messages
 */

public class User extends Observable {

	private String id = null;
	private ArrayList<String> usersFollowing = new ArrayList<String>();
	private ArrayList<String> usersFollowed = new ArrayList<String>();
	private HashMap<String, String> newsFeed = new HashMap<String, String>();
	
	public User(String id)
	{
		this.id = id;
		
	}
	
	public void addFollowing(String id)
	{
		usersFollowing.add(id);
		
	}
	
	public void addFollowed(String id)
	{
		usersFollowed.add(id);
	}
	
	//messages that the user is following
	public void newsFeedList(String id, String message)
	{
		//If bob is the user you are following...
		for (int i = 0; i < usersFollowing.size(); ++i)
		{
			if (usersFollowing.get(i) == id)
			{
				newsFeed.put(id, message);
			}
		}
	}
	
	public ArrayList<String> getFollowing()
	{
		return usersFollowing;
	}
	
	public ArrayList<String> getFollowed()
	{
		return usersFollowed;
	}
	
	public HashMap<String, String> getNewsFeed()
	{
		return newsFeed;
	}
	
	//TODO: choose to follow other users by providing the target USER ID.
	//Subject: users
	//Observer: users following them
	
	
	
	//TODO: post a short Tweet message, so that followers can see this message in their news feed list.
	// User could see its own message.
	
	
}
