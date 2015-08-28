import java.util.List;

/**
 * This interface will be used for the Single User and 
 * the User Group class.
 * @author Charles Chuong
 *
 */

/* Composite Pattern */
public interface User {

	public String toString();

	public String getId();

	public List<User> getFollowing();

	public List<User> getFollower();

	public List<String> getNewsFeed();

	public void addFollowing(User u);

	public void addFollowed(User u);

	public void addToNewsFeed(String s);

	public UserViewPanel getUserPanel();

	public void setUserPanel(UserViewPanel userViewPanel);

}
