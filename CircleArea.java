//import java.io.*;
//import java.util.*;
import java.util.Scanner;
/**
 *
 * @author Your name here
 */
public class CircleArea {
    public static void main(String[] args){
    // ********* Problem 2: Circle Area Problem ***********
    // 1. Declare double constant PI to hold 3.14
    	final double PI = 3.14; // could have saved as Math.PI()
    // 2. Declare a double variable to store radius
    	double radius;
    // 3. Declare a double variable to store area   
    	double area;
    // 4. Prompt the user to enter radius. 
    	Scanner keyboard = new Scanner (System.in);
    // 5. Input radius and store it in variable
    	System.out.print("What is the Radius? ");
    	radius = keyboard.nextDouble( );
    // 6. Calculate circle area. Find the formula on the web if you don't remember it
    	//Circle Area formula: A = PI*radius^2
    	area = PI*(Math.pow(radius, 2));
    // 7. Output the circle's radius and area values in user-friendly fashion
        System.out.println("The radius of the Circle is: " + radius);
    	System.out.print("The area of the Circle is: " + (double)Math.round(area*100)/100);
    // ********* End of Circle Area Problem code area ***********
    }
}
