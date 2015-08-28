import java.util.List;
import java.util.ArrayList;

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

public class CompositeUser implements User {
	private static int userCounter = 0;
	private static int messagesTotal = 0;
	private static int positiveCounter = 0;

	private String id = null;
	private List<User> usersFollowing; // the list of users being followed by
										// this user
	private List<User> followedBy; // the list of users following this user
	private List<String> newsFeed;
	private final String[] positiveWords = new String[] { "Good", "Great",
			"Outstanding", "Perfect", "Good Job", "Excellent", "Awesome",
			"Beautiful", "Amazing", "Cool" };

	private UserViewPanel userPanel;

	public CompositeUser(String id) {
		this.id = id;
		usersFollowing = new ArrayList<User>();
		followedBy = new ArrayList<User>();
		newsFeed = new ArrayList<String>();
		++userCounter;
	}

	public String toString() {
		return this.id;
	}

	/* ADDERS METHODS */
	public void addToNewsFeed(String message) {
		++messagesTotal;
		for (int i = 0; i < positiveWords.length; ++i) {
			if (positiveWords[i].equalsIgnoreCase(message)) {
				++positiveCounter;
			}
		}

		this.newsFeed.add(message);

	}

	public void addFollowing(User user) {

		this.usersFollowing.add(user);
		
	}

	public void addFollowed(User u) {
		// TODO Auto-generated method stub
		this.followedBy.add(u);
	}

	/* GETTERS METHODS */

	public List<String> getNewsFeed() {
		return newsFeed;
	}

	// Who am i following
	public List<User> getFollowing() {
		return usersFollowing;
	}

	// Who's following me
	public List<User> getFollower() {
		return followedBy;
	}

	public static String getTotalUsers() {
		String result = Integer.toString(userCounter);
		return result;
	}

	public static String getTotalMessages() {
		String result = Integer.toString(messagesTotal);
		return result;
	}

	public static String getPostivePercentage() {
		String result = Double.toString((double) (positiveCounter)
				/ (messagesTotal) * 100);
		return result + "%";
	}

	public void setUserPanel(UserViewPanel userPanel) {
		this.userPanel = userPanel;
	}

	public UserViewPanel getUserPanel() {
		return this.userPanel;
	}

}