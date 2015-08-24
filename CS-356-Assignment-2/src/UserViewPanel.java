
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


public class UserViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField tfUserId;
	private JTextField tfTweetMessage;
	private JTree tree;
	private TreeViewPanel treeView;
	private User user;
	private JList lCurrentFollowing;
	
	private JButton btnFollowUser;
	private JButton btnPostTweet;
	
	private DefaultListModel listModel;   
	
	/**
	 * Create the panel.
	 */
	public UserViewPanel(User user) {
		
		this.user = user;
		tree = TreeViewPanel.getInstance().getTree();
		textFieldSetup();
		buttonSetup();
		actionListenerForAllButtons();
		
		setBounds(100, 100, 351, 406);
		setLayout(null);
		
		lCurrentFollowing = new JList();
		listModel = new DefaultListModel();
		
		lCurrentFollowing = new JList(listModel);
		
		lCurrentFollowing.setBounds(10, 74, 330, 119);
		add(lCurrentFollowing);
		
		JList lNewsFeed = new JList();
		lNewsFeed.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lNewsFeed.setBounds(10, 269, 330, 119);
		add(lNewsFeed);	
		
		JLabel lblNewsFeed = new JLabel("News Feed");
		lblNewsFeed.setBounds(10, 245, 160, 13);
		add(lblNewsFeed);
		
		JLabel lblCurrentFollowing = new JLabel("Current Following");
		lblCurrentFollowing.setBounds(10, 52, 160, 13);
		add(lblCurrentFollowing);
	}
	
	private void textFieldSetup()
	{
		tfUserId = new JTextField();
		tfUserId.setBounds(10, 11, 160, 30);
		tfUserId.setColumns(10);
		add(tfUserId);
		
		tfTweetMessage = new JTextField();
		tfTweetMessage.setColumns(10);
		tfTweetMessage.setBounds(10, 204, 160, 30);
		add(tfTweetMessage);
		
	}
	
	private void buttonSetup()
	{
		btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(180, 204, 160, 30);
		add(btnPostTweet);
		
		btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(180, 11, 160, 30);
		add(btnFollowUser);
	}
	
	private void actionListenerForAllButtons()
	{
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userId = tfUserId.getText();
				System.out.println(userId); //testing
				DefaultMutableTreeNode root = (DefaultMutableTreeNode)tree.getModel().getRoot();
				if (checkForUser(root, userId) == true)
				{
					if (listModel.contains(userId))
					{
						System.out.println("Can't add this user again.");
					}
					else if (userId.equals(user.toString()))
					{
						System.out.println("You can't follow yourself. You'll be chasing your own tail.");
					}
					else
					{
						listModel.addElement(userId);
						lCurrentFollowing = new JList(listModel);
					}
				}
			}
		});
		
	}
	
	public boolean checkForUser(DefaultMutableTreeNode root, String id)
	{
		Enumeration e = root.preorderEnumeration();
		while (e.hasMoreElements())
		{
			if (e.nextElement().toString().equals(id))
			{
				return true;
			}
		}
		
		return false;
	}
	
}
