import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 * The Admin Control Panel class will utilize a Singleton pattern scheme.
 * @author Charles Chuong
 */


public class AdminControlPanel extends JPanel {

	private static AdminControlPanel instance = null;
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> users;
	private ArrayList<UserGroup> groups;
	private JTextField tfUserID;
	private JTextField tfGroupID;
	private JLabel lMessage;
	
	private User selectedUser;
	
	private JButton btnMessageTotal;
	private JButton btnPositivePercentage; 
	private JButton btnAddUser;
	private JButton btnAddGroup;
	private JButton btnOpenUserView;
	private JButton btnUserTotal; 
	private JButton btnGroupTotal;
	
	private JTree tree;
	
	private DefaultTreeModel model;
	
	private DefaultMutableTreeNode selectedNode;
	private DefaultMutableTreeNode addUser;
	private DefaultMutableTreeNode addGroup;
	/**
	 * Create the panel.
	 */
	private AdminControlPanel() {
		setLayout(null);
		/* TREE */
		tree = TreeViewPanel.getInstance().getTree();
		this.add(tree);
		initialize();
	}
	
	/* Initialize Widgets */
	private void initialize()
	{
		users = new ArrayList<User>();
		groups = new ArrayList<UserGroup>();
		
		/* Label */
		lMessage = new JLabel("");
		lMessage.setForeground(Color.RED);
		lMessage.setBounds(425, 218, 316, 14);
		add(lMessage);
		
		/* Text Fields */
		tfUserID = new JTextField("");
		tfUserID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfUserID.setBounds(425, 11, 151, 40);
		add(tfUserID);
		tfUserID.setColumns(10);
		
		tfGroupID = new JTextField("");
		tfGroupID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfGroupID.setColumns(10);
		tfGroupID.setBounds(425, 62, 151, 40);
		add(tfGroupID);
		
		/* Buttons */
		btnMessageTotal = new JButton("Show Messages Total");
		btnMessageTotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnMessageTotal.setBounds(425, 384, 151, 40);
		add(btnMessageTotal);
		
		btnPositivePercentage = new JButton("Show Positive Percentage");
		btnPositivePercentage.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPositivePercentage.setBounds(590, 383, 151, 40);
		add(btnPositivePercentage);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAddUser.setBounds(590, 11, 151, 40);
		add(btnAddUser);
		
		btnAddGroup = new JButton("Add Group");
		btnAddGroup.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAddGroup.setBounds(590, 62, 151, 40);
		add(btnAddGroup);
		
		btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnOpenUserView.setBounds(425, 113, 316, 40);
		add(btnOpenUserView);
		
		btnUserTotal = new JButton("Show User Total");
		btnUserTotal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnUserTotal.setBounds(425, 332, 151, 40);
		add(btnUserTotal);
		
		btnGroupTotal = new JButton("Show Group Total");
		btnGroupTotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnGroupTotal.setBounds(590, 332, 151, 40);
		add(btnGroupTotal);
		
		/* Action Listeners for all the Buttons */
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				lMessage.setText("");
				model = (DefaultTreeModel) tree.getModel();
				selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				
				if (selectedNode != null)
				{
					if (!tfUserID.getText().trim().equals(""))
					{
						if (selectedNode.getUserObject() instanceof UserGroup)
						{
							users.add(new User(tfUserID.getText()));
							System.out.println(users); //TESTING
							addUser = new DefaultMutableTreeNode(users.get(users.size() - 1));
							model.insertNodeInto(addUser, selectedNode, selectedNode.getChildCount());
							tfUserID.setText("");
							model.reload();
						}
						else if (selectedNode.getUserObject() instanceof User)
						{
							lMessage.setText("Can't add user within a user baby. Get on my level.");
						}
					}
				}
				else
				{
					lMessage.setText("Please enter a valid User ID");
				}
				
			}
		});
		
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lMessage.setText("");
				model = (DefaultTreeModel) tree.getModel();
				selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (selectedNode != null)
				{
					if (tfGroupID.getText().trim().equals("") == false)
					{
						if (selectedNode.getUserObject() instanceof User)
						{
							lMessage.setText("Can't add group into a user. Scrub");
						}
						else if (selectedNode.getUserObject() instanceof UserGroup)
						{
							groups.add(new UserGroup(tfGroupID.getText()));
							System.out.println("\n" + groups.get(groups.size() - 1)); //TESTING
							addGroup = new DefaultMutableTreeNode(groups.get(groups.size() - 1));
							model.insertNodeInto(addGroup, selectedNode, selectedNode.getChildCount());
							tfGroupID.setText("");
						}
					}
					else
					{
						lMessage.setText("You must enter a Group ID");
					}
				}
				else
				{
					lMessage.setText("You must choose a parent node to insert");
				}
			}
		});
		
		btnOpenUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				
				if (selectedNode != null)
				{
					if (selectedNode.getUserObject() instanceof User)
					{
						//TODO: create a user view frame that refers to the user object
						selectedUser = (User) selectedNode.getUserObject();	
						new UserViewFrame(selectedUser);
					}
					else if (selectedNode.getUserObject() instanceof UserGroup)
					{
						lMessage.setText("Select an User ID. Not a group");
					}
				}		
			}
		});
		
		btnUserTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lMessage.setText("Total of users: " + User.getTotalUsers());
			}
		});
		
		btnGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lMessage.setText("Total of User Groups: " + UserGroup.getGroupCounter());
			}
		});
	}
	
	public ArrayList<User> getUsers()
	{
		return users;
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
