/**
 *
 * @author Your name here
 */

//Write a definition of a class named Point that might be used to store and manipulate the location of a point on the plane.
class Point{
    private double x;
    private double y;

    /** 
     *  Non-default constructor that takes x and y coordinate of the point and sets member variables
     * @param x is the x of our point
     * @param y is the y of our point
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /** 
     *  Default constructor that sets the point coordinates to (0,0)
     */
    public Point(){
        this(1, 1);
    }

    /**
     * Method setX sets the private data after an object of this class
     * @param x The value to store in x
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * Method setY sets the private data after an object of this class
     * @param y The value to store in y
     */
    public void setY(double y){
        this.y = y;
    }

     /**
     * The getX method returns a point object's x.
     * @return The value in the x field
     */
    public double getX(){
        return this.x;
    }

    /**
     * The getY method returns a point object's y.
     * @return The value in the y field
     */
    public double getY(){
        return this.y;
        //return yy
    }

    /**
     * The move method moves the point by an amount along the vertical and
     * horizontal directions specified by the first and second arguments
     * @param dx - the distance to move this point along the x axis.
     * @param dy - the distance to move this point along the y axis.
     */
    public void move(double dx, double dy){
        x += dx;
        y += dy;
    }

    public void rotate(){
      double tmpX = x;
      x = y;
      y = -tmpX;
    }
} //POINT CLASS ENDS

class RightTriangle{
    private double legA;
    private double legB;

    /**
     * Constructor - Accepts legs of the right triangle as arguments. Constructor
     * throws Illegal Argument Exception when one or both legs are set to 0 or
     * negative number(s)
     * @param a
     * @param b
     */   
    //@SuppressWarnings("empty-statement")
    public RightTriangle(double a, double b){
        legA = a;
        legB = b;
        if(a<0.00 || b<0.00){
            throw new IllegalArgumentException("Legs cannot be negative");
        }
    }

    public RightTriangle() {
        this(1,1);
    }

    /**
     * The setLegA method stores a value in the legA field.
     * Mutator methods. Both methods throw Illegal Argument Exception when 
     * leg is set to 0 or negative number.
     * @param a the value to store in legA
    */   
    public void setLegA(double a){
        if(a <= 0){
            throw new IllegalArgumentException("Legs cannot be negative");
        }
        legA = a;
    }

     /**
     * The setLegB method stores a value in the legB field.
     * Mutator methods. Both methods throw Illegal Argument Exception when 
     * leg is set to 0 or negative number.
     * @param b the value to store in legB
    */   
    public void setLegB(double b){
        if(b <= 0){
            throw new IllegalArgumentException("Legs cannot be negative");
        }
        legB = b;
    }

    /**
     * The getLegA method returns a RightTriangle object's legA.
     * Accessor methods
     * @return The value in the legA field.
     */
    public double getLegA(){
        return legA;
    }

    /**
     * The getLegB method returns a RightTriangle object's legB.
     * Accessor methods
     * @return The value in the legB field.
     */
    public double getLegB(){
        return legB;
    }

    /**
     * The getArea method returns a RightTriangle object's area.
     * @return The product of length times width.
     */
    public double getArea(){
        return (0.5)*(legA * legB);
    }

    /**
     * The getHypotenuse method returns a Hypotenuse object's area.
     * @return Hypotenuse
     */
    public double getHypotenuse() {
        return Math.sqrt(legA * legA + legB * legB);
    }

    /**
     * The getPerimeter method returns a Perimeter object's area.
     * @return Perimeter
     */
    public double getPerimeter() {
        return (legA + legB + this.getHypotenuse());
    }

    /** 
     * method that represents object as a string in the following format: "legA = 3.0, legB = 4.0"
     * Do not use any existing methods that convert string into an integer or a floating point number of any sort.
     * @return 
     */
    public String toString(){
      // String str = "legA = 3.0,  legB = 4.0";
        return "legA = " + legA + ",  legB = " + legB;
    }
} //RIGHT TRIANGLE CLASS ENDS

class MyInteger{
    private int num; //A data field of type int

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
     * @return 
     */
    public boolean isEven(){
        //TODO complete this method
        return isEven(num);
    }

    /** 
     * Will Return true if the value in the object is Odd
     * Instance Method
     * @return 
     */
    public boolean isOdd(){
        //TODO complete this method
        return isOdd(num);
    }

    /** 
     * Will Return true if the value in the object is a Prime Number
     * Instance Method
     * @return 
     */
    public boolean isPrime(){
        return isPrime(num); //TODO update this
    }

    /** 
     * Will Return true if the value in the object is Even
     * Static Method
     * @return 
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
     * @return 
     */
    public static boolean isOdd(int num){
        return !isEven(num);
    }

    /** 
     * Will Return true if the value in the object is a Prime Number
     * Static Method
     * @return 
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
     * @return
     */
    public boolean equals(int cmp){
        return num == cmp;
    }

    /** 
     * Will return true if the value  in this object is equal to the specified value.
     * Instance Method
     * @return
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

public class Assignment05 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){       
        allTestsPointClass();
        allTestsRightTriangleClass();
        allTestsMyIntegerClass();       
    }
  
    public static void allTestsPointClass(){ 
        System.out.println("\n----Tests for Point Class----\n");
        test01PointClass();
        test02PointClass();
    }

    public static void allTestsRightTriangleClass(){ 
        System.out.println("\n----Tests for RightTriangle Class----\n");
        test01TriangleClass();
        test02TriangleClass();
        test03TriangleClass(); 
    }

    public static void allTestsMyIntegerClass(){ 
        System.out.println("\n----Tests for MyInteger Class----\n");
        test01MyIntegerClass();
        test02MyIntegerClass();
        test03MyIntegerClass();
    }
    
    
    public static void test01PointClass(){
        
        double x1 = 33.1,  y1 = 44; // point  coordinates for setting
        double xx1 = 33.1, yy1= 44; //- expected point coordinates
 
    //Test #1  
        Point point1 = new Point(); 
        point1.setX(x1);
        point1.setY(y1);
        if(point1.getX()==xx1 && point1.getY()== yy1) 
        {
            System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for set and get methods",  "PASSED");
           
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for set and get methods",  "FAILED");

        double x11 = 1, y11= 1; //- expected point11 default coordinates

    //Test #2
        Point point11 = new Point(); 
        if(point11.getX()==x11 && point11.getY()==y11) 
        {
            System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for non-argument constuctor",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 01: Test for non-argument constuctor",  "FAILED");
    }
    
  

    public static void test02PointClass(){
        double x2 = -925.5, y2 = 6; // point2  coordinates
        double xx2 = -925.5, yy2= 6; //- expected point2  coordinates

    //Test #1        
        Point point2 = new Point(x2, y2); 
        if(point2.getX()==xx2 && point2.getY()==yy2){
            System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for constructor with parameters",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for constructor with parameters",  "FAILED");    	

        double x1  = 125, y1 = 25; //  - original point coordinates
        double dx1 = 30, dy1 = -5; // - how the point moved
        double xx1 = 155, yy1 = 20; //- point after movement
        double rx1 = 20, ry1= -155; //- point after rotation

        Point point1 = new Point(); 
        point1.setX(x1);
        point1.setY(y1);

    //Test #2          
        point1.move(dx1, dy1);
           
        if(point1.getX()==xx1 && point1.getY()==yy1) {
            System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for move() method",  "PASSED");
        }
        else   System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for move() method",  "FAILED");

    //Test #3       
        point1.rotate();
        if(point1.getX()==rx1 && point1.getY()==ry1){
            System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for rotate() method",  "PASSED"); 
        }
        else  System.out.printf("%-80s%-10s\n", "Point TEST 02: Test for rotate() method",  "FAILED");
    }
    
    // set, get, throwing exceptions
    
    public static void test01TriangleClass(){
        double a1 = 10.1, b1 = 15.1; // legs for the set  method tests
        double aa1 = 10.1, bb1 = 15.1; // expected values for set method tests
        
        double a2 = -5, b2 = -5; // values for testting exceptions
        
    //Test #1          
        RightTriangle tri1 = new RightTriangle();
        tri1.setLegA(a1);
        tri1.setLegB(b1);
        if(tri1.getLegA()==aa1 && tri1.getLegB()== bb1) {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for set and get methods",  "PASSED");
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for set and get methods",  "FAILED");

    //Test #2  
        try{
            tri1.setLegA(a2);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegA and exception it must throw",  "FAILED");
        }catch (IllegalArgumentException e){
             System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegA and exception it must throw",  "PASSED");  
        }

 //Test #3
        try{
            tri1.setLegB(b2);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegB and exception it must throw",  "FAILED");
        }catch (IllegalArgumentException e){
             System.out.printf("%-80s%-10s\n", "Right Triangle TEST 01: Test for setLegB and exception it must throw",  "PASSED");    
        }
    }
    
    // constructors and exceptions
    public static void test02TriangleClass(){
        double a1 = 10.5, b1 = 15.3; // legs for constructor with parameters
        double aa1 = 10.5, bb1 = 15.3; // expected values to be set by constructor
        
        double aa2 = 1, bb2 = 1; // values for testing default constructor
        
        double a3 = -51, b3 = -8; // values for testing exceptions

 //Test #1       
        RightTriangle tri1 = new RightTriangle(a1, b1);
  
        if(tri1.getLegA()==aa1 && tri1.getLegB()== bb1) {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constuctor with parameters",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constuctor with parameters",  "FAILED");

//Test #2        
        RightTriangle tri2 = new RightTriangle();
  
        if(tri2.getLegA()==aa2 && tri2.getLegB()== bb2) {
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for no-argument constuctor",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for no-argument constuctor",  "FAILED");

//Test #3        
        try{
            tri1.setLegA(a3);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "FAILED");
        }catch (IllegalArgumentException e){
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "PASSED");
        }

//Test #4
        try{
            tri1.setLegB(b3);
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "FAILED");
        }catch (IllegalArgumentException e){
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 02: Test for constructor and exception it must throw",  "PASSED");
        }
    }
    // area, hypotenuse, perimeter, toString()

    public static void test03TriangleClass(){      
        double a1 = 3, b1 = 4; // legs 
        double hyp = 5;// expected hypotenuse 
        double perim = 12; // expected perimeter
        double area = 6; // expected area
        String str = "legA = 3.0,  legB = 4.0"; // expected toString() result
        
        RightTriangle tri1 = new RightTriangle();
        tri1.setLegA(a1);
        tri1.setLegB(b1);
  
        if(tri1.getArea() == area && tri1.getHypotenuse() == hyp && tri1.getPerimeter()==perim){
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for area, hypotenuse, and perimeter calculations",  "PASSED");
           
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for area, hypotenuse, and perimeter calculations",  "FAILED");
   
        if(tri1.toString().equals(str)){
            System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for toString()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "Right Triangle TEST 03: Test for toString()",  "FAILED");

    }
    
    public static void test01MyIntegerClass(){ 
        int a = 55;
        int b = 102;
        int prime = 97;
        
 //Test #1       
        MyInteger num1 = new MyInteger(a);
        if(num1.toInteger()==a){
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for constuctor",  "PASSED");    
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for constuctor",  "FAILED");
  //Test #2       
        MyInteger num2 = new MyInteger(b);
        
        if(!num1.isEven()&& num1.isOdd()&& num2.isEven() && !num2.isOdd())
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isEven() and isOdd()",  "PASSED");
           
        }
        else   System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isEven() and isOdd()",  "FAILED");
  //Test #3           
        MyInteger num3 = new MyInteger(prime);
        if(num3.isPrime() && !num2.isPrime() && !num1.isPrime())
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isPrime()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 01: Test for isPrime()",  "FAILED");

    }
    
    public static void test02MyIntegerClass()
    { 
        int a = 103;
        int b = 500;
        int prime = 919;
        
//Test #1          
        if(!MyInteger.isEven(a)&& MyInteger.isOdd(a)&& MyInteger.isEven(b) && !MyInteger.isOdd(b))
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isEven() and static isOdd()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isEven() and static isOdd()",  "FAILED");
//Test #2          
        if(MyInteger.isPrime(prime) && MyInteger.isPrime(a) && !MyInteger.isPrime(b))
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isPrime()",  "PASSED");
            
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for static isPrime()",  "FAILED");
//Test #3        
        MyInteger num1 = new MyInteger(a);
        MyInteger num2 = new MyInteger(a);
        
        if(num1.equals(a) && num1.equals(num2))
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for both isEquals() methods",  "PASSED");
             
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 02: Test for both isEquals() methods",  "FAILED");
        
    }
    
    public static void test03MyIntegerClass()
    { 
      

//Test #1       
       if(MyInteger.parseInt("2147483647") == 2147483647 && MyInteger.parseInt("12") == 12 && MyInteger.parseInt("0") == 0)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid positive values",  "PASSED");
             
        }
        else  System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid positive values",  "FAILED");  
//Test #2       
       if(MyInteger.parseInt("-54321") == -54321 && MyInteger.parseInt("-2147483648") == -2147483648 && MyInteger.parseInt("-3") == -3)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid negative values",  "PASSED");
             
        }
        else System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() with valid negative values",  "FAILED");
//Test #3
       try // overflow detection test
        {
            int k = MyInteger.parseInt("2147483648");
             System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() overflow",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() overflow",  "PASSED");
            
        }
//Test #4        
        try // underflow detection test
        {
            int k = MyInteger.parseInt("-2147483649");
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() underflow",  "FAILED"); 
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() underflow",  "PASSED");
            
        }
//Test #5
        try // non-digit characters detection test
        {
            int k = MyInteger.parseInt("4a5");
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits",  "PASSED");
            
        }
//Test #6
        try // non-digit characters detection test (special case)
        {
            int k = MyInteger.parseInt("-");
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits (just '-')",  "FAILED");
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%-80s%-10s\n", "MyInteger TEST 03: Test for parseInt() invalid digits (just '-')",  "PASSED");
            
        }

    }
}
