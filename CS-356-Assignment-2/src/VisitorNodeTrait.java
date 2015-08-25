import java.util.ArrayList;


public class VisitorNodeTrait implements Visitor {

	@Override
	public void acceptVisit(UsersTotalVisitNode totalUsers) {
		// TODO Auto-generated method stub
		ArrayList<User> users = (ArrayList<User>) AdminControlPanel.getInstance().getUsers();
		System.out.println(("Total number of users is " + users.size()));
	}

	@Override
	public void acceptVisit(GroupsTotalVisitNode totalGroups) {
		// TODO Auto-generated method stub
		ArrayList<UserGroup> group = (ArrayList<UserGroup>) AdminControlPanel.getInstance().getGroups();
		System.out.println("Total groups: " + (group.size() + 1));
	}

	@Override
	public void acceptVisit(MessagesTotalVisitNode totalMessages) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptVisit(PositivePercentVisitNode positiveMessages) {
		
	}

	
	
}
