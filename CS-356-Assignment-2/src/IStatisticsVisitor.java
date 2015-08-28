
/**
 * This interface will use the Visitor Pattern which will
 * tally up the total number of users, groups, messages,
 * and positive messages for display.
 * @author Charles Chuong
 *
 */

public interface IStatisticsVisitor {

	String visit(TotalUsers users);

	String visit(TotalGroups groups);

	String visit(TotalMessages messages);

	String visit(TotalPositive positive);

}
