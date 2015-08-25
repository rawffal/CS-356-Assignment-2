
import javax.swing.JFrame;	

public class UserViewFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private UserViewPanel panel;
	
	public UserViewFrame(CompositeUser user)
	{
		panel = new UserViewPanel();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle(AdminControlPanel.getSelectedUser().toString());
		setBounds(100, 100, 366, 521);
		setContentPane(panel);
		setResizable(false);
		setVisible(true);
	}
}
