import java.util.ArrayList;
import java.util.List;


public class TotalDoVisitor implements IStatisticsVisitor {

	@Override
	public String visit(TotalUsers users) {
		// TODO Auto-generated method stub
		return "Total Users: " + AdminControlPanel.getInstance().getUsers().size();
	}

	@Override
	public String visit(TotalGroups groups) {
		// TODO Auto-generated method stub
		return "Total Groups: " + (AdminControlPanel.getInstance().getGroups().size() + 1);
	}

	@Override
	public String visit(TotalMessages messages) {
		// TODO Auto-generated method stub
//		List<User> user = (ArrayList<User>) AdminControlPanel.getInstance().getUsers();
//		List<String> tweets = new ArrayList<String>();
//		int total = 0;
//		for (int i = 0; i < user.size(); ++i) {
//			 tweets = (ArrayList<String>) user.get(i).getNewsFeed();
//			 total += tweets.size();
//		}
//			
//		return "Total messages: " + total;
		return null;
	}

	@Override
	public String visit(TotalPositive positive) {
		// TODO Auto-generated method stub
//		String[] positiveWords = new String[]{"Good", "Great", "Outstanding", "Perfect", 
//											"Good Job", "Excellent", "Awesome", "Beautiful",
//												"Amazing", "Cool"};
//		List<User> user = (ArrayList<User>) AdminControlPanel.getInstance().getUsers();
//		List<String> messages = new ArrayList<String>();
//		List<String> tweets = new ArrayList<String>();
//		int total = 0, totalSize = 0;
//		for (int i = 0; i < user.size(); ++i)
//		{
//			tweets = (ArrayList<String>) user.get(i).getNewsFeed();
//			totalSize += tweets.size();
//			for (int j = 0; j < tweets.size(); ++j)
//			{
//				messages.add(tweets.get(j));
//			}	
//		}
//		
//		for (int i = 0; i < positiveWords.length; ++i)
//		{
//			for (int j = 0; j < messages.size(); ++j)
//			{
//				String currentMessage = messages.get(j);
//				String currentWord = positiveWords[i];
//				
//				if (currentMessage.equalsIgnoreCase(currentWord)) {
//					total++;
//				}
//			}
//		}
//		String result = Double.toString((double)(total)/(totalSize) * 100);
//		
//		return "Positive Percentage: " + result;
		return null;
	}

}
