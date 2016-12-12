package ListOfDepths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import DataStructure.TreeNode;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Solution1 DFS Recursion
	public List<List<TreeNode>> createLevelLinkedList1(TreeNode root){
		List<List<TreeNode>> list = new ArrayList<List<TreeNode>>();
		if(root == null) return list;
		createLevelLinkedList(root, list, 0);
		
		return list;
	}

	private void createLevelLinkedList(TreeNode root, List<List<TreeNode>> list, int level) {
		if(root == null) return;
		
		if(list.size() == level){
			LinkedList<TreeNode> subList = new LinkedList<TreeNode>();
			subList.add(root);
			list.add(subList);
		}else{
			list.get(level).add(root);
		}
		createLevelLinkedList(root.left, list, level + 1);
		createLevelLinkedList(root.right, list, level + 1);
	}

	//Solution2 BFS
	public List<List<TreeNode>> createLevelLinkedList(TreeNode root){
		List<List<TreeNode>> list = new LinkedList<List<TreeNode>>();
		if(root == null) return list;
		LinkedList<TreeNode> curList = new LinkedList<TreeNode>();
		curList.add(root);
		
		while(!curList.isEmpty()){
			list.add(curList);
			LinkedList<TreeNode> nextList = new LinkedList<TreeNode>();
			
			for(TreeNode node : curList){
				if(node.left != null)
					nextList.add(node.left);
				if(node.right != null)
					nextList.add(node.right);
			}
			
			curList = nextList;
		}
		
		
		return list;
	}
}


