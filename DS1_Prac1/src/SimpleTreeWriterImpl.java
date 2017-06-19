import java.io.PrintStream;
import java.math.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleTreeWriterImpl implements SimpleTreeWriter
{

    PrintStream mine;

    public SimpleTreeWriterImpl(PrintStream two)
    {
	mine=two;
    }//end constructor
  
    public void setDestination(PrintStream stream)
    {
	setDestination(stream);
    }
    
     public void write(BinaryTreeNode tree)
    {
	//variables
	List<BinaryTreeNode> nw = new ArrayList<BinaryTreeNode>();
	List <BinaryTreeNode> zero = TreeUtils.levelZero(tree);
	String temp = "";
	String space = "";
	String dash = "";
	String uit = "";
	String lenN = "";
	BinaryTreeNode empty;
	empty = BinaryTreeNode.EMPTY_NODE;
	int len = 0; 
	int spacesCatchUp = 0; 

	//get height of tree
	int height = tree.getHeight();
			
	 //finding out how many leading zeros
	 String large = ""+tree.getLargest();
	 int lenLarge = large.length();
	 
	 //setting spaces right
	 if (lenLarge==1){space = " ";dash = "-";}
	 if (lenLarge==2){space = "  ";dash = "--";}
	 if (lenLarge==3){space = "  ";dash = "---";}
	
	 //obtaining first node ie root
	 String rootItem = ""+tree.getItem();
	 int rootLen = rootItem.length();
		
	   //leading zeros
	   if (rootLen != lenLarge)
	       {
		   int spaces = lenLarge - rootLen;
			
		   for (int i = 0; i<spaces; i++)
		       {
			   temp = "0" + temp;  
		       }//end for loop zero
		   rootItem = rootItem + temp;
	       }//end leading zeros if
		
	   double spaceB = (Math.pow(2,height)-2)/2;
		
		//spaces before for root
		for (int k = 0; k<spaceB; k++)
		{
		    System.out.print(space);
		}//end for 
		System.out.println(rootItem);
		
		//-------------------------------------------------------------------------------------------------------------------------
	 List<BinaryTreeNode> nl = TreeUtils.nextLevel(zero);
	for (int levels=1; levels<height; levels++) 
		    {
		 //spaces in between and before 
		   int spaceBetween = (int)(Math.pow(2,height-levels) - 1); 
		   int frontSpace = (int)((Math.pow(2,height - levels)-1)/2);
		  


		for (int k=0; k<frontSpace; k++)
		{
		    uit = uit + space;
		}
		
		for (int j=0; j<nl.size(); j++)
		{
				
		   if (nl.get(j) == BinaryTreeNode.EMPTY_NODE) 
		   {
		       uit =uit+ space;
		   }

		    else if (nl.get(j) != BinaryTreeNode.EMPTY_NODE)
		    {
			lenN = ""+nl.get(j).getItem();
			temp = "";
			if (lenN.length() != lenLarge) 
			{
			for (int i=0; i<lenLarge-lenN.length(); i++) 
				temp = "0" + temp;
			}
			uit =uit + temp+ ""+nl.get(j).getItem();
			
			}
		    for (int i=0; i<spaceBetween; i++) 
			{
			    if (j%2 == 0)
				{
				    uit =uit+ dash;
				}
			    else
				uit=uit+ space;
			}   
		}
		
		nl = TreeUtils.nextLevel(nl);
		mine.println(uit);
		uit = "";
		temp = "";
	    }
    }//end method
}//end class interface thing