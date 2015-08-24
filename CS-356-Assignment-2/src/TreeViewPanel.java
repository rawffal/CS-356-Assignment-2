import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class TreeViewPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private static TreeViewPanel instance = null;
	
	private UserGroup rootGroup;
	private JTree tree;
	private DefaultMutableTreeNode root;
	private DefaultTreeModel model;
	public TreeViewPanel()
	{
		super();
		initialize();
	}
	
	private void initialize()
	{
		rootGroup = new UserGroup("Root");
		root = new DefaultMutableTreeNode(rootGroup);
		model = new DefaultTreeModel(root);
		tree = new JTree(model);
		tree.setBounds(10, 11, 381, 413);
		add(tree);
	}
	
	public static TreeViewPanel getInstance()
	{
		if (instance == null)
		{
			instance = new TreeViewPanel();
		}
		return instance;
	}
	
	public JTree getTree()
	{
		return tree;
	}

}