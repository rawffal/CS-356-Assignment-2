
public class PositivePercentVisitNode implements VisitNode{

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.acceptVisit(new PositivePercentVisitNode());
	}

}
