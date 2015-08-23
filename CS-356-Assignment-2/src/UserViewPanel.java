import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static UserViewPanel instance = null;
	
	private JTextField tfUserId;
	private JTextField tfTweetMessage;

	/**
	 * Create the panel.
	 */
	private UserViewPanel() {
		
		setBounds(100, 100, 351, 406);
		setLayout(null);
		
		tfUserId = new JTextField();
		tfUserId.setText("User Id");
		tfUserId.setBounds(10, 11, 160, 30);
		add(tfUserId);
		tfUserId.setColumns(10);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User(tfUserId.getText());
				user.addFollowing(tfUserId.getText());
				
			}
		});
		btnFollowUser.setBounds(180, 11, 160, 30);
		add(btnFollowUser);
		
		JList lCurrentFollowing = new JList();
		lCurrentFollowing.setModel(new AbstractListModel() {
			String[] values = new String[] {"List View (Current Following)", "-Bob", "-Steve"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lCurrentFollowing.setBounds(10, 50, 330, 143);
		add(lCurrentFollowing);
		
		tfTweetMessage = new JTextField();
		tfTweetMessage.setText("Tweet Message");
		tfTweetMessage.setColumns(10);
		tfTweetMessage.setBounds(10, 204, 160, 30);
		add(tfTweetMessage);
		
		JButton btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(180, 204, 160, 30);
		add(btnPostTweet);
		
		JList lNewsFeed = new JList();
		lNewsFeed.setModel(new AbstractListModel() {
			String[] values = new String[] {"List View (News Feed)", "-Bob: Horror night is good", "-Steve: CS356 is cool", "-Bob: Class registration starts"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lNewsFeed.setBounds(10, 245, 330, 143);
		add(lNewsFeed);	
	}
	
	public static UserViewPanel getInstance()
	{
		if (instance == null)
		{
			instance = new UserViewPanel();
		}
		return instance;
	}
	
}
