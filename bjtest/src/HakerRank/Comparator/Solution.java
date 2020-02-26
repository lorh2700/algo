package HakerRank.Comparator;

import java.awt.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}


//5
//amy 100
//david 100
//heraldo 50
//aakansha 75
//aleksa 150

//out
//aleksa 150
//amy 100
//david 100
//aakansha 75
//heraldo 50

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {		
		//a < b = -1
		//a==b  = 0
		//a > b = 1 		
		if(a.score > b.score) {
			return -1;
		} else if(a.score < b.score) {
			return 1;
		} else {
	        if(a.name.compareTo(b.name) < 0){
	            return -1;
	        }
	        else if(a.name.compareTo(b.name) > 0){
	            return 1;
	        }
	        return 0;	          
		}
    }
}


public class Solution {
	
	public static void main(String[] args) {
		
		Player p2 = new Player("aleksa", 150);
		Player p = new Player("amy", 100);
		
		
		Player[] tmpList = new Player[2];
		tmpList[0] = p;
		tmpList[1] = p2;
		
        Checker checker = new Checker();
        
        Arrays.sort(tmpList, checker);
        
        System.out.println(tmpList[0].name);
		
	}
}
