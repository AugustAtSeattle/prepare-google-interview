package FindFriends;

import java.util.*;
import java.io.*;
// on facebook every user had friends, the relationship between friends had weight. 
// find all friends of user whose range of weight between x and y

class User {
	public User(String string) {
		this.name = string;
	}
	public String name;
	public List<Integer> weights = new ArrayList<>();
	public List<User> friends = new ArrayList<>();
	
	public String toString(){
		return this.name;
	}
}
 


// Using Dijktra's Algorithm
public class Solution {
	 
    // Dijkstra's algorithm to find shortest path from s to all other nodes
    public static List<User> findFriends(User user, int distThreshold, int sumWeightThreshold) {
       List<User> result = new LinkedList<User>();
       if(user == null ) return result;
       
       
       HashMap<User,Integer> dist = new HashMap<User,Integer>();  // shortest known distance from "s"
       Set<User> visited = new HashSet<User>(); // all false initially
       dist.put(user, 0);
       
       while(dist.size() != visited.size()){
           User next = null;
           int min = Integer.MAX_VALUE;
           for(Map.Entry<User,Integer> entry: dist.entrySet()){
        	   if(visited.contains(entry.getKey())) continue;
        	   if(min > entry.getValue() ){
        		   next = entry.getKey();
        	   }
           }
           if(next == null) break;
           visited.add(next);
           
           for(int i = 0; i < next.friends.size(); i++){
   
        	   User friend = next.friends.get(i);
        	   int newWeight = next.weights.get(i) + dist.get(next);
        	   if(dist.containsKey(friend)){
        		   if(dist.get(friend) > newWeight) dist.put(friend, newWeight);
        	   }else{
        		   dist.put(friend, newWeight);
        	   }
           }
       }
       
       for(Map.Entry<User, Integer> entry: dist.entrySet()){
    	   
//    	   System.out.println(entry.getKey().name);
//    	   System.out.println(entry.getValue());
//    	   System.out.println();
    	   
    	   if(entry.getValue() > distThreshold && entry.getValue() < sumWeightThreshold){
    		   result.add(entry.getKey());
    	   }
       }
       
       return result;
    }
   
    
    
	public static void main(String[] args) {
		User a = new User("a");
		User b = new User("b");
		User c = new User("c");
		User d = new User("d");
		User e = new User("e");
		User f = new User("f");
		User g = new User("g");
		User h = new User("h");
		User i = new User("i");
		add(a, b, 10);
		add(b, c, 5);
		add(c, d, 10);
		add(a, e, 5);
		add(e, f, 1);
		add(f, g, 5);
		add(g, h, 8);
//		test(a, 2, 7);
		test(a, 3, 7);
//		test(a, 3, 5);
	}


	private static void test(User a, int distThreshold, int sumWeightThreshold) {
		List<User> friends = findFriends(a, distThreshold, sumWeightThreshold);
		System.out.println(friends);
		System.out.println("===================");
	}
	private static void add(User a, User b, int weight) {
		a.friends.add(b);
		b.friends.add(a);
		a.weights.add(weight);
		b.weights.add(weight);
	}
}