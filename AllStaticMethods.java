import java.io.*;
import java.util.Scanner;
//FIXME Delete import later
//import java.util.Arrays;

/**
 * 
 * @author Your name here
 *
 */
public class AllStaticMethods {

	public static void writeFile(String fileName, Object[] lines) throws IOException {  //NOT WORKING
		// Overwrites the current file if exists,
		// if not it creates the file.
		FileWriter file = new FileWriter(fileName); 
        PrintWriter outputFile = new PrintWriter(file);
         
        for (Object line: lines)
        {
        	outputFile.println(line);
        }
        outputFile.close();
	}

	/**
	 * Write a method that takes a file name and an integer and writes a pattern into the file with the given name.
	 * If the file does not exist, it must be created. If the file does not exist, it contents will be replaced.
	 * Integer parameter determines the pattern size. Your code must work for any positive value of the parameter.
	 *      Any IOExceptions arising are not handled by the method and propagated to the calling code instead.
	 *      IllegalArgumentException is thrown when the numeric parameters are negative or 0.
	 * @param fileName file to be written to
	 * @param num1 number to determine the size of the pattern
	 * @throws IOException 
	 */
	public static void problem01(String fileName, int num1) throws IOException {

		if (num1 < 1) throw new IllegalArgumentException("Number cannot be negative or 0.");
		String[] pattern = new String[num1];
		int val=1;
		for (int y=0; y<num1; y++) {
			pattern[y] = ""; // Initisalizes the string
			val = y+1;
			for (int x=0; x<y+1; x++) {
				pattern[y] += (val++); // Converts number to string
			}
		}
		// System.out.println(Arrays.toString(pattern));
		writeFile(fileName, pattern);
	}
	
	/**
	 * A method that takes a file name and a string s as parameters. The method must count (and return)
	 * how many strings in the given file contain at least one occurrence of string s as a substring.
	 *      Any IOExceptions arising are not handled by the method and propagated to the calling code instead.
	 * @param fileName
	 * @param s
	 * @return 
	 * @throws IOException
	 */
	public static int problem02(String fileName, String s) throws IOException{    //WORKING
		Scanner sc = new Scanner(new File(fileName));
		
		int flag = 0; // Holds number of times substring appears within string
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			for(int i = 0; i < line.length() - s.length(); i++) {
				if (line.substring(i).startsWith(s))  {
					// Checks the front only string if it contains
					// s to save complexity substringing further
					flag++;
					break; // Since occurrence already found move to next line
				}
				
			}
		}
		// System.out.println(flag);
		return flag;
	}
	
	/**
	 * A Method that takes an array of objects of typeD and double value called limit and returns an array of 
	 * base type ClassD. First calculate the total of all elements of the array. Use toDouble() method to convert
	 * into a double value and add them all up.
	 *      If the resulting value is larger or equal than the limit parameter, return the reference to the original array
	 *      If the resulting value is smaller than the limit parameter, double the original array in the following manner:
	 *           Create a double array of double the size of the original one and copy all elements there, repeating each element twice
	 *           return the resulting array
	 *           Order of elements is important
	 *           If the orginal array is empty, it cannot be "doubled". The Reference to the original array is being returned.
	 * @param array an array of objects
	 * @param limit a double value
	 * @return array of base type ClassD
	 */
	public static ClassD[] problem03(ClassD[] array, int limit){  //NOT WORKING
		double sum = 0.0; // Placeholder for sum of elements
		for (ClassD obj : array) {
			sum += obj.toDouble();
		}
		boolean isSmall = (0<sum && sum < limit); //is the limit not empty and less then the limit?
		//System.out.print("Bool: " +isSmall+ " Limit: " +limit+ "/Sum: " +sum+ " -> "); 
		if (isSmall) { //if sum of numbers is less than the limit parameter
			// Array needs to be doubled
			ClassD[] newArr = new ClassD[array.length*2]; //array double the size of the original
			for (int n=0, i=0; i<array.length; i++) {
				
				newArr[n++] = array[i]; // Assigns first value
				newArr[n++] = array[i]; // assigns second value
			}
			//System.out.println("NewArr:" + Arrays.toString(newArr));
			return newArr;
		} else { //else if the sum of numbers is more than the limit parameter
			//System.out.println("Arr:" + Arrays.toString(array));
			return array;
		}
	}

}
