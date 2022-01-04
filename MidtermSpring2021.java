
/**
 * @author Your name here
 */
import java.io.*;
import java.util.Scanner;

public class MidtermSpring2021 {
	/**
	 * method receives two integers and returns a value of type double. 
	 * The integers positive or negtative sign and their divisibilaty 
     * determines the returned double value.
     * 
	 * @param a given integer value
	 * @param b	given integer value
	 * @return	the determined double response
	 */
   public static double problem01(int a, int b){ 

        if(a<=0 || b<=0){ // either A or B are negative or 0
            return -1.0;
        }else if((a%2==0 && a%5==0) && (b%2==0 && b%5==0)){ //if both are divisible by 2 and 5
            return 100.0;
        }else if((a%2==0 && b%5==0) || (b%2==0 && a%5==0) ){ //if one is divisible by 2 (but not by five) and the other is divisible by 5 (but not by two)
            return 10.0;
        }else if(a%2==0 && b%2==0){ //if both are divisible by 2
            return 22.0;
        }else if(a%2==0 || b%2==0){ //if only one is divisible by 2
            return 2.0;
        }else if(a%5==0 && b%5==0){ //if both are divisible by 5
            return 55.0;
        }else if(a%5==0 || b%5==0){ //if only one is divisible by 5
            return 5;
        }else{ //if neither are divisible by 2 or 5
            return 1.0;
        }
      
   }
   /**
    * Inputs an arbitrary number of integers and calculates their total. The input stops 
    * when the sum total reaches 20 or above
    */
   public static void problem02(){

     Scanner sc = new Scanner(System.in);
     int total=0;
     while (total < 20) {
       try {
         System.out.println("ENTERx an str");
         total += Integer.parseInt(sc.nextLine());
       } catch (Exception E) {
         System.out.println("ERROR: Your input is not an integer.");
         System.out.println(E);
       }
     }
     System.out.println("TOTAL = " + total);
        
   }
   /**
    * The method recieves a file, and two integers. Both input 
    * integers must be from 1 to 9 (one digit). The method opens the file,
    * erases it's contents, and writes a series of integers and their sum into
    * the file using the two integers provided. 
    *
    * @param fileName
    * @param digit1
    * @param digit2
    */
   public static void problem03(String fileName, int digit1, int digit2) throws IOException {
    int i=digit1;
    boolean isFirst = true;
    String output = "{";
    boolean direction = (digit1 < digit2); //if increasing order
    if (digit1 > 9 || digit1 < 1 || digit2 > 9 || digit2 < 1) {
        throw new IllegalArgumentException();
    }
    if (digit1 == digit2) { //if integers are the same number 
        output+=i+""+i;
    }
    while (i != digit2) { 
        if (!isFirst) {
            output += ", "; //print the comment
        }
        isFirst = false; //if decreasing order
        if (direction) { 
            output+=i+""+(i+1);
            i++;
        } else {
            output+=i+""+(i-1);
            i--;
        }
    }
      buildTestFile(fileName, new String[]{output+"}"});	
   
    }

   /**
    * Method receives a file and an integer value. The method reads all of the integers from it
    * counting how many times the given 'value' appears in the file. The method then returns the
    * number of times the number of occurences of the value in the file. 
    *
    * @param fileName //a list of string values in a file 
    * @param value //the value to be counted in the file
    * @return //the number of values that are in the file
    */
   public static int problem04(String fileName, int value) throws IOException{
      Scanner keyboard = new Scanner(new File(fileName));
      int count=0;
      try { //be prepared to receive exceptions
        while(keyboard.hasNextLine()) {
          int tmp = Integer.parseInt(keyboard.nextLine().trim());
          if (tmp == value) { //if the string value in the list if equivalent to the integer value
            count++; //increase value count
          }
        }
      } catch (Exception E) { //if there is a formatting error, for blank space
        //throw new IOException(); //throw Exception
      }
      return count;
   }

	public static void main(String[] args){
		PrintStream out = System.out;
		testsProblem01(out);
		
		out.printf("\nproblem02() call follows (test manually)-----------------------\n\n");
		problem02();
		out.printf("\nEnd of call to problem02 -----------------------\n");
		
		testsProblem03(out);
		testsProblem04(out);
	}
	
	/**
	 * Method runs all test cases for problem01() method
	 * 
	 * @param outputStream - output stream, used to print into the screen
	 * @return number of points the problem is worth if all the tests ran
	 *         successfully. If any of the tests failed the method returns a 0.
	 */
	public static void testsProblem01(PrintStream outputStream) {

		outputStream.println("\r\n----Tests for problem01()----\r\n");
		// Test #1
		if (problem01(-2, 3) == -1 && problem01(0, 5) == -1 
				&& problem01(3, -2) == -1 && problem01(3, 0) == -1)  {
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - negative or 0 parameters", "PASSED");
		} else
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - negative or 0 parameters", "FAILED");

// Test #2        
		if (problem01(2, 22) == 22 && problem01(6, 14) == 22 && problem01(24, 102) == 22) {
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - both divisivle only by 2", "PASSED");
		} else
		{
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - both divisivle only by 2", "FAILED");
		}
// Test #3        
		if (problem01(5, 15) == 55 && problem01(25, 105) == 55 && problem01(35, 45) == 55) {
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 03 - both divisivle only by 5", "PASSED");
		} else
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 03 - both divisivle only by 5", "FAILED");
// Test #4        
		if (problem01(2, 33) == 2 && problem01(6, 47) == 2 && problem01(103, 102) == 2) {
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 04 - one divisivle only by 2", "PASSED");
		} else
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 04 - one divisivle only by 2", "FAILED");
// Test #5        
		if (problem01(5, 33) == 5 && problem01(55, 47) == 5 && problem01(103, 105) == 5) {
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 05 - one divisivle only by 5", "PASSED");
		} else
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 05 - one divisivle only by 5", "FAILED");
// Test #6        
		if (problem01(5, 2) == 10 && problem01(24, 45) == 10 && problem01(98, 105) == 10) {
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 06 - one divisivle only by 5, another one only by 2", "PASSED");
		} else
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 06 - one divisivle only by 5, another one only by 2", "FAILED");
// Test #7        
		if (problem01(50, 20) == 100 && problem01(240, 450) == 100 && problem01(980, 1050) == 100) {
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 07 - both divisible by 2 and 5", "PASSED");
		} else
			outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 07 - both divisible by 2 and 5", "FAILED");
	
	}
	
	/**
	 * Method runs all test cases for problem03() method The method generates a
	 * number of test case files. Please see those files to make sure your file
	 * output format matches the output format in test files
	 * 
	 * @param outputStream - output stream, used to print into the screen
	 */
	public static void testsProblem03(PrintStream outputStream) {

		// Data needed for the test cases is built here
		outputStream.println("\n--------- problem03() Tests ---------");

		String[] testOut1 = { "{12, 23, 34, 45, 56, 67, 78, 89}" }; // problem03("test01.txt", 1, 9);
		String[] testOut2 = { "{23, 34, 45}" }; // problem03("test02.txt", 2, 5);
		String[] testOut3 = { "{54, 43, 32}" }; // problem03("test03.txt", 5, 2);
		String[] testOut4 = { "{76}" }; // problem03("test04.txt", 7, 6);
		String[] testOut5 = { "{67}" }; // problem03("test05.txt", 6, 7);
		String[] testOut6 = { "{77}" }; // problem03("test06.txt", 7, 7);

		// building test case files
		try {
			buildTestFile("PR03_testCaseOut1.txt", testOut1);
			buildTestFile("PR03_testCaseOut2.txt", testOut2);
			buildTestFile("PR03_testCaseOut3.txt", testOut3);
			buildTestFile("PR03_testCaseOut4.txt", testOut4);
			buildTestFile("PR03_testCaseOut5.txt", testOut5);
			buildTestFile("PR03_testCaseOut6.txt", testOut6);

		} catch (IOException e) {
			System.out.println("Trouble with file IO when building test case files");
		}

		try {
			// --- Test 1 ---//

			problem03("PR03_test01.txt", 1, 9);
			problem03("PR03_test02.txt", 2, 5);
			problem03("PR03_test03.txt", 5, 2);
			problem03("PR03_test04.txt", 7, 6);
			problem03("PR03_test05.txt", 6, 7);
			problem03("PR03_test06.txt", 7, 7);
			
			// comparing resulting files
			if (areEqualFiles("PR03_testCaseOut1.txt", "PR03_test01.txt") && areEqualFiles("PR03_testCaseOut2.txt", "PR03_test02.txt")
					&& areEqualFiles("PR03_testCaseOut3.txt", "PR03_test03.txt")
					&& areEqualFiles("PR03_testCaseOut4.txt", "PR03_test04.txt")
					&& areEqualFiles("PR03_testCaseOut5.txt", "PR03_test05.txt")) {
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 01 - regular functionality", "PASSED");
				
			} else
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 01 - regular functionality", "FAILED");

			// --- Test 2 ---//

			if ( areEqualFiles("PR03_testCaseOut6.txt", "PR03_test06.txt")) {
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 02 - equal digits", "PASSED");
				
			} else
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 02 - equal digits", "FAILED");

			// --- Test 3 ---//
			try {
				problem03("someFile.txt", 10, 3);
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 03 IllegalArgumentException first non-digit",
						"FAILED");

			} catch (IllegalArgumentException e) {
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 03 IllegalArgumentException first non-digit",
						"PASSED");
				
			}

			// --- Test 4 ---//
			try {
				problem03("someFile.txt", 1, 33);
				outputStream.printf("%-80s%-10s\r\n",
						"problem03() TEST 04 IllegalArgumentException second non-digit", "FAILED");

			} catch (IllegalArgumentException e) {
				outputStream.printf("%-80s%-10s\r\n",
						"problem03() TEST 04 IllegalArgumentException second non-digit", "PASSED");
				
			}

			// --- Test 5 ---//
			try {
				problem03("someFile.txt", -1, 3);
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 05 IllegalArgumentException out of range first digit",
						"FAILED");

			} catch (IllegalArgumentException e) {
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 05 IllegalArgumentException out of range first digit",
						"PASSED");
				
			}

			// --- Test 6 ---//
			try {
				problem03("someFile.txt", 6, 0);
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 06 IllegalArgumentException out of range second digit",
						"FAILED");

			} catch (IllegalArgumentException e) {
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 06 IllegalArgumentException out of range second digit",
						"PASSED");
				
			}
			// --- Test 7 ---//

			try {
				problem03("some/File.txt", 9, 1);
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 07 - IOException", "FAILED");

			} catch (IOException e) {
				outputStream.printf("%-80s%-10s\r\n", "problem03() TEST 07 - IOException", "PASSED");
				
			}
		}

		catch (IOException e) {
			System.out.println("Trouble with file IO when running tests");
		}

	}
	/**
	 * Method runs all test cases for problem04() method The method generates a
	 * number of test case files. Please see those files to make sure your file
	 * output format matches the output format in test files
	 * 
	 * @param outputStream - output stream, used to print into the screen
	 */
	public static void testsProblem04(PrintStream outputStream) {

		// Data needed for the test cases is built here
		outputStream.println("\n--------- problem04() Tests ---------");

		String[] testOut1 = { "" }; // problem04("test01.txt", 1) - returns 0;
		String[] testOut2 = { "3"}; // problem04("test02.txt", 3) - returns 1;
		String[] testOut3 = { "2", "2", "2"}; // problem04("test03.txt",2) - returns 3;
		String[] testOut4 = { "2", "12", "2", "2", "7" }; // problem04("test04.txt", 2) - returns 3;
		String[] testOut5 = { "2", "12", "2", "2", "7" }; // problem04("test05.txt", 5) - returns 0;

		// building test case files
		try {
			buildTestFile("PR04_test01.txt", testOut1);
			buildTestFile("PR04_test02.txt", testOut2);
			buildTestFile("PR04_test03.txt", testOut3);
			buildTestFile("PR04_test04.txt", testOut4);
			buildTestFile("PR04_test05.txt", testOut5);
			
		} catch (IOException e) {
			System.out.println("Trouble with file IO when building test case files");
		}

		try {
			// --- Test 1 ---//
			
			if (problem04("PR04_test02.txt", 3) == 1
					&& problem04("PR04_test03.txt", 2) == 3
					&& problem04("PR04_test04.txt", 2) == 3
					&& problem04("PR04_test05.txt", 5) == 0) {
				outputStream.printf("%-80s%-10s\r\n", "problem04() TEST 01 - regular functionality", "PASSED");
				
			} else
				outputStream.printf("%-80s%-10s\r\n", "problem04() TEST 01 - regular functionality", "FAILED");

			// --- Test 2 ---//

			if ( problem04("PR04_test01.txt", 1) == 0 ) {
				outputStream.printf("%-80s%-10s\r\n", "problem04() TEST 02 - empty file", "PASSED");
				
			} else
				outputStream.printf("%-80s%-10s\r\n", "problem04() TEST 02 - empty file", "FAILED");

			// --- Test 3 ---//

			try {
				int ignoreMe = problem04("some/file.txt.txt", 1);
				outputStream.printf("%-80s%-10s\r\n", "problem04() TEST 03 - IOException", "FAILED");

			} catch (IOException e) {
				outputStream.printf("%-80s%-10s\r\n", "problem04() TEST 03 - IOException", "PASSED");
				
			}
		}

		catch (IOException e) {
			System.out.println("Trouble with file IO when running tests");
		}

	}

	/**
	 * Compares content of two files and returns true if content is identical, false
	 * if not
	 * 
	 * @param fileName1 name of first file to be compared
	 * @param fileName2 name of second file to be compared
	 * @return true if the files are identical, false if not
	 * @throws IOException thrown when files fail to open for reading / writing
	 */
	public static boolean areEqualFiles(String fileName1, String fileName2) throws IOException {
		FileReader file1 = new FileReader(fileName1);
		FileReader file2 = new FileReader(fileName2);
		Scanner input1 = new Scanner(file1);
		Scanner input2 = new Scanner(file2);
		while (input1.hasNext() && input2.hasNext()) {
			String s1 = input1.nextLine().trim();
			String s2 = input2.nextLine().trim();
			if (!s1.equals(s2)) {
				input1.close();
				input2.close();
				return false;
			}
		}
		boolean res;
		if (!input1.hasNext() && !input2.hasNext())
			res = true;
		else
			res = false;
		input1.close();
		input2.close();
		return res;
	}

	/**
	 * Builds a file with a given name with a content defined by an array of objects
	 * that are printed to the file as strings, one string per line
	 * 
	 * @param fileName name of file to write to
	 * @param testCase array of objects to print into file in string format
	 * @throws IOException throws exception when file fails to open for writing or
	 *                     writing fails
	 */
	public static void buildTestFile(String fileName, Object[] testCase) throws IOException {
		FileWriter file = new FileWriter(fileName);
		PrintWriter outputFile = new PrintWriter(file);
		for (Object a : testCase) {
			outputFile.println(a);
		}
		outputFile.close();
	}
	
}
