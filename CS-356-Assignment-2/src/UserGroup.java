import java.util.ArrayList;

public class UserGroup {

	/*
	 * A user group has an unique ID, which can be used to group users. A user group can
		contain any number of users. The same user can only be included in one group. Of
		course, a user group can contain other user groups recursively. There is always a root
		group called Root to include everything.
	 */
	
	private String id = "";
	private ArrayList<User> usersInGroup;
	private ArrayList<UserGroup> groupsInGroup;
	private static int groupCounter = 0;
	
	public UserGroup(String id)
	{
		this.id = id;
		usersInGroup = new ArrayList<User>();
		groupsInGroup = new ArrayList<UserGroup>();
		++groupCounter;
	}
	
	public void add(User user)
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
	
}