package IsUnique;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isUniqueChars(String str){
		if(str == null) return false;
		if(str.length() > 128) return false;
		
		boolean[] charArray = new boolean[128];
		for(int i = 0; i< str.length(); i++){
			int val = str.charAt(i);
			if(charArray[val] == true) return false;
			charArray[val] = true;
		}
		
		return true;
	}

}
