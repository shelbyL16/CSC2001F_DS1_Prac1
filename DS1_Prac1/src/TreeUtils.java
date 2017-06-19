import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode treeStructOne, BinaryTreeNode treeStructTwo) {
	int height1 = treeStructOne.getHeight();
	int height2 = treeStructTwo.getHeight();

	boolean left = false;
	boolean right = false;
	boolean ans = false;

	if (height1 != height2)
	    return false;
	
	//if they give empty nodes
	if (treeStructOne == null && treeStructTwo == null)
	{
	    return false;//tutor said they couldn't be equal
	}
	
	//one empty and other not, cant be similar
	if (treeStructOne== null || treeStructTwo== null)
	{
	    return false;
	}

	//left branches of tree
	if (treeStructOne.hasLeft() != false && treeStructTwo.hasLeft() !=false)
	    {
		left = similar(treeStructOne.getLeft(),treeStructTwo.getLeft());
	    }

	else if (treeStructOne.hasLeft()== false && treeStructTwo.hasLeft() ==false)
	    {
		left = true;
	    }
	
	//right branches of tree
	if (treeStructOne.hasRight() != false && treeStructTwo.hasRight() !=false)
	    {
		right = similar(treeStructOne.getRight(),treeStructTwo.getRight());
	    }

	else if (treeStructOne.hasRight()== false && treeStructTwo.hasRight() ==false)
	    {
		right = true;
	    }

	if (left == true && right == true)
	    ans = true;
	
		
       	return ans;
    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) 
    {
        
	List<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();
        list.add(tNode);
	return list;
    }//end list node
    
    /**
     * Given a list of nodes, obtain the next level. 
     null* 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {
	int len = level.size();
	List<BinaryTreeNode> returnList = new ArrayList<BinaryTreeNode>();
	BinaryTreeNode temp;
        BinaryTreeNode e = BinaryTreeNode.EMPTY_NODE;
	

	for (int i = 0; i<len; i++)
	{
	   
	    temp = level.get(i);

	    if (temp.hasLeft() == true)
	    {
		returnList.add(temp.getLeft());
	    }//end for hasleft true

	    if (temp.hasLeft() == false)
	    {
		returnList.add(e);
	    }//end for hasleft false

	    if (temp.hasRight() == true)
	    {
		returnList.add(temp.getRight());
	    }//end for hasright true

	    if (temp.hasRight() == false)
	    {
		returnList.add(e);
	    }//end for hasRight false
        }//end fori

		return returnList;
    }//end next level
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */
    public static boolean isPlaceHolder(BinaryTreeNode node)
 {
    
     if(node == null)
	 return true;
     else
	 return false;
 }//end place holder
    
}
