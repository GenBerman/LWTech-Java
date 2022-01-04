
public class ClassD {
	private int whole;
	private double real;

	public ClassD(){
		whole = 0;
		real  = 0.0;
	}
	
	public ClassD(int n, double d){
		whole = n;
		real = d;
	}
	
	public ClassD(ClassD obj){
		whole = obj.whole;
		real = obj.real;		
	}
	
	
	public void set(int n, double d){
		whole = n;
		real = d;		
	}

	public boolean isLess(ClassD obj){
		return whole+real < obj.whole+obj.real;
	}
	
	public boolean isMore(ClassD obj){
		return whole+real > obj.whole+obj.real;
	}
	
	public double toDouble(){
		return whole+real;
	}
	
	public String toString(){
		return String.format("[%d, %.1f]", whole, real);
	}
}
