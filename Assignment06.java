import java.io.PrintStream;
import java.util.*;
public class Assignment06 {
    /**
     * Write a method that takes an array of integers as a parameter and returns true
     * if the array is sorted in ascending order and false if it is not.
     * The method throws IllegalArgumentException when the array is empty.
     * @param array
     * @return the boolean whether the array is sorted
     */
    public static boolean isSorted(int[] array){ //Problem #1
        boolean sorted = true;
        if (array.length < 1) throw new IllegalArgumentException("Array length is less than 1");
            //set boolean value as true as default
            for(int index=1; index<array.length; index++){
                if(array[index]<=array[index-1]){
                    sorted = false;                           //set boolean value to false.
                }
            }
        
        return sorted;
    }
    /**
     * Write a method that takes two SORTED arrays of integers as parameters,
     * merges them into the third array that is also SORTED and returns the new array to the calling code.
     * @param arrayOne input sorted array
     * @param arrayTwo input sorted array
     * @return the single merged array that contain the values of the two input arrays
     */
    public static int[] mergeSortedArrays(int[] arrayOne, int[] arrayTwo){ //Problem #2
        int [] mergedArray = new int[arrayOne.length + arrayTwo.length];
        int i=0; //index of ArrayOne
        int j=0; //index of ArrayTwo
        int k=0; //index of mergedArray
        while(i<arrayOne.length && j<arrayTwo.length){
            if(arrayOne[i] < arrayTwo[j]){
                mergedArray[k] = arrayOne[i];
                i++; //increase ArrayOne index
            }else{
                mergedArray[k] = arrayTwo[j];
                j++; //increase ArrayTwo index
            }
            k++; //increase mergedArray index
        }
        //if there is left over values from the first array, add to the end of the array
        while(i < arrayOne.length){
            mergedArray[k] = arrayOne[i];
            i++; //increase ArrayOne index
            k++; //increase mergedArray index
        }
        //if there is left over values from the second array, add to the end of the array
        while(j < arrayTwo.length){
            mergedArray[k] = arrayTwo[j];
            j++; //increase ArrayTwo index
            k++; //increase mergedArray index
        }
        return mergedArray;
    }

    /** 
     * Write a method that takes an array of integers and returns true if every integer is appearing in the array only once.
     * It returns false if there are any duplicates in the array.You are not allowed to change the array in any way. 
     * If array is empty the method returns false.
     * @param array int array to be checked
     * @return boolean value if the array contains duplicate values.
     */
    public static boolean allUniqueElements(int[] array){ //Problem #3
        if (array.length < 1) return false;
        Set<Integer> set = new HashSet<Integer>(); //create a Hashset list to keep record of values.
        for(int i=0; i<array.length; ++i){
            if(set.contains(array[i])){ //does the set contain a certain value already?
                //if so, return false
                return false;
            }else{
                set.add(array[i]); //add the array value to the Array List for later reference
            }
        }
        //if no duplicates, return true. 
        return true;
    }

    /**
     * This method takes a two-dimensional array and converts it into a regular one-dimensional array.
     * The new one-dimensional array is returned from the method.
     * @param twoDimensional inputed two Dimensional array to be converted to a one dimensional array
     * @return 1D dimentional array that contains the values from the 2D Array
     */
    public static int[] twoDConvert(int[][] twoDimension){ //Problem #4
        List<Integer> list = new ArrayList<Integer>();
        //for loop to collect the all of the data from the 2D array
        for(int row=0; row<twoDimension.length; row++) //rows
            for(int column=0; column<twoDimension[row].length; column++) //columns
                list.add(twoDimension[row][column]);
        int[] oneDimension = new int[list.size()]; //create 1D array the length of the Array List
        //For loop to transfer to the 2D array's data to the 1D array
        for(int i=0; i<oneDimension.length; i++){
            oneDimension[i] = list.get(i);
        }
        return oneDimension;
    }

    /**
     * The method takes an array of objects of type Rectangle. Among all the rectangle objects
     * it finds those that are actually squares (length==width), and doubles the values of their length and width fields.
     * The method does not return any result, it just changes the given array.
     * @param rectangles object to be tested if the side length's match
     */
    public static void doubleSquares(Rectangle[] rectangles) { //Problem #5 
        for (Rectangle r : rectangles) {
            if (r.getLength() == r.getWidth()) { // Checks if length and width are equal, meaning its a square
                double newVal = r.getLength(); // grabs value to be assigned and doubled
                newVal*=2; // does double the value
                r.setLength(newVal); // Updates the length to the new value
                r.setWidth(newVal); // Updates the width to the new value
            }
        }
    }

    /**
     * This method takes an ArrayList of integers and a range defined by two integer parameters named 
     * "from" and "to". The method removes all values from ArrayList that fall in the range [from, to].
     * It must make no more than one pass through the ArrayList when removing the values.
     * If the ArrayList is empty, the method does not do anything.
     * If "from" value is greater than "to" value, the method throws an IllegalArgumentException
     * @param aList Array List to have data removed from
     * @param from the starting index within the array
     * @param to the ending index within the array
     */
    public static int[] removeInRange(ArrayList<Integer> aList, int from, int to){ //Problem #6
        if (from > to) throw new IllegalArgumentException("From index cannot be larger than to index"); // Need to rename exception msg

        for (int i=0; i<aList.size(); i++) {
            int val = aList.get(i); // Value of current position for easier comparison
            if (from <= val && val <= to) {
                // if value is between from and to, removes it from List
                aList.remove(i);
                // Repositions for when removing value
                i--;
            }
        }
        // Converts List to int[]
        int[] newArr = new int[aList.size()];
        for (int i=0; i < newArr.length; i++) {
            newArr[i] = aList.get(i);
        }
        return newArr;
    }

    /**
     * This method takes an ArrayList of strings and an integer k. The method modifies 
     * the ArrayList by repeating each string it originally contains k times.
     * The method throws IllegalArgumentException when k is negative or a 0.
     * @param array Array list of orginial values
     * @param k number of times the values repeats
     */
    public static void repeat(ArrayList<String> array, int k) {
        if (k <= 0)
            throw new IllegalArgumentException("k cannot be negative or zero");
        if (k == 1) return; // If k is 1, array does not repeat
        int end = array.size(); // Sets hard end path to prevent infinite looping
        for (int i=0; i<end; i++) {
            for (int t=0; t<k; t++) {
                // Loops k times to append to the end
                array.add(array.get(i));
            }
        }
        for (int i=0; i<k; i++) {
            // remove placeholder values from front
            array.remove(0);
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        PrintStream out = System.out;
        testIsSorted(out);
        testMergeSortedArrays(out);
        testAllUniqueElements(out);
        testTwoDConvert(out);
        testDoubleSquares(out);
        testRemoveInRange(out);
        testRepeat(out);
    }
    /**
     * Runs all tests for isSorted() method
     * @param outputStream - output stream, used to print into the screen
     * 
     */
    public static void testIsSorted(PrintStream outputStream)
    {
        int[] unsorted = {1, 2, 66, 7, 8};
        int[] sorted = {33, 66, 77, 99};
        int[] one = {3};
        int[] empty = {};
        System.out.println("\r\n----Tests for isSorted()----\r\n");
 // Test #1   
        if(isSorted(sorted)==true && isSorted(unsorted)==false && isSorted(one)==true)
        {
            outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 01",  "FAILED");
 
// Test #2        
         try{
             boolean ignoreMe = isSorted(empty);
             outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException",  "FAILED");
         }
         catch(IllegalArgumentException e)
         {
            outputStream.printf("%-50s%-10s\r\n", "isSorted() TEST 02: IllegalArgumentException",  "PASSED");
                         
         }
                
    }
    /**
     * Runs all tests for mergeSortedArrays()
     * @param outputStream - output stream, used to print into the screen
     * 
     */
    public static void testMergeSortedArrays(PrintStream outputStream)
    {

        int[] a1 = {2, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 17};
        int[] a3 = {1, 2, 3, 4, 5, 8, 9, 10, 12, 17};
        int[] a4 = {2, 2, 3, 3, 5, 5, 8, 8, 12, 12};
        int[] b1 = {3};
        int[] b2 = {7};
        int[] b3 = {3, 7};
        int[] empty = {};
        System.out.println("\r\n----Tests for mergeSortedArrays()----\r\n");
 // Test #1 
        if(equal(mergeSortedArrays(a1, a2), a3))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 01",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 01",  "FAILED");

// Test #2 
        if(equal(mergeSortedArrays(a1, a1), a4))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 02",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 02",  "FAILED");
 
// Test #3
        if(equal(mergeSortedArrays(b1, b2), b3))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 03",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 03",  "FAILED");

// Test #4
        if(equal(mergeSortedArrays(empty, b2), b2) && equal(mergeSortedArrays(empty, empty), empty))
        {
            outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 04: Empty arrays",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "mergeSortedArrays() TEST 04: Empty arrays",  "FAILED");
 

    }
  /**
   * Runs all the tests for allUniqueElements() method
   * @param outputStream - output stream, used to print into the screen
   * 
   */  
    public static void testAllUniqueElements(PrintStream outputStream)
    {

        int[] a1 = {2, 16, 3, 5, 8, 12};
        int[] a2 = {1, 4, 9, 10, 9, 17};
        int[] a3 = {3};
        int[] empty = {};
        System.out.println("\r\n----Tests for allUniqueElements()----\r\n");
 // Test #1 
        if(allUniqueElements(a1))
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 01",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 01",  "FAILED");

// Test #2 
        if(allUniqueElements(a2)==false)
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 02",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 02",  "FAILED");
 
// Test #3
        if(allUniqueElements(a3))
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 03",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 03",  "FAILED");

// Test #4
        if(allUniqueElements(empty)==false)
        {
            outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 04: Empty array",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "allUniqueElements() TEST 04: Empty array",  "FAILED");

    }
/**
 * Runs all the tests for twoDConvert() method
 * @param outputStream - output stream, used to print into the screen 
 */    
    public static void testTwoDConvert(PrintStream outputStream)
    {
 
        int[][] a= {{1, 2, 3}, 
                    {4, 5, 6}, 
                    {7, 8, 9}};
        int[] aConverted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        int[][] c= {{1}, 
                    {4}, 
                    {7}};
        int[] cConverted = {1, 4, 7};
        int [][] b = {};
        int[] empty = {};
        System.out.println("\r\n----Tests for twoDConvert()----\r\n");
// Test #1 
        if(equal(twoDConvert(a),aConverted))
        {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 01",  "FAILED");
// Test #2 
        if(equal(twoDConvert(c),cConverted))
        {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 02",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 02",  "FAILED");
// Test #3 
        if(equal(twoDConvert(b),empty))
        {
            outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 03: Empty array",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "twoDConvert() TEST 03: Empty array",  "FAILED");

    }
    /**
     * Runs all the tests for doubleSquares() method
     * @param outputStream output stream, used to print into the screen 
     * 
     */
    public static void testDoubleSquares(PrintStream outputStream)
    {
      
        int size = 10;
        Rectangle[] shapes1 = new Rectangle[size];
        for(int i = 0; i<shapes1.length; i++)
        {
            if(i%3==0&& i!=0) shapes1[i] = new Rectangle(i+1, i+1); // building a square
            else shapes1[i] = new Rectangle(i+2, i+1); // building a regular rectangle
        }
        Rectangle[] shapes2 = new Rectangle[0];
        System.out.println("\r\n----Tests for doubleSquares()----\r\n");
 // Test #1 
        doubleSquares(shapes1);
        boolean passed = true;
        for(int i = 0; (i<shapes1.length) && passed; i++)
        {
            if(i%3==0 && i!=0) 
            {
                if(shapes1[i].getLength()!=(i+1)*2 || shapes1[i].getWidth()!=(i+1)*2)
                {
                    passed = false;
                }
            }
            else 
            {
                if(shapes1[i].getLength()!=i+2 || shapes1[i].getWidth()!=i+1)
                {
                    passed = false;
                }
            }
        }        
        if(passed)
        {
            outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 01",  "FAILED");  
  // Test #2        
        doubleSquares(shapes2);
        if(shapes2.length==0)
        {
            outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 02: Empty array",  "PASSED");
          
        }
        else outputStream.printf("%-50s%-10s\r\n", "doubleSquares() TEST 02: Empty array",  "FAILED");  

    }
   /**
    * Runs all the tests for removeInRange() method
     * @param outputStream - output stream, used to print into the screen
    */ 
    public static void testRemoveInRange(PrintStream outputStream)
    {    

        int[] tmp = {8, 6, 1, 4, 25, 1, 3, 7, 6, 8, 77, 3, 16};
        int[] test01 = {25, 77, 16};
        ArrayList<Integer> listA = new ArrayList();
        ArrayList<Integer> listB = new ArrayList();
        ArrayList<Integer> listTest01 = new ArrayList();
        ArrayList<Integer> listTest04 = new ArrayList();
        for(int i = 0; i<tmp.length; i++)
        {
           listA.add(tmp[i]);
           listB.add(tmp[i]);
        }
        for(int i = 0; i<test01.length; i++)
        {
            listTest01.add(test01[i]);
            listTest04.add(test01[i]);
        }
        listTest04.remove(0);
        System.out.println("\r\n----Tests for removeInRange()----\r\n");
// Test #1
        removeInRange(listA, 0, 10);
        if(listA.equals(listTest01))
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 01",  "PASSED");
          
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 01",  "FAILED");
// Test #2
        removeInRange(listB, -1, 100);
        if(listB.isEmpty())
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 02",  "PASSED");
           
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 02",  "FAILED");    
// Test #3
        removeInRange(listB, -1, 100);
        if(listB.isEmpty())
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 03: remove from empty list",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 03: remove from empty list",  "FAILED");    
 // Test #4
        removeInRange(listA, 25, 25);
        if(listA.equals(listTest04))
        {
            outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 04",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 04",  "FAILED");           
        
        try{
          removeInRange(listA, 2, 1);
          outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 05: Exception",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
           outputStream.printf("%-50s%-10s\r\n", "removeInRange() TEST 05: Exception",  "PASSED");
                      
        }
 
    }
 /**
  * Runs all the tests for repeat() method
  * @param outputStream - output stream, used to print into the screen
  */   
    public static void testRepeat(PrintStream outputStream)
    {

        
        ArrayList<String>listA = new ArrayList();
        listA.add("aa");
        listA.add("bb");
        listA.add("cc");
     
        ArrayList<String>listB = new ArrayList();
        String[] tmp = {"aa", "aa", "aa", "bb", "bb", "bb", "cc", "cc", "cc"};
        for(int i = 0; i<tmp.length; i++)
        {
            listB.add(tmp[i]);
        }
        System.out.println("\r\n----Tests for repeat()----\r\n");
// Test #1
        repeat(listA, 3);
       
        if(listA.equals(listB))
        {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 01",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 01",  "FAILED");
 
// Test #2
        repeat(listA, 1);
       
        if(listA.equals(listB))
        {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 02",  "PASSED");
            
        }
        else outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 02",  "FAILED");
 // Test #3
        try{
           repeat(listA, 0); 
           outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 03: Exception",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            outputStream.printf("%-50s%-10s\r\n", "repeat() TEST 03: Exception",  "PASSED");
            
        }
    }
            
/**
 * Compares two arrays of integers
 * @param one first array to compare
 * @param two second array to compare
 * @return returns true if arrays are the same, false if not
 */    
    public static boolean equal(int[] one, int[] two)
    {
        if(one.length!=two.length) return false;
        for(int i= 0; i<one.length; i++)  
        {
            if(one[i]!=two[i]) return false;
        }
        return true;
    }
 /**
  * Outputs into the screen an array of integers
  * @param a an array to print out
  */
    public static void printArray(int[] a)
    {
        if(a.length == 0) 
        { 
            System.out.println("[ ]");
            return;
        }  
         System.out.print("[");
         int i;
        for(i = 0; i<a.length-1; i++)
        {
            System.out.print(a[i]+", ");
        }
        System.out.print(a[i]+"]\n");
    }
}

