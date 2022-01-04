import java.io.*;
import java.util.Arrays;

// import jdk.internal.org.jline.reader.impl.completer.NullCompleter;

/**
 *
 * @author Your name here
 */

/**
 * Create a class named DynamicArray that will have convenient functionality similar to JavaScript’s Array object
 * and Java’s ArrayList class. The class allows to store array of integers that can grow and shrink as needed, 
 * search for values, remove elements, etc.
 */ 
class DynamicArray{
    //1. You MUST store the data internally in a regular partially-filled array of integers. 
    private int array[];
    //2. This variable stores the number of "occupied" elements in the array. Set to 0 in the constructor.
    private int size;

    /** 
     * 3. The parameter defines the capacity of initial array. Allocates array of given capacity, sets size field to 0.
     * In case the parameter given to constructor is less than 0, IllegalArgumentException is being thrown.  
     * @param capacity
     */
    public DynamicArray(int capacity){
        if(capacity<0)
            throw new IllegalArgumentException("Parameter is less than 0");
        array = new int[capacity];
        size = 0;
    } 

    /** 
     * 4. Allocates array of size 3, assigns it to the array field, sets size field to 0.
     */
    public DynamicArray() {
        array = new int[3];
        size = 0;
    } 

    /** 
     * 5. The constructor takes an object of type DynamicArray as a parameter and copies it into the object it creates.
     * The constructor throws IllegalArgumentException if the object that was passed to copy from is null.
     */
    public DynamicArray(DynamicArray obj) { 
        if (obj == null)
            throw new IllegalArgumentException("The parameter array is null");
        array = obj.getArray(); // getArray returns duplicate so declaration is ok
        size = obj.getSize(); // Copies size from parameter array to this size
    }
     
    /** 
     * 6. returns the number of "occupied" elements in the array.
     * @return the size of the array
     */
    public int getSize(){
        return size;
    } 

    /** 
     * 7. returns the actual size (length) of the partially-filled array
     * @return
     */
    public int getCapacity(){ 
        return array.length;
    }

    /** 
     * 8. accessor returns the entire partially-filled array.
     * Make sure you DO NOT return the private array field, make a copy of it.
     * @return
     */
    public int[] getArray(){ 
        return Arrays.copyOf(array, getCapacity());
    }

    /** 
     * 9. accessor returns an "occupied" part of the partially-filled array.
     * Make sure you DO NOT return the private array field. Instead, allocate memory for the new array,
     * copy the "occupied" portion of the field into that new object, and return the new array.
     * @return the newly copied array
     */
    int[] toArray(){
        int[] newArray = Arrays.copyOf(array, getSize()); // Only grabs the "occupied" data to copy
        return newArray;
    }

    /** 
     * 10. adds a new element to the end of the array and increments the size field. If the array is full,
     * you need to increase the capacity of the array: 
     *      Create a new array with the size equal to double the capacity of the original one. 
     *      Copy all the elements from the array field to the new array. 
     *      Add the new element to the end of the new array. 
     *      Use new array as an array field. 
     *      Make sure your method works well when new elements are added to an empty DynamicArray.
     * @param num
     */
    public void push(int num) {
        if(getSize() == getCapacity()) { // Checks if the array is full
          //TODO Finish this
          int[] newArr = new int[getCapacity()*2];
          int i; // Declare variable outside so we can save last position to push num to
          for (i=0; i<getSize(); i++) {
            newArr[i] = array[i];
          }
          newArr[i] = num;
          array = Arrays.copyOf(newArr, newArr.length);
        } else {
          array[getSize()] = num;
        }
        // System.out.println("Size: " +size+" Cap: " +getCapacity());
        // System.out.print("Pushed "+num);
        // System.out.println(Arrays.toString(array));
        size++;
    } 

    /** 
     * 16. removes the last element of the array and returns it. Decrements the size field.
     * If the array is empty a RuntimeException with the message "Array is empty" must be thrown.
     * At this point check the capacity of the array. If the capacity is 4 times larger than the number
     * of occupied elements (size), it is time to shrink the array: 
     *      Create a new array with the size equal to half of the capacity of the original one. 
     *      Copy all the elements from the array field to the new array. 
     *      Use new array as an array field. 
     */
    public int pop() {
      System.out.print("Size: " +size);
        if(size==0){
            throw new RuntimeException("Array is empty.");
        }else if(getCapacity()*4 >= getSize()) {
            array = Arrays.copyOf(array, getCapacity()/2);
        }
        size--;
        int popVal = array[getSize()]; // Assigns last occupied element to popVal
        array[getSize()] = 0; // Assigns the last element to zero to return to default state
        System.out.println(toString());
        System.out.println("Last element of the array is: " + popVal);
        return popVal;
    }

    /** 
     * 17. returns element of the array with the requested index. If the index provided is too large
     *  or negative, the IndexOutOfBoundsException is thrown with the message "Illegal index".
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    int get(int index) { 
        if (index > getSize() || index < 0)
            throw new IndexOutOfBoundsException("Index out of range.");
        System.out.println("Array by index " + index + " is: " + array[index]);
        return array[index];
        
    }

    /** 
     * 18. returns the index of the first occurrence of the given number. Returns -1 when the number is not found.
     * @param key
     * @return the index of the first occurrence of the given number.
     */
    int indexOf(int key){
        for(int i=0;i<size; i++){
            if(array[i] == key){
                System.out.println("Number " + key + " at index " + i);
                return i;
            }
        }
        System.out.println("Number not found.");
        return -1;
    }

    /** 
     * 19. adds a new element (passed as parameter num) to the location of the array specified by index parameter.
     * If the index is larger than size of the array or less than 0, IndexOutOfBoundsException is thrown.
     * When adding the element into the middle of the array, you’ll have to shift all the elements to the right
     * to make room for the new one. If the array is full and there is no room for a new element,
     * the array must be doubled in size.
     * @param index
     * @param num
     */
    void add(int index, int num) { //????????????????????
        if (index > getCapacity() || index < 0) 
            throw new IndexOutOfBoundsException("Index was not within the array capacity.");
        int newArr[];
        if (getSize() == getCapacity()) {
          newArr = new int[getCapacity() * 2];
        } else {
          newArr = new int[getCapacity()];
        }
         
        for (int i=0; i<index; i++) {
          newArr[i] = array[i];
        }
        newArr[index] = num;
        for (int i=index; i<getSize(); i++) {
          newArr[i+1] = array[i];
        }
        array = Arrays.copyOf(newArr, newArr.length);
        size++;
    }  

    /** 
     * 20. removes the element at the specified position in this array. When the element is removed from the middle of the array,
     * all the elements must be shifted to close the gap created by removed element. If the index value passed into the method is
     * more or equal to the size or less than 0 the IndexOutOfBoundsException must be thrown. At this point check the capacity of
     * the array. If the capacity is 4 times larger than the number of occupied elements (size), it is time to shrink the array.
     * @param index
     */
    int remove(int index) {
      if (isEmpty())
        throw new IndexOutOfBoundsException("Array is empty!!!");
      if (index >= getSize() || index < 0)
        throw new IndexOutOfBoundsException("Index is not within the array");
      if (getSize() * 4 <= getCapacity()) // if capacity is 4 times larger than size of occupied elements
          array = Arrays.copyOf(array, array.length / 2);
      int retval = array[index];
      for (int i = index; i < getSize(); i++)
                array[i] = array[i + 1];
      size--;
            // System.out.println(Arrays.toString(array));
      return retval;
    }

    /** 
     * 21. returns true if the size of the array is 0.
     * @return
     */
    boolean isEmpty(){
        if (size == 0) {
            // System.out.print("Array is empty");
            return true;
        }
        // System.out.print("Array is not empty");
        return false;
    }

    /** 
     * 22. returns an array as a string of comma-separated values. Sample: [1, 2, 3, 4]
     * @return
     */
    public String toString(){
      if (isEmpty())
        return "[ ]";
      return Arrays.toString(Arrays.copyOf(array, getSize()));
    }

    /** 
     * 23. compares two objects (this one and the one passed as parameter) element-by-element
     * and determines if they are exactly the same. The capacity of the two objects is not 
     * being compared and can be different.
     */
    boolean equals(DynamicArray obj){
      System.out.println("This: " + toString());
      System.out.println("Obj: " + obj.toString());
        if (getSize() != obj.getSize()) { // Compares if the occupied elements is different
            // System.out.println("Arrays are not equals! Size is different!");
            return false;
        }
        if (isEmpty() && obj.isEmpty())
          return true;
        int[] array2 = obj.toArray();
        //Iterates through elements and compares each one for equality
        for (int i = 0; i < getSize(); i++) {
            if (array[i] != array2[i]) {
                // System.out.println("Arrays are not equals!");
                return false;
            }
        }
        // System.out.println("Arrays are equals!");
        return true;
    }
} //END OF DYNAMIC ARRAY CLASS
