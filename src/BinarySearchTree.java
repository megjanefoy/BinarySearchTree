/**************************************************************
 Author: Megan Jane Thompson
 Purpose: This program contains many functions for a BST.
**************************************************************/

public class BinarySearchTree{
	public class BinarySearchTreeNode{
		int key;
		BinarySearchTreeNode left;
		BinarySearchTreeNode right;
		
		BinarySearchTreeNode(int keyVal){
			key = keyVal;
			left = null;
			right = null;
		}
	}
	
	private BinarySearchTreeNode root;
	
	BinarySearchTree(){
		root = null;
	}
	
	public void insert(int key) {}                    //assumed correct and functioning
	public void delete(int key) {}                    //assumed correct and functioning
	public boolean find(int key) {return true;}       //assumed correct and functioning            
	
	/*Assignment 2, Problem 2a*/
	public int positiveKeySum(BinarySearchTreeNode theNode) { 
        int sum = 0;
		if (theNode != null) { 
			if (theNode.key > 0) {
				sum = sum + theNode.key;             //adds sum of all positive keys
			}
        	positiveKeySum(theNode.left); 
            positiveKeySum(theNode.right); 
        }
        return sum;
	}
	
	/*Assignment 2, Problem 2b*/
	public void deleteMax() {
		if (root != null) {
			BinarySearchTreeNode parent = root;
			BinarySearchTreeNode rightChild = parent.right;
			BinarySearchTreeNode rightGrand = rightChild.right;
			
			if (root.right == null) {               //if root is only element
				root = null;                        
			}
			else if (rightGrand == null) {         //if root's right child is max value
				rightChild = null;                  
				parent.right = null;
			}
			else {
				while (rightGrand != null) {        //traverses all right children to find max
					parent = rightChild;
					rightChild = rightGrand;
					rightGrand = rightGrand.right;
				}
				rightChild = null;                 //removes max value
				parent.right = null;               //removes pointer to the deleted value
			}
		}
		
	}
	
	/*Assignment 2, Problem 2c*/
	public void printTree(BinarySearchTreeNode theNode) {
		if (theNode != null) {                      //recursively calls and prints in order
			printTree(theNode.right);
			System.out.print(theNode + " ");
			printTree(theNode.left);
		}
	}
	
	/*Assignment 2, Problem 2d*/
	public void printPostorder(BinarySearchTreeNode theNode) {
		if (theNode != null) {                     //recursively calls and prints in postorder
			printPostorder(theNode.left);
			printPostorder(theNode.right);
			System.out.print(theNode + " ");
		}
	}
}
