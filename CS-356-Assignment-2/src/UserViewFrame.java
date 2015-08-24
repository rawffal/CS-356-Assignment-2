
import javax.swing.JFrame;	

public class UserViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public UserViewFrame(User user)
	{
		setLayout(null);
		setTitle(user.toString());
//		setDefaultCloseOperation(UserViewFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 432);
		setContentPane(new UserViewPanel(user));
		setResizable(false);
		setVisible(true);
	}

	
}
