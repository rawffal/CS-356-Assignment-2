import java.awt.List;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

/*
 * 1) Unique ID
 * 2) a list of users that are following this id
 * 3) a list of users that the ID is following
 * 4) a news feed list that contains a list of Twitter messages
 */

/*
 * output the percentage of the positive Tweet messages in all the users' news feed
 * (the message containing positive words, such as good, great, excellent, etc.)
 * Free free to decide the positive words.
 */

public class CompositeUser extends Observable implements User, Observer {	
	private static int userCounter = 0;
	private static int messagesTotal = 0;
	private static int positiveCounter = 0;
	
	private String id = null;
	
	private ArrayList<CompositeUser> totalUsers;
	
	private ArrayList<CompositeUser> usersFollowing; //the list of users being followed by this user
	private ArrayList<CompositeUser> followedBy; //the list of users following this user
	private ArrayList<String> newsFeed;
	private final String[] positiveWords = new String[] {"Good", "Great", "Outstanding", "Perfect", 
			"Good Job", "Excellent", "Awesome", "Beautiful",
				"Amazing", "Cool"};
	
	private JTextArea text;
	
	private UserViewPanel userPanel;
	
	public CompositeUser(String id)
	{
		this.id = id;
		
		usersFollowing = new ArrayList<CompositeUser>();
		followedBy = new ArrayList<CompositeUser>();
		newsFeed = new ArrayList<String>();
		++userCounter;
	}
	
	public String toString()
	{
		return this.id;
	}
	
	/* ADDERS */
	//Post a tweet
	public void addToNewsFeed(String message)
	{
		++messagesTotal;
		for (int i = 0; i < positiveWords.length; ++i) {
			if (positiveWords[i].equalsIgnoreCase(message)) {
				++positiveCounter;
			}
		}
		
		newsFeed.add(this.toString() + ": " +  message);
		
		System.out.println(this.toString() + "'s News: " + newsFeed);
		
	}
	
	//Add ppl i want to follow
	//thisUser.addFollowing(user.get(i));
	public void addFollowing(CompositeUser user)
	{
		System.out.println("Inside user class\n User: " + user.toString());
		for (int i = 0; i < usersFollowing.size(); ++i)
		{
			if (usersFollowing.get(i).equals(user))
			{
				System.out.println("You are already following this person.");
			}
		}
		usersFollowing.add(user);
		user.addFollowed(this);
		
		//testing
		System.out.println("User: " +this);
		System.out.println("Following: " + getFollowing());
		System.out.println("Who is following me: " + getFollowed());
		System.out.println("User's News feed: " + getNewsFeed() + "\n");
		
	}
	
	public void addFollowed(CompositeUser user) {
		this.followedBy.add(user);
		
		//TODO: Do something with the observable
//		server.addObserver(user);
	}
	
	/* GETTERS */
	public String getIDForFollowingUsers()
	{
		String result = "";
		for (int i = 0; i < usersFollowing.size(); ++i)
		{
			result += usersFollowing.get(i) + "\n";
		}
		return result;
	}
	
	public ArrayList<String> getNewsFeed()
	{
		return newsFeed;
	}
	
	public String getNewsFeedForEachElement()
	{
		String result = "";
		for (int i = 0; i < newsFeed.size(); ++i)
		{
			result += newsFeed.get(i) + "\n";
		}
		return result;
	}
	
	//Who am i following
	public ArrayList<CompositeUser> getFollowing()
	{
		return usersFollowing;
	}
	
	//Who's following me
	public ArrayList<CompositeUser> getFollowed()
	{
		return followedBy;
	}
	
	public static String getTotalUsers()
	{
		String result = Integer.toString(userCounter);
		return result;
	}

	public static String getTotalMessages()
	{
		String result = Integer.toString(messagesTotal);
		return result;
	}
	
	public static String getPostivePercentage()
	{
		String result = Double.toString((double)(positiveCounter)/(messagesTotal) * 100);
		return result + "%";
	}
	
	public String lastElement()
	{
		return newsFeed.get(newsFeed.size() - 1);
	}
	
	/* NEWSFEED */
	public void updateNewsFeed(ArrayList<String> newsFeed)
	{
		for (int i = 0; i < newsFeed.size(); ++i)
		{
			this.newsFeed.add(newsFeed.get(i));
		}
	}
	
	public void setTextArea(JTextArea textArea)
	{
		this.text = textArea;
	}
	
	public UserViewPanel getUserPanel()
	{
		return this.userPanel;
	}
	
	/* OBSERVABLE METHODS */
	
	
	@Override
	public void update(Observable o, Object arg) 
	{
		String message = arg.toString();
		
		if (arg instanceof String)
		{
			
			//DEBUG
			System.out.println("\nYOU ARE NOW WATCHING MAD TV.......MAD!!");
			
			
//			System.out.println(newsFeed.add(message));
			newsFeed.add(message);
			this.text.setText(message);
			System.out.println(text.getText());
			
		}		
	}
}