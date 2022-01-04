import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.*;
/**
 *
 * @author Your name here
 */
public class RandomsInFile{   //NOT WORKING
/* Generate a list of 100 integers in a given range [???] and store that 
list if a file. Each integer is written on its own line.*/
   public static void main(String[] args) { try {
      // THis does not throw an expection. It only declares one
      Scanner keyboard = new Scanner(System.in);
      
      int start=-1, end=-1;
      boolean validInput = true;
      
      while (validInput) {
         System.out.println("Enter the range of integers: ");
         try {
            System.out.print("Enter minimum integer: ");
            start = Integer.parseInt(keyboard.nextLine());
            if (start < 0) {
               System.out.println("Input ERROR. Number entered was not a positive.");
               continue;
            }
            System.out.print("Enter maximum integer: ");
            end   = Integer.parseInt(keyboard.nextLine());
            if (end < 0) {
               System.out.println("Input ERROR. Number entered was not positive.");
               continue;
            }
         } catch (NumberFormatException E) {
            System.out.println("Input ERROR. Number entered was not an integer.");
            continue;
         }
         if (start >= 0 && end >= 0) {
            validInput = false;
            if (start > end) {
               int tmp = start;
               start = end;
               end = tmp;
            }
         } else {
            System.out.println("Input ERROR. Number entered was not an integer.");
         }
      }
      System.out.print("Enter path to text file: ");
      String path = keyboard.nextLine();
      FileWriter fw = new FileWriter(path, false);
      Random randy = new Random();


      for (int i=0; i<100; i++) {
         int rnd = randy.nextInt(end-start+1) + start;
         fw.write(rnd+"\n");
      }
      fw.close();
   
   } catch (Exception E){
      System.out.println("[-]" + E);
   }
   }

}