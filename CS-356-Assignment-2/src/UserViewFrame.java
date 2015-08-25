
import javax.swing.JFrame;	

public class UserViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private UserViewPanel panel;
	
	public UserViewFrame(User user)
	{
		panel = new UserViewPanel(user);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle(user.toString());
		setBounds(100, 100, 366, 521);
		setContentPane(panel);
		setResizable(false);
		setVisible(true);
	}
}
