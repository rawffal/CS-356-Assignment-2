
/**
 * This class will provide a concrete visitor class that will
 * provide the total numbers for each type of class.
 * @author Charles Chuong
 *
 */
public class TotalDoVisitor implements IStatisticsVisitor {

	@Override
	public String visit(TotalUsers users) {
		// TODO Auto-generated method stub
		return "Total Users: "
				+ AdminControlPanel.getInstance().getUsers().size();
	}

	@Override
	public String visit(TotalGroups groups) {
		// TODO Auto-generated method stub
		return "Total Groups: "
				+ (AdminControlPanel.getInstance().getGroups().size() + 1);
	}

	@Override
	public String visit(TotalMessages messages) {
		// TODO Auto-generated method stub
		String result = Integer.toString(UserViewPanel.getTotalMessages());
		return "Total Messages: " + result;
	}

	@Override
	public String visit(TotalPositive positive) {
		// TODO Auto-generated method stub

		return "Positive Percentage: " + UserViewPanel.getPositivePercentage();
	}

}
