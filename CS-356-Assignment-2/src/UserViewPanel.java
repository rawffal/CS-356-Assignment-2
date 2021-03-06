import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class will be in effect soon as the user clicks open user
 * view from the Admin Control Panel. This class will contain methods
 * for following users and posting tweets.
 * @author Charles Chuong
 *
 */

public class UserViewPanel implements Observable, Observer {

	private JFrame frame;
	private JTextField tfUserId;
	private JTextField tfTweetMessage;

	private User thisUser;
	private JButton btnPostTweet;
	private JButton btnFollowUser;

	private JLabel lMessage;

	private static List<User> users = new ArrayList<User>();

	private JTextArea taCurrentFollowing;
	private JTextArea taNewsFeed;

	private JLabel lblNewsFeed;
	private JLabel lblCurrentFollowing;

	private final String[] positiveWords = new String[] { "Good", "Great",
			"Outstanding", "Perfect", "Good Job", "Excellent", "Awesome",
			"Beautiful", "Amazing", "Cool", "Nice" };

	private static int totalMessagesCounter = 0;
	private static int totalPositivePercentage = 0;

	/**
	 * Create the panel.
	 */
	private UserViewPanel(User user) {

		this.thisUser = user;
		System.out.println(thisUser.getNewsFeed());
		makeFrame();
		initialize();
		frame.setVisible(true);

	}

	private void makeFrame() {
		frame = new JFrame(thisUser.toString());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setBounds(100, 100, 366, 521);
		frame.setResizable(false);

	}

	private void initialize() {
		/* LABEL */
		lblNewsFeed = new JLabel("News Feed");
		lblNewsFeed.setBounds(10, 245, 160, 13);
		frame.getContentPane().add(lblNewsFeed);

		lblCurrentFollowing = new JLabel("Current Following");
		lblCurrentFollowing.setBounds(10, 52, 160, 13);
		frame.getContentPane().add(lblCurrentFollowing);

		lMessage = new JLabel("");
		lMessage.setForeground(Color.RED);
		lMessage.setBounds(10, 399, 330, 14);
		frame.getContentPane().add(lMessage);

		/* TEXT FIELD */
		tfUserId = new JTextField();
		tfUserId.setBounds(10, 11, 160, 30);
		tfUserId.setColumns(10);
		frame.getContentPane().add(tfUserId);

		tfTweetMessage = new JTextField();
		tfTweetMessage.setColumns(10);
		tfTweetMessage.setBounds(10, 204, 160, 30);
		frame.getContentPane().add(tfTweetMessage);

		/* BUTTONS */
		btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(180, 204, 160, 30);

		btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(180, 11, 160, 30);

		/* TEXT AREA */
		taCurrentFollowing = new JTextArea();
		JScrollPane scrollFollowing = new JScrollPane(taCurrentFollowing);
		scrollFollowing.setBounds(10, 75, 330, 118);
		frame.getContentPane().add(scrollFollowing);

		taNewsFeed = new JTextArea();
		JScrollPane scrollNews = new JScrollPane(taNewsFeed);
		scrollNews.setBounds(10, 269, 330, 118);
		frame.getContentPane().add(scrollNews);

		/* ACTION LISTENER */
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userToFollow();

			}

		});
		frame.getContentPane().add(btnFollowUser);

		btnPostTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeTweetPost();

			}
		});
		frame.getContentPane().add(btnPostTweet);

		frame.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent e) {
				users.remove(thisUser);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});

		// UPDATES THIS PANEL
		update(thisUser);
		updateTextFollowingUser();
	}

	public void updateFollowers(String message) {

		List<User> followers = new ArrayList<User>();

		System.out.println(thisUser.toString() + "'s followers: "
				+ thisUser.getFollower());

		for (int i = 0; i < thisUser.getFollower().size(); ++i) {
			followers.add(thisUser.getFollower().get(i));
			System.out.println(thisUser + " followers: " + followers.get(i));
		}

		for (int i = 0; i < followers.size(); ++i) {
			followers.get(i)
					.addToNewsFeed(thisUser.toString() + ": " + message);
			followers.get(i).getUserPanel().update(thisUser);
		}
	}

	// Add followers
	private void userToFollow() {

		String userId = tfUserId.getText();
		User userFound = null;
		if (userId.equals("")) {
			lMessage.setText("Please enter an user id. ");
		} else {
			lMessage.setText("");
			if (userId.equals(thisUser.toString())) {
				lMessage.setText("You have to follow someone else. Not yourself.");
				return;
			} else {
				List<User> list = AdminControlPanel.getInstance().getUsers();

				for (int i = 0; i < thisUser.getFollowing().size(); ++i) {
					if (thisUser.getFollowing().get(i).toString()
							.equals(userId)) {
						lMessage.setText("You are already following that user");
						return;
					}
				}

				for (int i = 0; i < list.size(); ++i) {
					if (list.get(i).toString().equals(userId)) {
						userFound = list.get(i);
						break;
					}
				}
			}
		}
		if (userFound != null) {
			thisUser.addFollowing(userFound);
			userFound.addFollowed(thisUser);
			tfUserId.setText("");

			updateTextFollowingUser();
		}
	}

	public void makeTweetPost() {
		String tweet = tfTweetMessage.getText();

		if (tweet.equals("")) {
			lMessage.setText("Please enter a message");
		} else if (!tweet.equals("")) {
			thisUser.addToNewsFeed(thisUser.toString() + ": " + tweet);
			update(thisUser);
			tfTweetMessage.setText("");
			updateFollowers(tweet);
		}
		++totalMessagesCounter;
		for (int i = 0; i < positiveWords.length; ++i) {
			if (positiveWords[i].equalsIgnoreCase(tweet)) {
				++totalPositivePercentage;
			}
		}
	}

	public void updateTextFollowingUser() {
		String followingUsers = "";
		List<User> following = thisUser.getFollowing();
		for (int i = 0; i < following.size(); ++i) {
			followingUsers += following.get(i) + "\n";
		}
		taCurrentFollowing.setText(followingUsers);
	}

	public static UserViewPanel getInstance(User user) {

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).equals(user)) {
				return user.getUserPanel();
			}
		}

		user.setUserPanel(new UserViewPanel(user));
		users.add(user);

		return user.getUserPanel();
	}

	// UserViewPanel is the Observable
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

		String message = "";
		List<String> newsFeed = thisUser.getNewsFeed();

		for (int i = 0; i < newsFeed.size(); ++i) {
			message += newsFeed.get(i) + "\n";
			taNewsFeed.setText(message);
		}
	}

	public static int getTotalMessages() {
		return totalMessagesCounter;
	}

	public static String getPositivePercentage() {

		if (totalPositivePercentage == 0 || getTotalMessages() == 0) {
			return "0%";
		}

		String result = Double.toString((double) (totalPositivePercentage)
				/ (getTotalMessages()) * 100);
		return result + "%";
	}
}