package stringManipulation;
import java.util.*;
public class Strings2 {
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	//hello lol
	public void string2(String one, String two) {
		
		int same = 0;
		for(int i = 0; i < one.length(); i++) {
			if(map.containsKey(one.substring(i, i+1))) {
				String letter = one.substring(i, i+1);
				map.put(letter, map.get(letter) + 1);
			}
			else {
				map.put(one.substring(i, i+1), 1);
			}
		}
		for(int i = 0; i < two.length(); i++) {
			if(map.containsKey(two.substring(i, i+1))) {
				same++;
			}
		}
		//System.out.println(map);
		//System.out.println(same);
		
		int difference = one.length() - two.length();
		int deletions = 0;
		int insertions = 0;
		
		//System.out.println(difference);
		if(difference > 0) {
			deletions = difference;
			deletions = difference + (two.length() - same);
			int seperate = one.length() - deletions;
			insertions = two.length() - seperate;
		}
		
		if(difference < 0) {
			deletions = one.length() - same;
			//System.out.println(two.length());
			insertions = two.length() - (one.length() - deletions);
		}
		
		if(difference == 0) {
			deletions = one.length() - same;
			insertions = deletions;
		}
		//System.out.println(difference);
		System.out.print("deletions: ");
		System.out.println(deletions);
		System.out.print("insertions: ");
		System.out.println(insertions);
		
	}
	
	public static void main(String[] args) {
		Strings2 test = new Strings2();
		test.string2("hello","ldlo");
	}
}
