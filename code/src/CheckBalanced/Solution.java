package CheckBalanced;

import DataStructure.TreeNode;

public class Solution {
	
	//Solution 1 recursion
	public boolean isBalanced(TreeNode root){
		if(root == null) return true;
		
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1) return false;
		
		return isBalanced(root.left)&&isBalanced(root.right);
	}
	
	public int getHeight(TreeNode root){
		if(root == null) return 0;
		else return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	//Solution 2 optimize
	public boolean isBalanced2(TreeNode root){
		return isBalancedHelper(root) == Integer.MIN_VALUE;
	}
	
	public int isBalancedHelper(TreeNode root)
	{
		if(root == null) return 0;
		
		int leftHeight = isBalancedHelper(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = isBalancedHelper(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if(heightDiff > 1) return Integer.MIN_VALUE;
		
		return Math.max(isBalancedHelper(root.left) , isBalancedHelper(root.right)) + 1;
	}
}
