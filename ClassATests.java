import java.io.PrintStream;

public class ClassATests {
	/**
	 * Runs all tests for ClassA Copy Constructor 
	 * @param outputStream - output stream, used to print into the screen
	 */
	public static void testsClassACopyConstr(PrintStream outputStream)
	{

	    outputStream.println("\r\n----Tests for ClassA Copy Constructor----\r\n");
	    ClassA obj = new ClassA(10, 3);
	    obj.forTestsSetup(10);
	    
	    ClassA objCopy = new ClassA(obj);
	    //{first=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]; second=3}

		  //--- Test 1 ---//
	    if(objCopy.toString().equals("{first=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]; second=3}"))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassA copy constructor TEST 01 - basic functionality",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassA copy constructor TEST 01 - basic functionality",  "FAILED");
	
	  //--- Test 2 ---//
	    
	    obj.forTestsModify(1); // - this must not change the object we just created
	    if(objCopy.toString().equals("{first=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]; second=3}"))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassA copy constructor TEST 02 - deep copy of fields",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassA copy constructor TEST 02 - deep copy of fields",  "FAILED");               
	
	}

	public static void testsClassAEquals(PrintStream outputStream)
	{
	    outputStream.println("\r\n----Tests for ClassA equals() Method----\r\n");
	    ClassA obj1 = new ClassA(5, 6);
	    obj1.forTestsSetup(5);
	    
	    ClassA obj2 = new ClassA(5, 6);
	    obj2.forTestsSetup(5);
	    
	    if(obj1.equals(obj2) && obj2.equals(obj1))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassA equals() TEST 01",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassA equals() TEST 01",  "FAILED");               
		
	    obj2.forTestsModify(3);
	    ClassA obj3 = new ClassA(5, 7);
	    if(!obj1.equals(obj2) && !obj2.equals(obj1) && !obj1.equals(obj3) && !obj3.equals(obj1))       
	    {
	        outputStream.printf("%-80s%-10s\r\n", "ClassA equals() TEST 02",  "PASSED");
	         
	    }
	    else outputStream.printf("%-80s%-10s\r\n", "ClassA equals() TEST 02",  "FAILED"); 	    

	}
}
