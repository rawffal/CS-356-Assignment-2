import java.awt.EventQueue;
import javax.swing.JFrame;

public class Driver extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					sFrame.getInstance();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
