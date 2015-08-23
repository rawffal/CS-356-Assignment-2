import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The Admin Control Panel class will utilize a Singleton pattern scheme.
 * @author Charles Chuong
 */


public class AdminControlPanel extends JPanel {

	private static AdminControlPanel instance = null;
	
	private static final long serialVersionUID = 1L;
	private JTextField tfUserID;
	private JTextField tfGroupID;
	
	/**
	 * Create the panel.
	 */
	private AdminControlPanel() {
		setLayout(null);
		
		/* Tree View */
		JTree treeView = new JTree();
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Root");
		treeView.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") 
			{
				public void addUser(String id)	
				{
//					add(new DefaultMutableTreeNode("john"));
//					add(new DefaultMutableTreeNode("bob"));
//					add(new DefaultMutableTreeNode("steve"));
					add(new DefaultMutableTreeNode(id));
				}
			}
		));
		treeView.setBounds(10, 11, 383, 413);
		add(treeView);	
		
		/* SCHTUFF */
		
		JButton btnGroupTotal = new JButton("Show Group Total");
		btnGroupTotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGroupTotal.setBounds(590, 332, 151, 40);
		add(btnGroupTotal);
		
		JButton btnUserTotal = new JButton("Show User Total");
		btnUserTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Show User Total");
			}
		});
		btnUserTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnUserTotal.setBounds(425, 332, 151, 40);
		add(btnUserTotal);
		
		JButton btnMessageTotal = new JButton("Show Messages Total");
		btnMessageTotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnMessageTotal.setBounds(425, 384, 151, 40);
		add(btnMessageTotal);
		
		JButton btnPositivePercentage = new JButton("Show Positive Percentage");
		btnPositivePercentage.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPositivePercentage.setBounds(590, 383, 151, 40);
		add(btnPositivePercentage);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAddGroup.setBounds(590, 62, 151, 40);
		add(btnAddGroup);
		
		/* USER ID */
		
		tfUserID = new JTextField("User Id");
		tfUserID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfUserID.setBounds(425, 11, 151, 40);
		add(tfUserID);
		tfUserID.setColumns(10);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User(tfUserID.getText());
				node.add(new DefaultMutableTreeNode(tfUserID.getText()));	
				
			}
		});
		btnAddUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAddUser.setBounds(590, 11, 151, 40);
		add(btnAddUser);
		
		/* GROUP ID */
		tfGroupID = new JTextField("Group Id");
		tfGroupID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfGroupID.setColumns(10);
		tfGroupID.setBounds(425, 62, 151, 40);
		add(tfGroupID);
		
		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserViewFrame.getInstance();
			}
		});
		btnOpenUserView.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnOpenUserView.setBounds(425, 113, 316, 40);
		add(btnOpenUserView);
		
		
		
	}
	
	public static AdminControlPanel getInstance()
	{
		if (instance == null)
		{
			instance = new AdminControlPanel();
		}
		return instance;
	}
}
