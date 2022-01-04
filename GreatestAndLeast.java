import java.util.*;
import java.io.*;
public class GreatestAndLeast {
/**
 *
 * @author Your name here
 */    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int greatest = -1;                  //set the default greatest an impossible value
		int least = Integer.MAX_VALUE;      //set the default least the highest value in java
		boolean valid = true;
		while(valid) {
		System.out.print("Enter a positive integer number. Enter -99 to stop input: ");
			int val = sc.nextInt();
			if(val == -99 && greatest == -1 && least == Integer.MAX_VALUE) { //if the greatest and least are unchanged. 
				System.out.println("No numbers were entered");
				return;
			}
			else if(val == -99) break;
			if(val>0) {
				if(val > greatest)    //if value is larger than the current greatest value
				greatest = val;        
				if(val < least)       //if value is less than the current least value
				least = val;
			}
			else System.out.println("ERROR: no negative values other than -99 accepted!");  //if a non positive integer is entered
		}
		System.out.println("the largest number: "+ greatest + "; the smallest number: " + least); //print result
	}
}
