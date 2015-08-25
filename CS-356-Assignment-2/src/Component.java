import java.util.ArrayList;


public interface Component {
	
	public String toString();
	
	public ArrayList<User> getFollowing();
	
	public ArrayList<User> getFollowed();
	
	public ArrayList<String> getNewsFeed();
	
	public void addFollowing(User u);
	
	public void addFollowed(User u);
	
	public void addToNewsFeed(String s);

}
