import java.io.*;
import java.util.Scanner;

public class FinalSpring2021 {

	public static void main(String[] args) {
		PrintStream out = System.out;
		
		problem01Tests(out);
		problem02Tests(out);
		problem03Tests(out);
      
      /* The following 2 test method calls have been commented out to make the code compile
      *  Please uncomment them in order to run the tests
      */ 
      System.out.println("\n--------\nAll tests for ClassA copy constructor and equals() method are not running yet! \nPlease uncomment the test method calls in main()");
		ClassATests.testsClassACopyConstr(out);
		ClassATests.testsClassAEquals(out);
	}
	/**
     * Method runs all test cases for problem01() method 
     * The method generates a number of test case files. 
     * Please see those files to make sure your file output format matches the output format in test files
     * @param outputStream - output stream, used to print into the screen
     */
	
    public static void problem01Tests(PrintStream outputStream)
    {

       outputStream.println("\n--------- problem01() Tests ---------");
    
       // Data needed for the test cases is built here
       String[] testOut1 = {"1"};     //AllStaticMethods.problem01("PR01_test1.txt", 1);
       String[] testOut2 = {"1", "23", "345"};     //AllStaticMethods.problem01("PR01_test2.txt", 3);
       String[] testOut3 = {"1", "23", "345", "4567"}; //AllStaticMethods.problem01("PR01_test3.txt", 4);
       String[] testOut4 = {"1", "23", "345", "4567", "56789", "67891011", "78910111213", "89101112131415"}; //AllStaticMethods.problem01("PR01_test4.txt", 8);        
           
       // building test case files 
       try
       {
    	 buildTestFile("PR01_testCaseOut1.txt", testOut1);
    	 buildTestFile("PR01_testCaseOut2.txt", testOut2);
    	 buildTestFile("PR01_testCaseOut3.txt", testOut3);
    	 buildTestFile("PR01_testCaseOut4.txt", testOut4);
       }
       catch(IOException e)
       {
           System.out.println("Trouble with file IO when building test case files");
       }

       try
       {   
              
         AllStaticMethods.problem01("PR01_test1.txt", 1);
         AllStaticMethods.problem01("PR01_test2.txt", 3);
         AllStaticMethods.problem01("PR01_test3.txt", 4);
         AllStaticMethods.problem01("PR01_test4.txt", 8);
       
         //--- Test 1 ---//
         // comparing resulting files
         if(areEqualFiles("PR01_testCaseOut1.txt", "PR01_test1.txt")
        		 && areEqualFiles("PR01_testCaseOut2.txt", "PR01_test2.txt") 
        		 && areEqualFiles("PR01_testCaseOut3.txt", "PR01_test3.txt") 
        		 && areEqualFiles("PR01_testCaseOut4.txt", "PR01_test4.txt") )
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - regular functionality",  "PASSED");
              
         }
         else outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 01 - regular functionality",  "FAILED");
  
      //--- Test 2 ---//        
         try
         {
               AllStaticMethods.problem01("someFile.txt", 0); 
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - IllegalArgumentException - zero arg",  "FAILED");
            
         }
         catch(IllegalArgumentException e)
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 02 - IllegalArgumentException - zero arg",  "PASSED");
              
         }

         //--- Test 3 ---//        
         try
         {
               AllStaticMethods.problem01("someFile.txt", -1); 
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 03 - IllegalArgumentException - negative arg",  "FAILED");
            
         }
         catch(IllegalArgumentException e)
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 03 - IllegalArgumentException - negative arg",  "PASSED");
              
         }


         //--- Test 4 ---//
        
         try
         {
            AllStaticMethods.problem01("some/File.txt",5); 
            outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 04 - IOException",  "FAILED");
            
         }
         catch(IOException e)
         {
             outputStream.printf("%-80s%-10s\r\n", "problem01() TEST 04 - IOException",  "PASSED");
              
         }
       }
      
       catch(IOException e)
       {
           System.out.println("Trouble with file IO when running tests. The problem may not be implemented yet");
       }
       
    }
    /**
     * Method runs all test cases for problem02() method 
     * The Method generates a number of test case files. 
     * Please see those files to make sure your file output format matches the output format in test files
     */
    public static void problem02Tests(PrintStream outputStream)
    {
      
       outputStream.println("\n--------- problem02() Tests ---------");
    // Data needed for the test cases is built here
       String[] testIn1 = {"AAbc aAAbscd", "one two three", "one-on-one AQ", "this is AA nice day"};
                  
       String[] testIn2 = {};

       String[] testIn3 = {"AAbc aAAbcd"};
             
    
       try{
        
         // building test case files 
         buildTestFile("PR02_test01.txt", testIn1); 
         buildTestFile("PR02_test02.txt", testIn2);
         buildTestFile("PR02_test03.txt", testIn3);
         
 
         
         //--- Test 1 ---//
      // comparing resulting files with test cases
         if(AllStaticMethods.problem02("PR02_test01.txt", "AA")==2
        		 && AllStaticMethods.problem02("PR02_test01.txt", "one")==2
        		 && AllStaticMethods.problem02("PR02_test01.txt", "nice")==1
        		 && AllStaticMethods.problem02("PR02_test01.txt", "Nice")==0
        		 && AllStaticMethods.problem02("PR02_test01.txt", "n")==3
        		 && AllStaticMethods.problem02("PR02_test01.txt", "four")==0
        		 && AllStaticMethods.problem02("PR02_test03.txt", "bc")==1
        		 && AllStaticMethods.problem02("PR02_test03.txt", "ba")==0)      		
         {
             outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 01 - regular functionality",  "PASSED");
             
         }
         else outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 01 - regular functionality",  "FAILED");
         
  
         //--- Test 2 ---//
         if(AllStaticMethods.problem02("PR02_test02.txt", "AA")==0 )      		
         {
             outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 02 - empty file",  "PASSED");
             
         }
         else outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 02 - empty file",  "FAILED");
         
         
         //--- Test 3 ---//
         
         try
         {
            AllStaticMethods.problem02("someFile.txt", "aa"); 
            outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 03 - IOException",  "FAILED");
            
         }
         catch(IOException e)
         {
             outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 03 - IOException",  "PASSED");
             
         }
         
       }
       catch(IOException e)
       {
           System.out.println("Trouble with file IO when running tests; MESSAGE: "+e.getMessage());
       }
    
    }
    
	/**
     * Runs all tests for problem03() method
     * @param outputStream - output stream, used to print into the screen
     */
    public static void problem03Tests(PrintStream outputStream)
    {
        outputStream.println("\r\n----Tests for problem03()----\r\n");
        
        
        ClassD[] test01 = new ClassD[3];
        test01[0] = new ClassD(1, 2);
        test01[1] = new ClassD(2, 2);
        test01[2] = new ClassD(2, 3);
        

        ClassD[] testCaseOut01 = new ClassD[6];
        testCaseOut01[0] = new ClassD(1, 2);
        testCaseOut01[1] = new ClassD(1, 2);
        testCaseOut01[2] = new ClassD(2, 2);
        testCaseOut01[3] = new ClassD(2, 2);
        testCaseOut01[4] = new ClassD(2, 3);
        testCaseOut01[5] = new ClassD(2, 3);

        // empty
        ClassD[] test02 = new ClassD[0];
        
        // one element 
        ClassD[] test03 = {new ClassD(1, 1)};
        
        ClassD[] testCaseOut03 = {new ClassD(1, 1), new ClassD(1, 1)};
 
        //--- Test 1 ---//
        ClassD[] one = AllStaticMethods.problem03(test01, 5);
        ClassD[] two = AllStaticMethods.problem03(test01, 12);
        ClassD[] three = AllStaticMethods.problem03(test03, 1);
        
        ClassD[] test11 = AllStaticMethods.problem03(test01, 20);
        ClassD[] test33 = AllStaticMethods.problem03(test03, 3);

        
        if(one==test01 && two == test01 && three == test03
        		&& areEqualArrays(test11, testCaseOut01)
        		&& areEqualArrays(test33, testCaseOut03))   
        {
            outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 01 - basic functionality",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 01 - basic functionality",  "FAILED");
 
        //--- Test 2 ---//
        
        ClassD[] four = AllStaticMethods.problem03(test02, 1);
        
        if(test02 == four)  
        {
            outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 02 - empty array",  "PASSED");
           
        }
        else outputStream.printf("%-80s%-10s\r\n", "problem02() TEST 02 - empty array",  "FAILED");
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
         FileReader file1 = new FileReader(fileName1); 
         FileReader file2 = new FileReader(fileName2); 
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

    private static boolean areEqualArrays(ClassD[] one, ClassD[] two)
    {
    	if(one.length!=two.length) return false;
    	for(int i = 0; i<one.length; i++)
    	{
    		if(!one[i].toString().equals(two[i].toString())) return false;
    	}
    	return true;
    }
}
