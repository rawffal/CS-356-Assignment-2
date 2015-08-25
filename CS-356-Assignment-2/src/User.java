import java.util.ArrayList;

/* Composite Pattern */
public interface User {
	
	public String toString();
	
	public ArrayList<CompositeUser> getFollowing();
	
	public ArrayList<CompositeUser> getFollowed();
	
	public ArrayList<String> getNewsFeed();
	
	public void addFollowing(CompositeUser u);
	
	public void addFollowed(CompositeUser u);
	
	public void addToNewsFeed(String s);

}
