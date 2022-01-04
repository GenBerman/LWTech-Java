/**
 *
 * @author Your name here
 */

//Write a definition of a class named Point that might be used to store and manipulate the location of a point on the plane.
public class Point{
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