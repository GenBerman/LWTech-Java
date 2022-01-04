import java.util.Scanner;
/**
 *
 * @author Your name here
 */
public class InterestEarned{
    public static void main(String[] args) {
        /*Write a program that asks for the principal, the interest rate, and the number of times the 
        interest is compounded and then calculates the interest amount. 
        The program echo-prints all the information as well as result of calculations into the screen.*/
        Scanner keyboard = new Scanner (System.in);
        System.out.print("Enter the principal balance: "); //Enter the principal balance:
        double principal_balance = keyboard.nextDouble();
        System.out.print("Enter the percent interest rate as a percentage value: "); //Enter the percent interest rate as a percentage value:
        double interest_rate = (keyboard.nextDouble());
        System.out.print("Enter the times compounded per year: "); //Enter the times compounded per year
        int times_compounded = keyboard.nextInt(); 
        System.out.print("\n");
        System.out.println("Interest rate: " + interest_rate + "%"); //Interest rate:
        System.out.println("Times componded: "+ times_compounded); //Times compounded:
        System.out.println("Principal: $" + (double)Math.round(principal_balance*100)/100); //Principal:
        //Amount = Principal*(1 + Rate/T)^T
        double amount_in_savings = principal_balance * Math.pow((1 + ((interest_rate/100)/times_compounded)),times_compounded);
        //Interest amount = amount in savings - principal balance
        double interest_amount = amount_in_savings - principal_balance;
        double rounded_interest_amount = (double)Math.round(interest_amount*100)/100;
        System.out.println("Interest: $" + rounded_interest_amount); //Interest:
        double rounded_amount_in_savings = (double)Math.round(amount_in_savings*100)/100;
        System.out.print("Amount is savings: $" + rounded_amount_in_savings); //Amount in savings:
    }
    
}