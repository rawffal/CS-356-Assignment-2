
public interface Visitor {

	public void acceptVisit(UsersTotalVisitNode totalUsers);
	
	public void acceptVisit(GroupsTotalVisitNode totalGroups);

	public void acceptVisit(MessagesTotalVisitNode totalMessages);

	public void acceptVisit(PositivePercentVisitNode positiveMessages);
	
}
