import java.util.*;
/**
 *
 * @author Your name here
 */
 
public class TwoMethodsA03 {

   /**
   * Method finds and returns the largest digit in a given number 
   * @param num the number to analyze
   * @return the largest digit
   */
    public static int getLargestDigit(int num){       //WORKING
      /*Create a loop that scans the number one character at a time,
      Testing each character to see if it is largest, one the largest is determined;
      return the largest Digit */
      //Cant convert integer to string.
      int largest_Digit = 0;
      num = Math.abs(num);
      while(num>0){                         //what if n is negative or zero?
        if(largest_Digit < num%10){
          largest_Digit = num%10;
        }
        num/=10;
      }
      return largest_Digit;
    }

    /**
     * Method calculates and returns the sum of fractions 1/2 + 2/3 + ... + a/(a+1)
     * @param a the limit of the fraction pattern
     * @return the sum of fractions; returns -1 if the parameter value is less than 1
     */
    public static double fractionSum(int n){           //DONE DO NOT TOUCH
      /* Create a loop that repeats the formula (  a/[a+1]  )
      For as long as the value a is large, adding all functions 
      created together and return the final value. */
      double sum_of_fractions = 0;                            //Create return variable
      if(n<1)                                                 //if less than 1, return -1
        return -1;
      else{
        for(int i=1; i<=n; i++){                             //Create loop that lasts as long as n
          sum_of_fractions += ((double)i/((double)i+1));
        }
        return sum_of_fractions;                             //return sum of the fractions
      }
    }
  /**
   * A set of tests for getLargestDigit() method.  
   */
   public static void testGetLargestDigit(){
        //*** Test 1 ***// 
        if(getLargestDigit(-5)==5 && getLargestDigit(0)==0 && getLargestDigit(9)==9)
          System.out.println("Test 1 for getLargestDigit() PASSED");
        else System.out.println("Test 1 for getLargestDigit() Failed");

        //*** Test 2 ***//
        if(getLargestDigit(5565)==6 && getLargestDigit(9881)==9 && getLargestDigit(12348)==8 && getLargestDigit(33)==3)
          System.out.println("Test 2 for getLargestDigit() PASSED");
        else System.out.println("Test 2 for getLargestDigit() Failed");
   }
   /**
   * A set of tests for testFractionSum() method
   */
    public static void testFractionSum(){
        //*** Test 1 ***//
        if(fractionSum(-55)==-1 && fractionSum(0)==-1)
          System.out.println("Test 1 for fractionSum() PASSED");
        else System.out.println("Test 1 for fractionSum() Failed");
        
        //*** Test 2 ***//
        if(fractionSum(1)==0.5)
          System.out.println("Test 2 for fractionSum() PASSED");
        else System.out.println("Test 2 for fractionSum() Failed");
        
        //*** Test 3 ***//
        if(Math.round(fractionSum(5)*100.0)/100.0== 3.55)
          System.out.println("Test 3 for fractionSum() PASSED");
        else System.out.println("Test 3 for fractionSum() Failed");
        
        //*** Test 4 ***//
        if(Math.round(fractionSum(250)*1000.0)/1000.0== 244.895)
          System.out.println("Test 4 for fractionSum() PASSED");
        else System.out.println("Test 4 for fractionSum() Failed");  
        
        //*** Test 5 ***//
        if(Math.round(fractionSum(251)*1000.0)/1000.0== 245.891)
          System.out.println("Test 5 for fractionSum() PASSED");
        else System.out.println("Test 5 for fractionSum() Failed");  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testGetLargestDigit();
        testFractionSum();
    }
}
