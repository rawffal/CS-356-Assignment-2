
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private User thisUser;
	
	private JList lCurrentFollowing;
	private JList lNewsFeed;
	
	private JButton btnFollowUser;
	private JButton btnPostTweet;
	
	private DefaultListModel listModelFollow;
	private DefaultListModel listModelNews;
	
	private DefaultMutableTreeNode root; 
	
	private ArrayList<User> users;
	
	/**
	 * Create the panel.
	 */
	public UserViewPanel(User user) {
		
		this.thisUser = user;
		users = new ArrayList<User>();
		initialize();
		
		setBounds(100, 100, 351, 406);
		setLayout(null);
		
		
	}
	
	private void initialize()
	{
		/* LABEL */
		JLabel lblNewsFeed = new JLabel("News Feed");
		lblNewsFeed.setBounds(10, 245, 160, 13);
		add(lblNewsFeed);
		
		JLabel lblCurrentFollowing = new JLabel("Current Following");
		lblCurrentFollowing.setBounds(10, 52, 160, 13);
		add(lblCurrentFollowing);
		
		/* TEXT FIELD */
		tfUserId = new JTextField();
		tfUserId.setBounds(10, 11, 160, 30);
		tfUserId.setColumns(10);
		add(tfUserId);
		
		tfTweetMessage = new JTextField();
		tfTweetMessage.setColumns(10);
		tfTweetMessage.setBounds(10, 204, 160, 30);
		add(tfTweetMessage);
		
		/* BUTTONS */
		btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(180, 204, 160, 30);
		add(btnPostTweet);
		
		btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(180, 11, 160, 30);
		add(btnFollowUser);
		
		/* LIST */
		lCurrentFollowing = new JList();
		listModelFollow = new DefaultListModel();
		lCurrentFollowing = new JList(listModelFollow);
		lCurrentFollowing.setBounds(10, 74, 330, 119);
		add(lCurrentFollowing);
		
		lNewsFeed = new JList();
		listModelNews = new DefaultListModel();
		lNewsFeed = new JList(listModelNews);
		lNewsFeed.setBounds(10, 269, 330, 119);
		add(lNewsFeed);	
		
		/* ACTION LISTENER */
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String userID = tfUserId.getText();
				users = new ArrayList<User>(AdminControlPanel.getInstance().getUsers());
				
//				System.out.println("\n" + users);
//				System.out.println("This User: " + thisUser); //testing
				for (int i = 0; i < users.size(); ++i)
				{
					if (users.get(i).toString().equals(thisUser.toString()))
					{
//						System.out.println("Current user in list: " + users.get(i).toString());
						System.out.println("You can't follow yourself.");
						continue;
					}
					else if (!(users.toString().contains(userID)))
					{
//						System.out.println("Current user in list: " + users.get(i).toString());
						System.out.println("Not a valid User ID");
						continue;
					}
					else if (users.get(i).toString().equals(userID))
					{	
						thisUser.addFollowing(users.get(i));
						users.get(i).addFollowed(thisUser);
						listModelFollow.addElement(userID);
						lCurrentFollowing = new JList(listModelFollow);
						break;
					}
				}
			}
		});
		
		btnPostTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String tweet = tfTweetMessage.getText();
				
			}
		});
		
	}
}
