import java.util.List;

/* Composite Pattern */
public interface User {
	
	public String toString();
	
	public List<User> getFollowing();
	
	public List<User> getFollower();
	
	public List<String> getNewsFeed();
	
	public void addFollowing(User u);
	
	public void addFollowed(User u);
	
	public void addToNewsFeed(String s);

	public UserViewPanel getUserPanel();

	public void setUserPanel(UserViewPanel userViewPanel);


}
