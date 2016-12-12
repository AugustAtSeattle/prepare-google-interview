package ValidateBST;

import java.util.Stack;

import DataStructure.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Solution1 InOrder traversal non-recursive
	public boolean checkBST1(TreeNode root){
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode mostLeft = root;
		while(mostLeft != null){
			stack.add(mostLeft);
			mostLeft = mostLeft.left;
		}
		int preValue = Integer.MIN_VALUE;
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(preValue > node.value) return false;
			preValue = node.value;
			
			if( node.right != null){
				mostLeft = node.right;
				while(mostLeft != null){
					stack.add(mostLeft);
					mostLeft = mostLeft.left;
				}
			}
		}
		
		return true;
	}
	
	//Solution2 Inorder traversal recursive way
	Integer preInt = null;
	public boolean checkBST2(TreeNode root){
		if(root == null) return true;
		
		if(checkBST2(root.left) == false) return false;
		
		if(preInt != null && preInt.intValue() > root.value) return false;
		preInt = root.value;
		
		if(checkBST2(root.right) == false) return false;
		
		return true;
		
	}

	//Solution3 using attribute of BST pre <= current < next
	public boolean checkBST3(TreeNode root){
		return checkBST(root, null, null);
	}
	private boolean checkBST(TreeNode root, Integer min, Integer max) {
		if(root == null) return true;
		
		if((min != null && root.value < min) || (max != null && root.value > max)) return false;
		
		return checkBST(root.left, min, root.value) && checkBST(root.right, root.value, max);
	}
}
