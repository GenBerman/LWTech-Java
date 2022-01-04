
/**
 *
 * @author Your name here
 */
import java.util.Scanner;  // Needed for the Scanner class

public class InputValidation{
  /* Except an integer value and a double value, begin prepared to 
    accept an Exception in receiving both values and answering accordingly */
   public static void main(String[] args){
      String str;
      int a = 0;
      double num = 0;
      
      Scanner keyboard = new Scanner(System.in);  // Create a Scanner object to read input.
      
      boolean again = true;
      while(again){ // input validation loop
        System.out.print("Enter an integer number please: ");
        str = keyboard.nextLine();            // get a string containing an integer number
        str = str.trim();                     // remove any extra whitespace
        try{    // trying to convert string to integer, expecting exceptions
          a  = Integer.parseInt(str);         // convert from string to integer 
          again =  false;                     // stop input validation loop
        }catch (Exception e){
          System.out.println("INPUT ERROR: Please enter an integer number!!"); 
          System.out.println(e.getMessage());
        }
      } // end of validation loop

      again = true;
      while(again){ // input validation loop
        System.out.print("Enter a floating point number please: ");
        str = keyboard.nextLine();            // get a string containing a double number
        str = str.trim();                     // remove any extra whitespace
        try{    // trying to convert string to double, expecting exceptions
          num  = Double.parseDouble(str);     // convert from string to double. 
          again =  false;                     // stop input validation loop
        }catch (Exception e){
          System.out.println("INPUT ERROR: Please enter a floating point number!!"); 
          System.out.println(e.getMessage());
        }
      } // end of validation loop
      
      // User input ready for use
     System.out.println("\nThe integer number you entered is: "+a);
     System.out.println("\nThe double number you entered is: "+num);
   }
}

