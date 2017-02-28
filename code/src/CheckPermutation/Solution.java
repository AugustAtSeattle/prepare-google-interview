package CheckPermutation;

import java.util.HashMap;
//Question: Given two strings, write a method to decide if one is a permutation of the other

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPermutation(String s, String t){
		if(s == null || t == null) return false;
		if(s.length() != t.length()) return false;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		
		for(int i = 0; i < s.length(); i++){
			char x = s.charAt(i);
			if(map.containsKey(x)){
				map.put(x, map.get(x)+1);
			}else{
				map.put(x, 1);
			}
		}
		
		for(int i = 0; i< t.length(); i++){
			char x = t.charAt(i);
			if(map.containsKey(x)){
				int count = map.get(x);
				if(count == 1){
					map.remove(x);
				}else{
					map.put(x, count -1);
				}
			}else return false;
		}
		
		return true;
	}

}
