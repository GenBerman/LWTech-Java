import java.util.Scanner;
/**
 *
 * @author Your name here
 */
public class MathTutor {
    //Display the given choices of the Menu
    static void displayChoices() {
        System.out.println("Math Tutor"); //Math Tutor
        System.out.println("1. Addition problem");      //1. Addition problem
        System.out.println("2. Subtraction Problem");   //2. Subtraction problem
        System.out.println("3. Quit");                  //3. Quit
        System.out.print("Enter you choice (1 - 3): "); //Enter your choice (1 – 3):
    }

    //Display the format of the problem
    static int displayProblem(int flag) {
        //calculate two random numbers
        int num1 = (int)(999*Math.random());
        int num2 = (int)(999*Math.random());
        //Determine the larger and smaller number of the two numbers.
        int top = Math.max(num1, num2);
        int bot = Math.min(num1, num2);
        //Display the format of the problem with the larger number of the two on top
        System.out.printf("%6d\n", top);
        System.out.printf("%c %4d\n", (flag == 1) ? '+' : '-', bot);
        System.out.println("------");

        return (flag == 1) ? num1 + num2 : top - bot;
    }

    //Accept the scanner input as an integer value.     
    static int getInput(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch(NumberFormatException E) {
            // System.out.println(E);
            return -1;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int answer;
        do {
            displayChoices();
            choice = getInput(sc);
            //If the given number choice is within the excepted limit
            if (1 <= choice && choice <= 3) {
                if (choice == 3) {
                    System.out.println("System shutting down...");
                    System.exit(0);
                }
                answer = displayProblem(choice);
                
                choice = getInput(sc);
                //If the given number choice is not within the excepted limit
                if (choice == -1) {
                    System.out.println("Incorrect input type...");
                }
                //If the given answer is correct
                else if (choice == answer)
                    System.out.println("Correct!");
                //If the given answer is incorrect
                else {
                    System.out.println("Not correct! The answer is " + answer);
                }  
            //If the given number choice is not within the excepted limit of choice options
            } else {
                System.out.println("Error! Try again.");
            }
        } while (true);
    }
}