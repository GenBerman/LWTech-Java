import java.util.Scanner;

/**
 *
 * @author Your name here
 */
public class NumericPatternMenu {
	/**
	 * If the boolean is true, the string first increases to the size from 1,
	 * then decreases back to one in increments of 1. If the boolean is false,
	 * the string starts at the size, decreases to 1, then increases to the size
	 * again; all in increments of 1.
	 *   Example: numericPattern(5, true) returns string 123454321
	 *   Example: numericPattern(5, false) returns string 543212345
	 * 
	 * @param size The positive integer that determines the scale of the printed pattern
	 * @param direction	The boolean value that determines the direction of the printed pattern: small-size-small or size-small-size
	 * @return
	 */
  public static String numericPattern(int size, boolean direction){ 
        if (size <= 0) //If the size if negative or zero; being impossible.
            throw new IllegalArgumentException(); 
        String retval = ""; 	// Value to return at end
        int i; 					// value for indexing across string nums, because the value is being used across multiple loops
        if (direction) { //small-size-small
            for (i=1; i<size; i++) { 	// prints values from 1 to size
                retval = retval + i;
            }
            for (; i >=1 ; i--) { 		// prints values from size to 1
                retval = retval+i;
            }
        } else { //size-small-size
            for (i=size; i > 1 ; i--) { // prints values from size to 1
                retval = retval+i;
            }
            for (; i<=size; i++) { 		// prints values from 1 to size
                retval = retval + i;
            }
        }
        return retval;
  }
  	/**
	   * Accept an integer value and a double value, begin prepared to 
	   * accept an Exception in receiving both values and answering accordingly.
	   * 
	   * @param prompt The printed menu where the given options are listed
	   * @param keyboard Scanner object that is imported as to accept value from user in the method
	   * @return
	   */
  public static int validateInt(String prompt, Scanner keyboard) {
		String str;
		int flag;

		while(true) { //continuously loop until return
			System.out.println(prompt);
			try {
				str = keyboard.nextLine().trim();	//remove spaces from string
				flag = Integer.parseInt(str);		//convert from string to integer
				return flag;
			} catch (Exception E) {
				System.out.println("ERROR. Number entered is not an integer.\n");
			}
		}
    
  }
  	/**
	* Program displays a menu of three choices, the user choses
	* one of the three. When the user enters any integer, it must be
	* validated with the help of validateInt(). The program only quits
	* when option 3 is chosen.
	* 
	* @param args Takes/accepts arguments at execution time
	*/
    public static void main(String[] args){
      	Scanner keyboard = new Scanner (System.in);	//create scanner object
      	String prompt;								//create string object
		int flag=-1, size=-1;
		boolean again = true;
		// Loop to grab choice for menu
		while (again) {
			prompt = "Numeric Pattern Display\n" + "1. Print Type I pattern (like 12321)\n" 
                      + "2. Print Type II pattern (like 32123)\n" + "3. Quit\n" + "Enter your choice (1 - 3): ";
			while (again) { 
				// validdateInt will ensure and int, main will check if int is valid option
				flag = validateInt(prompt, keyboard);//if the value entered is a integer
				if (1 <= flag && flag <= 3) {	//check if the integer is in the correct range
					// Returned int is valid and can continue
					if (flag == 3) {
						// Checks if program needs to exit
						System.out.println("Quitting!");
						System.exit(0);
					}
					break;
				} else {
					// Int is negative or zero and needs a new value
					System.out.println("ERROR. Number entered is not a valid selection.\n");
				}
			}
			prompt = "Please enter the size of the pattern. The size must be a positive integer:";
			// Loop to grab size
			while (again) {
				size = validateInt(prompt, keyboard);
				// Checks if size is a positive integer
				if (size > 0) {
					break;
				} else {
					System.out.println("ERROR. Number entered is not positive.\n"); //need to include spacing after printed ERROR
				}
			}
			String output = numericPattern(size, (flag == 1));
			System.out.println(output+"\n"); //need to include spacing after printed pattern
		}
    }
}
