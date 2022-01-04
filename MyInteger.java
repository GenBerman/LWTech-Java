/**
 *
 * @author Your name here
 */
public class MyInteger{
    private int num; //A data field of type int

    /**
     * constructor that sets the field integer equivalent to input parameter
     * @param numIn input parameter that is to be the data field value
     */
    public MyInteger(int numIn) {
        num = numIn;
    }

    /** 
     * Method that returns the value of the field
     * @return the value of the field
     */
    public Integer toInteger(){
        //TODO complete this method
        return num;
    }

    /** 
     * Will Return true if the value in the object is Even
     * Instance Method
     * @return true if the number is even
     */
    public boolean isEven(){
        //TODO complete this method
        return isEven(num);
    }

    /** 
     * Will Return true if the value in the object is Odd
     * Instance Method
     * @return  true if the number is odd
     */
    public boolean isOdd(){
        //TODO complete this method
        return isOdd(num);
    }

    /** 
     * Will Return true if the value in the object is a Prime Number
     * Instance Method
     * @return  true if the number is prime
     */
    public boolean isPrime(){
        return isPrime(num); //TODO update this
    }

    /** 
     * Will Return true if the value in the object is Even
     * Static Method
     * @param num field value
     * @return  true if the number is even
     */
    public static boolean isEven(int num){
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** 
     * Will Return true if the value in the object is Odd
     * Static Method
     * @param num field value
     * @return  true if the number is odd
     */
    public static boolean isOdd(int num){
        return !isEven(num);
    }

    /** 
     * Will Return true if the value in the object is a Prime Number
     * Static Method
     * @param num field value
     * @return  true if the number is prime
     */
    public static boolean isPrime(int num){
        for (int x=2; x < num/2; x++) {
            if (num % x == 0) {
                return false;
            }
        }
        return true;
    }

    /** 
     * Will return true if the value in this object is equal to the specified value.
     * Instance Method
     * @param num comparison parameter value
     * @return true if the number is equivalent
     */
    public boolean equals(int cmp){
        return num == cmp;
    }

    /** 
     * Will return true if the value  in this object is equal to the specified value.
     * Instance Method
     * @param otherInt comparison parameter value
     * @return true if the number is equivalent
     */
    public boolean equals(MyInteger otherInt){
        return num == otherInt.toInteger();
    }

    /** 
     * Converts a String into an integer value, positive or negative. 
     * Method throws IllegalArgumentException when:
     *       A string contains non-digit characters (other than '-' as the very first character of the sting).
     *       A string has only '-' and no digits.
     *       A string represents a number that is too large to be stored as integer and produces overflow
     *       A string represents a number that is too small to be stored as integer and produces underflow
     * Static Method 
     * @param str string to be converted to integer
     * @return original string value converted to integer
     */
    public static int parseInt(String str){
        // final int BEG = 48, END = 57;
        int retval = 0; // Value to be returned at the end
        boolean parity = true; // whether the value is positive or negative
        try {
            // Checks if string is positive and negative
            if (str.charAt(0) == '-') {
                // If string contains - but no digits throws error
                if (str.length() < 2) throw new IllegalArgumentException("String is only '-'");
                else 
                    parity = false;
            }
            // for loop assigns i to 1 if negative to skip the '-' char
            for ( int i = (parity) ? 0 : 1; i<str.length(); i++ ) {
                // assigns the current character to ch
                char ch = str.charAt(i);
                // Checks if the ch is actually between 0-9 digits and not some other char
                if ( '0' <= ch && ch <= '9' ) {
                    int val = ch % '0'; // converts ascii to digit value for easier addition
                    int logVal = (int)Math.pow(10, str.length() - i - 1); // value to multiply val by to get proper placement
                    if (parity) { // if number is positive add the values
                        retval = Math.addExact(retval, val * logVal); // Mat
                    } else { // if number is negative subtract the values
                        retval = Math.subtractExact(retval, val * logVal);
                    }
                } else throw new IllegalArgumentException("Char within string is not digit");
            }

        } catch(Exception E) {
            //System.out.println(E);
            throw new IllegalArgumentException();
        }
        return retval;
    }
} //MY INTEGER CLASS ENDS
