package practise;

public class GenericMethodPractise {
	
	public static void main(String[] args) {
		//caller
		
		
		//hardcoded
//		int a=10;
//		int b=15;
//		int c=a+b;
//		System.out.println(c);
		
		System.out.println(add(20,40));
		System.out.println(add(100,200));
		int sum=add(90,705);
		System.out.println(sum+10);
		
	}
	
	
	//generic/resuable
	public static int  add(int a,int b)//called
	{
		int c=a+b;
		return c;
		
	}
}
