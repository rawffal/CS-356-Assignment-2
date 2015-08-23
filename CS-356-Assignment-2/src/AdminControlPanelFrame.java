import javax.swing.JFrame;

/**
 * Sets up Singleton pattern for the frame of Admin Control Panel
 *
 */

public class AdminControlPanelFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static AdminControlPanelFrame instance = null;
	
	private AdminControlPanelFrame() 
	{
		initialize();
	}
	
	private void initialize()
	{
		setTitle("Mini Twitter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 464);
		setContentPane(AdminControlPanel.getInstance());
		
		//Fixed size
		setResizable(false);
		setVisible(true);
	}
	
	public static AdminControlPanelFrame getInstance() 
	{
		if (instance == null)
		{
			instance = new AdminControlPanelFrame();
		}
		
		return instance;
	}

}
