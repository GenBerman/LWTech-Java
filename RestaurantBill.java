import java.util.Scanner;
/**
 *
 * @author Your name here
 */
public class RestaurantBill{
    /*Write a program that computes tax and tip on a restaurant bill. 
    Ask user to input the bill amount and the tip percentage he/she wants to give to the waiter 
    (as a percent value). The tax should be 10% of the meal cost, and must be set as a constant
     in your code. The tip should be calculated after adding tax. Display the meal cost, tax amount, 
     tip amount, and total bill on the screen.*/
    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        System.out.print("Enter the bill amount: "); //Enter the bill amount:  
    	double bill_amount = keyboard.nextDouble( ); 
        System.out.print("The tip percentage: ");   //Enter the tip percentage: 
        double tip_percentage = (keyboard.nextDouble())/100;
        System.out.print("\n"); //too create a blank line
        System.out.println("The meal cost is: $" + bill_amount);  //The meal cost is:  
        final double tax = 0.1; //set the tax value as a locked 10%
        double tax_amount = bill_amount * tax;
        System.out.println("The tax amount is: $" + tax_amount); //The tax amount is: 
        double tip_amount =  (bill_amount + tax_amount) * tip_percentage;   
        //Math.round(ABC*100)/100) needs to include a double casting to work as intended.
        System.out.println("The tip amount is: $" + (double)Math.round(tip_amount*100)/100); //The tip amount is: 
        double total_bill = bill_amount + tax_amount + tip_amount;
        System.out.println("The total bill is: $" + (double)Math.round(total_bill*100)/100); //The total bill is: 
    }
    
}