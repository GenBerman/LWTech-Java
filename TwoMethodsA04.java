
import java.io.*;
import java.util.Scanner; 

/**
 *
 * @author Your name here
 */

public class TwoMethodsA04 { //WORKING

    /**
     * If the boolean is true, the string first increases to the size from 1,
     * then decreases back to one in increments of 1. If the boolean is false,
     * the string starts at the size, decreases to 1, then increases to the size
     * again; all in increments of 1.
     *  Example: numericPattern(5, true) returns string 123454321
     *  Example: numericPattern(5, false) returns string 543212345
     *
     * @param size The positive integer that determines the scale of the printed pattern
     * @param direction The boolean value that determines the direction of the printed pattern: small-size-small or size-small-size
     */
    public static String numericPattern(int size, boolean direction){   //WORKING
        if (size <= 0) // for when the big mistake happen
            throw new IllegalArgumentException();
  
        String retval = ""; // Value to return at end
        int i; // value for indexing across string nums
        if (direction) { // prints values from 1 to size
            for (i=1; i<size; i++) {
                retval = retval + i;
            }
            for (; i >=1 ; i--) { // prints values from size to 1
                retval = retval+i;
            }
        } else {
            for (i=size; i > 1 ; i--) { // prints values from size to 1
                retval = retval+i;
            }
            for (; i<=size; i++) { // prints values from 1 to size
                retval = retval + i;
            }
        }
        return retval;
    }
    /**
     * Analyses the sequence of integers in the first (input) file, and stores the
     * results in the second (output) file. Data to determine: the number of integers
     * stored, the largest and the smallest number stored in file, & the total of all
     * numbers stored in the file.
     * 
     * @param inputFileName A file that has to-be collected integer data that is given by the program later
     * @param outputFileName Where the determined data of the input file is exported to.
     * @throws IOException 
     */


    public static void fileAnalysis(String inputFileName, String outputFileName) throws IOException{  // WORKING
        Scanner inputFile = new Scanner(new File(inputFileName));
        String line = "";
        int numOfNums=1, maxNum, minNum, sumOfNums=0; //variables for all file-printed values
        try {
            line = inputFile.nextLine();    //test to see if the file is completely empty
        } catch (Exception E) {
            String outputLine[] = {"Numeric data file \"" +inputFileName+ "\" is empty"};   
            buildTestFile(outputFileName, outputLine);
            return;
        }
        int num = Integer.parseInt(line);
        maxNum = num; minNum = num; sumOfNums = num; //set the varibles as the first in the file as a point of comparison
        while (inputFile.hasNext()) {
            num = Integer.parseInt(inputFile.nextLine());   
            if (num > maxNum) {         //check if the number is greater than the largest number
                maxNum = num;
            } if (num < minNum) {       //check if the number is less than the smallest number
                minNum = num;
            }
            numOfNums++;        //increment the count of the number of integers 
            sumOfNums += num;   //Add the number to the total of the sum of numbers
        }
        if (numOfNums == 1) {       //if there is one integer in the file
            String[] outputLine = {"Numeric data file \"" +inputFileName+ "\" has only one number: " + sumOfNums};
            buildTestFile(outputFileName, outputLine);
        } else {
            String[] outputLine = {     //print the export statements to the output file
                "Numeric Data File \"" +inputFileName+ "\" Analysis",
                "Number of integers: " +numOfNums,
                "The sum of all integers in file: " + sumOfNums,
                "The largest integer in the set: " + maxNum,
                "The smallest integer in the set: " + minNum
            };
            buildTestFile(outputFileName, outputLine);
        }
    }
    /**
    * The main method calls/activated the test methods to determine what faults are in each method
    */ 
    public static void main(String[] args) {
       System.out.println(new File(".").getAbsolutePath());

        testNumericPattern();
        testFileAnalysis();
    }
    
     
   /**
    * Method runs all test cases for numericPattern() method 
    */ 
   public static void testNumericPattern()
   {
       System.out.println("\n--------- numericPattern() Tests ---------");
         //--- Test 1 ---//
        if(numericPattern(1, true).equals("1")&&numericPattern(1, false).equals("1")) 
            System.out.println("Test 1 for numericPattern() PASSED");
        else System.out.println("Test 1 for numericPattern() Failed");
       
         //--- Test 2 ---//
        if(numericPattern(5, false).equals("543212345")&& numericPattern(6, true).equals("12345654321")) 
            System.out.println("Test 2 for numericPattern() PASSED");
        else System.out.println("Test 2 for numericPattern() Failed");
        
        //--- Test 3 ---//
        try
        {
            String ignoreMe = numericPattern(0, false);
            System.out.println("Test 3 for numericPattern() Failed");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Test 3 for numericPattern() PASSED");
        }
        //--- Test 4 ---//
        try
        {
            String ignoreMe = numericPattern(-55, false);
            System.out.println("Test 4 for numericPattern() Failed");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Test 4 for numericPattern() PASSED");
        }       
       
   }
  
   /**
    * Method runs all test cases for fileAnalysis() method 
    * The method generates a number of test case files. 
    * Please see those files to make sure your file output format matches the output format in test files
    */
   public static void testFileAnalysis()
   {
      // Data needed for the test cases is built here
      System.out.println("\n--------- fileAnalysis() Tests ---------");
      Integer[] testIn1 = {};
      String[] testOut1 = {"Numeric data file \"testCaseIn1.txt\" is empty"};
      Integer[] testIn2 = {0};
      String[] testOut2 = {"Numeric data file \"testCaseIn2.txt\" has only one number: 0"};
      Integer[] testIn3 = {0, 0};
      String[] testOut3 = {"Numeric Data File \"testCaseIn3.txt\" Analysis", "Number of integers: 2","The sum of all integers in file: 0", "The largest integer in the set: 0", "The smallest integer in the set: 0"};      
      Integer[] testIn4 = {33, 1, 0, 2}; 
      String[] testOut4 = {"Numeric Data File \"testCaseIn4.txt\" Analysis", "Number of integers: 4","The sum of all integers in file: 36", "The largest integer in the set: 33", "The smallest integer in the set: 0"};      
      Integer[] testIn5 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
      String[] testOut5 = {"Numeric Data File \"testCaseIn5.txt\" Analysis", "Number of integers: 2","The sum of all integers in file: -2", "The largest integer in the set: 2147483647", "The smallest integer in the set: 2147483647"};      
      Integer[] testIn6 = {Integer.MIN_VALUE, Integer.MAX_VALUE};
      String[] testOut6 = {"Numeric Data File \"testCaseIn6.txt\" Analysis", "Number of integers: 2","The sum of all integers in file: -1", "The largest integer in the set: 2147483647", "The smallest integer in the set: -2147483648"};      
   
     
      // building test case files 
      try
      {
        buildTestFile("testCaseIn1.txt", testIn1); 
        buildTestFile("testCaseOut1.txt", testOut1);
        buildTestFile("testCaseIn2.txt", testIn2);
        buildTestFile("testCaseOut2.txt", testOut2);
        buildTestFile("testCaseIn3.txt", testIn3);
        buildTestFile("testCaseOut3.txt", testOut3);
        buildTestFile("testCaseIn4.txt", testIn4);
        buildTestFile("testCaseOut4.txt", testOut4);
        buildTestFile("testCaseIn5.txt", testIn5);
        buildTestFile("testCaseOut5.txt", testOut5);
        buildTestFile("testCaseIn6.txt", testIn6);
        buildTestFile("testCaseOut6.txt", testOut6);
      }
      catch(IOException e)
      {
          System.out.println("Trouble with file IO when building test case files");
      }

      try
      {
        //--- Test 1 ---//        
       
        fileAnalysis("testCaseIn1.txt", "test01.txt");
        // comparing resulting files
        if(areEqualFiles("testCaseOut1.txt", "test01.txt"))
            System.out.println("Test 1 for fileAnalysis() PASSED");
        else System.out.println("Test 1 for fileAnalysis() Failed");
 
        //--- Test 2 ---//        
        fileAnalysis("testCaseIn2.txt", "test02.txt");   
             
        if(areEqualFiles("testCaseOut2.txt", "test02.txt"))
            System.out.println("Test 2 for fileAnalysis() PASSED");
        else System.out.println("Test 2 for fileAnalysis() Failed");  
        
        //--- Test 3 ---//        
        fileAnalysis("testCaseIn3.txt", "test03.txt");  
        
        if(areEqualFiles("testCaseOut3.txt", "test03.txt"))
            System.out.println("Test 3 for fileAnalysis() PASSED");
        else System.out.println("Test 3 for fileAnalysis() Failed"); 
        
        //--- Test 4 ---//        
        fileAnalysis("testCaseIn4.txt", "test04.txt"); 
        
        if(areEqualFiles("testCaseOut4.txt", "test04.txt"))
            System.out.println("Test 4 for fileAnalysis() PASSED");
        else System.out.println("Test 4 for fileAnalysis() Failed"); 
        
        //--- Test 5 ---//        
        fileAnalysis("testCaseIn5.txt", "test05.txt"); 
        
        if(areEqualFiles("testCaseOut5.txt", "test05.txt"))
            System.out.println("Test 5 for fileAnalysis() PASSED");
        else System.out.println("Test 5 for fileAnalysis() Failed"); 
        
        //--- Test 6 ---//       
        fileAnalysis("testCaseIn6.txt", "test06.txt"); 
        
        if(areEqualFiles("testCaseOut6.txt", "test06.txt"))
            System.out.println("Test 6 for fileAnalysis() PASSED");
        else System.out.println("Test 6 for fileAnalysis() Failed"); 
 
        
        //--- Test 7 ---//
        // Test on exception(s) that your method is supposed to throw
        fileAnalysis("doesNotExist.txt", "test07.txt"); 
        System.out.println("Test 7 for fileAnalysis() Failed"); 
      }
      catch(FileNotFoundException e)
      {
          System.out.println("Test 7 for fileAnalysis() PASSED");
      }
      catch(IOException e)
      {
          System.out.println("Trouble with file IO when running tests");
      }
   
      
   }
   /**
    * Builds a file with a given name with a content defined by an array of objects that are printed to the file as strings, one string per line  
    * @param fileName name of file to write to
    * @param testCase array of objects to print into file in string format
    * @throws IOException throws exception when file fails to open for writing or writing fails
    */
   public static void buildTestFile(String fileName, Object[] testCase) throws IOException
   {
        FileWriter file = new FileWriter(fileName); 
        PrintWriter outputFile = new PrintWriter(file);
        
        for (Object a: testCase)
        {
            outputFile.println(a);
        }
        outputFile.close();
   }
   /**
    * Compares content of two files and returns true if content is identical, false if not
    * @param fileName1 name of first file to be compared
    * @param fileName2 name of second file to be compared
    * @return true if the files are identical, false if not
    * @throws IOException thrown when files fail to open for reading / writing
    */
   public static boolean areEqualFiles(String fileName1, String fileName2) throws IOException
   {
        FileReader file1 = new FileReader(new File(fileName1)); 
        FileReader file2 = new FileReader(new File(fileName2));
        Scanner input1 = new Scanner(file1);
        Scanner input2 = new Scanner(file2);
        while(input1.hasNext()&&input2.hasNext())
        {
            String s1 = input1.nextLine().trim();
            String s2 = input2.nextLine().trim();
            if(!s1.equals(s2)) 
            {
                input1.close();
                input2.close();
                return false;
            }
        }
        boolean res;
        if(!input1.hasNext()&&!input2.hasNext()) res = true;
        else res = false;
        input1.close();
        input2.close();
        return res;
        
   }
}

