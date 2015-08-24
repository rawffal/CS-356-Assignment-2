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
	private ArrayList<User> usersFollowing; //the list of users being followed by this user
	private ArrayList<User> followedBy; //the list of users following this user
	private ArrayList<String> newsFeed;
	
	public User(String id)
	{
		this.id = id;
		usersFollowing = new ArrayList<User>();
		followedBy = new ArrayList<User>();
		newsFeed = new ArrayList<String>();
		++userCounter;
	}
	
	public String toString()
	{
		return this.id;
	}
	
	//Add ppl i want to follow
	//thisUser.addFollowing(user.get(i));
	public void addFollowing(User user)
	{
		System.out.println("Inside user class\n User: " + user.toString());
		if (usersFollowing.contains(user))
		{
			System.out.println("You are already following this person");
		}
		else
		{
			usersFollowing.add(user);
			System.out.println(" You are now following: " + user.toString());
		}
	}
	
	public void addFollowed(User user)
	{
		
		if (followedBy.contains(user))
		{
			System.out.println("You are already following this person");
		}
		else
		{
			followedBy.add(user);
			System.out.println(user.toString() + " is now following " + this.toString());
		}
	}
	//Who am i following
	public ArrayList<User> getFollowing()
	{
		return usersFollowing;
	}
	
	//Who's following me
	public ArrayList<User> getFollowed()
	{
		return followedBy;
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
