/**
 *
 * @author Your name here
 */
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
     * @return String of the legs lengths
     */
    public String toString(){
      // String str = "legA = 3.0,  legB = 4.0";
        return "legA = " + legA + ",  legB = " + legB;
    }
} //RIGHT TRIANGLE CLASS ENDS