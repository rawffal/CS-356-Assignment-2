


public interface IStatisticsVisitor {

	String visit(TotalUsers users);
	
	String visit(TotalGroups groups);
	
	String visit(TotalMessages messages);
	
	String visit(TotalPositive positive);
	
}
