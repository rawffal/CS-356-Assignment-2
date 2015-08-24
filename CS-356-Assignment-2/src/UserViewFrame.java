
import javax.swing.JFrame;
import javax.swing.JTree;

public class UserViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private User user;
	private JTree tree;
	
	public UserViewFrame(User user)
	{
		this.user = user;
		setLayout(null);
		setTitle(user.toString());
		setBounds(100, 100, 480, 432);
		setContentPane(new UserViewPanel(user));
		setResizable(false);
		setVisible(true);
	}

	
}
