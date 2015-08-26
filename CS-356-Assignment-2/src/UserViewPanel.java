import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;


public class UserViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static UserViewPanel instance = null;
	
	private JFrame frame;
	private JTextField tfUserId;
	private JTextField tfTweetMessage;
	private CompositeUser thisUser;
	
	private JButton btnFollowUser;
	private JButton btnPostTweet;
	
	private JLabel lblMessage;
	
	private static ArrayList<CompositeUser> users = new ArrayList<CompositeUser>(AdminControlPanel.getInstance().getUsers());
	
	private JTextArea taCurrentFollowing;
	private static JTextArea taNewsFeed;
	
	/**
	 * Create the panel.
	 */
	public UserViewPanel(CompositeUser user) {
		
		this.thisUser = AdminControlPanel.getSelectedUser();
		users = new ArrayList<CompositeUser>(AdminControlPanel.getInstance().getUsers());
		
		makeFrame();
		initialize();
		frame.setVisible(true);
		
		System.out.println("User: " +thisUser);
		System.out.println("User in Tree: " + users);
		System.out.println("Following: " + thisUser.getFollowing());
		System.out.println("Who is following me: " + thisUser.getFollowed());
		System.out.println("User's News feed: " + thisUser.getNewsFeed() + "\n");
	}
	
	private void makeFrame() {
		frame = new JFrame(thisUser.toString());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setBounds(100, 100, 366, 521);
		frame.setResizable(false);
		
	}
	
	private void initialize()
	{
		setBounds(100, 100, 351, 462);
		setLayout(null);
		
		/* LABEL */
		JLabel lblNewsFeed = new JLabel("News Feed");
		lblNewsFeed.setBounds(10, 245, 160, 13);
		frame.add(lblNewsFeed);
		
		JLabel lblCurrentFollowing = new JLabel("Current Following");
		lblCurrentFollowing.setBounds(10, 52, 160, 13);
		frame.add(lblCurrentFollowing);
		
		lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(10, 399, 330, 14);
		frame.add(lblMessage);
		
		/* TEXT FIELD */
		tfUserId = new JTextField();
		tfUserId.setBounds(10, 11, 160, 30);
		tfUserId.setColumns(10);
		frame.add(tfUserId);
		
		tfTweetMessage = new JTextField();
		tfTweetMessage.setColumns(10);
		tfTweetMessage.setBounds(10, 204, 160, 30);
		frame.add(tfTweetMessage);
		
		/* BUTTONS */
		btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(180, 204, 160, 30);
		frame.add(btnPostTweet);
		
		btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(180, 11, 160, 30);
		frame.add(btnFollowUser);
		
		/* TEXT AREA */
		taCurrentFollowing = new JTextArea();
		taCurrentFollowing.setBounds(10, 75, 330, 118);
		taCurrentFollowing.append(thisUser.getIDForFollowingUsers());
		frame.add(taCurrentFollowing);
		
		taNewsFeed = new JTextArea();
		taNewsFeed.setBounds(10, 269, 330, 118);
		taNewsFeed.setText(thisUser.getNewsFeedForEachElement());
		frame.add(taNewsFeed);
		
		/* ACTION LISTENER */
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String userID = tfUserId.getText();
				for (int i = 0; i < users.size(); ++i)
				{
					if (users.get(i).toString().equals(thisUser.toString()))
					{
						lblMessage.setText("You can't follow yourself.");
					}
					else if (!(users.toString().contains(userID)))
					{
						lblMessage.setText("Not a valid User ID");
					}
					else if (users.get(i).toString().equals(userID))
					{	
						thisUser.addFollowing(users.get(i));

						taCurrentFollowing.append(users.get(i).toString() + "\n");
						
						lblMessage.setText("You are now following: " + users.get(i));
						break;
					}
				}
			}
		});
		
		btnPostTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String tweet = tfTweetMessage.getText();
				
				thisUser.addToNewsFeed(tweet);
				taNewsFeed.append(thisUser.toString()+ ": " + tweet + "\n");
			}
		});	
	}
	
	public static UserViewPanel getInstance(CompositeUser user) {
		//DEBUG
		System.out.println("Users in the tree: " + users);
		
		if (!(AdminControlPanel.getInstance().getUsers().contains(user))) {
			return null;
		}
		
		return instance = new UserViewPanel(user);
	}
	
	public static JTextArea getNewsFeedText()
	{
		if (taNewsFeed == null)
		{
			taNewsFeed = new JTextArea();
		}
		return taNewsFeed;
	}
	
	
	
}