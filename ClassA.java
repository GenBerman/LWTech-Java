

/**
 * 
 * @author Your name here
 *
 */

public class ClassA {

	private String[] first;
	private int second;
	
	public ClassA()
	{
		first = new String[1];
		second = 0;
	}
	
	public ClassA(int capacity, int num)
	{
		first = new String[capacity];
		second = num;		
	}
	
	public String toString()
	{
		return "{first="+arrayToString(first)+"; second="+second+"}";
	}
	
	
    public void forTestsSetup(int limit)
    {
    	for(int i = 0; i<limit; i++)
    	{
    		Integer tmp = i;
    		first[i] = tmp.toString();
    	}    	
    }
    
    public void forTestsModify(int index)
    {
    	first[index] = "TEST";
    }
	
	private String arrayToString(String[] array)
	{
		if(array.length==0) return "[]";
		StringBuilder s = new StringBuilder("[");
		
		for(int i = 0; i< array.length-1; i++)
		{
			s.append(array[i]);
			s.append(", ");
		}
		s.append(array[array.length-1]);
		s.append("]");
		return s.toString();
	}

//******** Methods for you to implement ***********//
	
	public String[] getArray() {
		String[] newArr = new String[first.length];
		for(int i=0; i<first.length; i++) {
			newArr[i] = first[i];
		}
		return newArr;
	}

	public int getSecond() {
		return second;
	}
	// write copy constructor here
	/** 
	 * Add a copy constructor to ClassA code. Do not forget to make deep copies of all non-primitive fields.
	 * @param obj
	 */
	public ClassA(ClassA obj) {
		first = obj.getArray();
		second = obj.getSecond();
	}  
	
	// write equals() method here
	/**
	 * Add equals() method to ClassA. Two objects of ClassA are equal when corresponding 
	 * fields of the two objects are equal
	 * @param obj 
	 * @return true is the objects are equal to each other
	 */
	public boolean equals(ClassA obj) {
		return this.toString().equals(obj.toString());
	}


}
