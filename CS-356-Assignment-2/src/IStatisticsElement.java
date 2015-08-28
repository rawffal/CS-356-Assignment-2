/**
 * This interface will provide a method that will
 * accept a visitor type.
 * @author Charles Chuong
 *
 */

public interface IStatisticsElement {

	void accept(IStatisticsVisitor visitor);

}
