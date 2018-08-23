
public class TestMaxDemo {

	public static void main(String[] args) {
		//MaxFinder mf=new MaxFinderImpl(); 
		
		MaxFinder mf=(a,b)->(a>b)?a:b;
		System.out.println("Greatest number is:"+mf.max(56,67));	

	}
}
