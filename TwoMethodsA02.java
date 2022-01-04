/**
 *
 * @author Your name here
 */
public class TwoMethodsA02{
    /**
     * Method checks if a triangle with given lengths of sides is a right triangle
     * @param a triangle side
     * @param b triangle side
     * @param c triangle side
     * @return true if the triangle is right, false if it is not
     */
    public static boolean isRightTri(int a, int b, int c){  
        //determine if  two int values squared are equivalent to the one of the other int value squared.
        if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){              //a^2 + b^2 = c^2    if c is the largest
            return true; 
        }else if (Math.pow(c , 2) + Math.pow(b, 2) == Math.pow(a, 2)){       //c^2 + b^2 = a^2    if a is the largest
            return true; 
        }else if (Math.pow(c, 2) + Math.pow(a, 2) == Math.pow(b, 2)){        //c^2 + a^2 = b^2    if b is the largest
            return true; 
        }else{
            return false; //if the triangle is NOT a correct right-triangle
        }
    }
    /**
     * The method takes hour, minute, and "am", "pm" components of the time stamp of the moment when car crosses the bridge and calculates the toll rate.
     * If any of the time stamp components are invalid, -1 is being returned as an error code.
     * @param hour hour component of the time stamp 
     * @param min minute component of the time stamp
     * @param amPm either string "am" or "pm", component of the time stamp
     * @return the toll rate  
     */
    public static double toll520Bridge(int hour, int min, String amPm){   //WORKING & DONE
        //12 to 4:59     am     Toll: $1.15
        //5 to 7:59      am     Toll: $1.40
        //8 to 10:59     am     Toll: $2.05
        //11a to 5:59p   am     Toll: $2.65
        //6 to 8:59      pm     Toll: $2.05
        //9 to 10:59     pm     Toll: $1.40
        //11 to 11:59    pm     Toll: $1.25

        //check if there is any immediate errors
         if ( (hour < 0 || hour > 12) || (min < 0 || min > 59) || !(amPm.equals("am") || amPm.equals("pm") ) ) {
            return -1;
        }if (amPm.equals("am")) { //If the amPm time is 'am'
            if (hour % 12 < 5) {
                return 1.25; //Toll: $1.15
            } if ( hour < 8) {
                return 1.40; //Toll: $1.40
            } if (hour < 11) {
                return 2.05; //Toll: $2.05
            } else {
                return 2.65; //Toll: $2.65
            }
        }else{ //IF the amPm time is 'pm'
            if (hour < 6) { 
                return 2.65; //Toll: $2.65
            } if (hour < 9) {
                return 2.05; //Toll: $2.05
            } if (hour < 11) {
                return 1.40; //Toll: $1.40
            } else {
                return 1.25; //Toll: $1.25
            }
        }
    }

    public static void testIsRightTri(){
         //*** Test 1 ***//
        if(isRightTri(3, 4, 5))
            System.out.println("Test 1 for isRightTri() PASSED"); //PASSED
        else System.out.println("Test 1 for isRightTri() Failed");
   
        //*** Test 2 ***//     
        if(isRightTri(4, 5, 3))
            System.out.println("Test 2 for isRightTri() PASSED");  //PASSED                     
        else System.out.println("Test 2 for isRightTri() Failed");
        
        //*** Test 3 ***//     
        if(isRightTri(5, 4, 3))
            System.out.println("Test 3 for isRightTri()) PASSED");
        else System.out.println("Test 3 for isRightTri() Failed"); //PASSED
        
        //*** Test 4 ***//     
        if(isRightTri(3, 5, 4))
            System.out.println("Test 4 for isRightTri() PASSED"); 
        else System.out.println("Test 4 for isRightTri() Failed"); //PASSED
        
        //*** Test 5 ***//     
        if(isRightTri(5, 3, 4))
            System.out.println("Test 5 for isRightTri() PASSED"); 
        else System.out.println("Test 5 for isRightTri() Failed"); //PASSED
        
        //*** Test 6 ***//     
        if(isRightTri(4, 3, 5))
            System.out.println("Test 6 for isRightTri() PASSED"); //PASSED
        else System.out.println("Test 6 for isRightTri() Failed");
        
        //*** Test 7 ***//     
        if(isRightTri(4, 4, 5))
            System.out.println("Test 7 for isRightTri() PASSED"); 
        else System.out.println("Test 7 for isRightTri() Failed"); //FAILED
    }
    
    public static void testToll520Bridge(){
        //12 am to 4:59    am     Toll: $1.15
        //5am to 7:59      am     Toll: $1.40
        //8am to 10:59     am     Toll: $2.05
        //1am to 5:59      am     Toll: $2.65
        //6pm to 8:59      pm     Toll: $2.05
        //9pm to 10:59     pm     Toll: $1.40
        //11pm to 11:59    pm     Toll: $1.25

        //*** Test 1 ***//  
        if(toll520Bridge(5, 20, "aa")==-1) 
            System.out.println("Test 1 for toll520Bridge() PASSED");
        else System.out.println("Test 1 for toll520Bridge() Failed"); //FAILED
        
        //*** Test 2 ***//  
        if(toll520Bridge(5, 65, "am")==-1) 
            System.out.println("Test 2 for toll520Bridge() PASSED");
        else System.out.println("Test 2 for toll520Bridge() Failed"); //FAILED
        
        
        //*** Test 3 ***//  
        if(toll520Bridge(15, 15, "am")==-1) 
            System.out.println("Test 3 for toll520Bridge() PASSED");
        else System.out.println("Test 3 for toll520Bridge() Failed"); //FAILED
        
        
        //*** Test 4 ***//  
        if(toll520Bridge(12, 0, "am")==1.25 && toll520Bridge(4, 59, "am")==1.25 && toll520Bridge(3, 35, "am")==1.25) 
            System.out.println("Test 4 for toll520Bridge() PASSED"); //PASSED
        else System.out.println("Test 4 for toll520Bridge() Failed"); 
        
        //*** Test 5 ***//  
        if(toll520Bridge(5, 0, "am")==1.4 && toll520Bridge(7, 59, "am")==1.4 && toll520Bridge(6, 03, "am")==1.4) 
            System.out.println("Test 5 for toll520Bridge() PASSED"); //PASSED
        else System.out.println("Test 5 for toll520Bridge() Failed");
        
        //*** Test 6 ***//  
        if(toll520Bridge(8, 0, "am")== 2.05 && toll520Bridge(10, 59, "am")==2.05 && toll520Bridge(9, 15, "am")==2.05) 
            System.out.println("Test 6 for toll520Bridge() PASSED"); //PASSED
        else System.out.println("Test 6 for toll520Bridge() Failed");
        
        //*** Test 7 ***//  
        if(toll520Bridge(11, 0, "am")==2.65 && toll520Bridge(4, 59, "pm")==2.65 && toll520Bridge(3, 55, "pm")==2.65) 
            System.out.println("Test 7 for toll520Bridge() PASSED"); //PASSED
        else System.out.println("Test 7 for toll520Bridge() Failed");
        
        //*** Test 8 ***//  
        if(toll520Bridge(6, 0, "pm")==2.05 && toll520Bridge(8, 59, "pm")==2.05 && toll520Bridge(6, 15, "pm")==2.05) 
            System.out.println("Test 8 for toll520Bridge() PASSED"); //PASSED
        else System.out.println("Test 8 for toll520Bridge() Failed");
        
        //*** Test 9 ***//  
        if(toll520Bridge(9, 0, "pm")==1.4 && toll520Bridge(10, 59, "pm")==1.4 && toll520Bridge(9, 3, "pm")==1.4) 
            System.out.println("Test 9 for toll520Bridge() PASSED"); //PASSED
        else System.out.println("Test 9 for toll520Bridge() Failed");
        
        //*** Test 10 ***//  
        if(toll520Bridge(11, 0, "pm")==1.25 && toll520Bridge(11, 59, "pm")==1.25 && toll520Bridge(11, 40, "pm")==1.25) 
            System.out.println("Test 10 for toll520Bridge() PASSED"); //PASSED
        else System.out.println("Test 10 for toll520Bridge() Failed");
    }
     /** Method main()contains all the tests 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testIsRightTri();
        testToll520Bridge();
    }
    
}