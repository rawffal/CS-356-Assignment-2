import javax.swing.JFrame;

/**
 * Sets up Singleton pattern for the frame.
 *
 */

public class sFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static sFrame instance = null;
	
	private sFrame() 
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
	
	public static sFrame getInstance() 
	{
		if (instance == null)
		{
			instance = new sFrame();
		}
		
		return instance;
	}

}
