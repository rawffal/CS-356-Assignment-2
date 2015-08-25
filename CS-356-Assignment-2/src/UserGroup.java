import java.util.ArrayList;

public class UserGroup implements User {

	/*
	 * A user group has an unique ID, which can be used to group users. A user group can
		contain any number of users. The same user can only be included in one group. Of
		course, a user group can contain other user groups recursively. There is always a root
		group called Root to include everything.
	 */
	
	private String id = "";
	private ArrayList<CompositeUser> usersInGroup;
	private ArrayList<UserGroup> groupsInGroup;
	private static int groupCounter = 0;
	
	public UserGroup(String id)
	{
		this.id = id;
		usersInGroup = new ArrayList<CompositeUser>();
		groupsInGroup = new ArrayList<UserGroup>();
		++groupCounter;
	}
	
	public void add(CompositeUser user)
	{
		usersInGroup.add(user);
	}
	
	public void addGroup(UserGroup group)
	{
		groupsInGroup.add(group);
	}
	
	public static String getGroupCounter()
	{
		String result = Integer.toString(groupCounter);
		return result;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String toString()
	{
		return id + " Group Folder";
	}

	@Override
	public ArrayList<CompositeUser> getFollowing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CompositeUser> getFollowed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getNewsFeed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFollowing(CompositeUser u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFollowed(CompositeUser u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToNewsFeed(String s) {
		// TODO Auto-generated method stub
		
	}
	
}