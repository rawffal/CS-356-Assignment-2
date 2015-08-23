
import javax.swing.JFrame;

public class UserViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static UserViewFrame instance = null;
	
	private UserViewFrame()
	{
		setLayout(null);
		setTitle("Cat is out of the bag");
		setBounds(100, 100, 480, 432);
		setContentPane(UserViewPanel.getInstance());
		setResizable(false);
		setVisible(true);
	}

	public static UserViewFrame getInstance()
	{
		if (instance == null)
		{
			instance = new UserViewFrame();
		}
		
		return instance;
	}
	
}
