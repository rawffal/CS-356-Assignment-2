/**
 * Instead of using the java built in Observable, I made
 * a custom Observable interface to be used for the UserViewPanel
 * when changes are made to the users.
 * 
 * @author Charles Chuong
 *
 */

public interface Observable {

	public void updateFollowers(String message);

	public void updateTextFollowingUser();

}
