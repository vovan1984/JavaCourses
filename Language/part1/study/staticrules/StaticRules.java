package study.staticrules;

abstract class A
{
	static int a = 5;
	
	static  void display(int k)
	{
		System.out.println("input = " + k);
	}
}

class B extends A
{}

interface X
{
	static int getNum()
	{
		return 8;
	}
}

class D implements X
{
}

public class StaticRules
{
	
	public static void main(String[] args)
	{
		System.out.println("Content of a in class A: " + A.a);
		
		// static interface methods are not inherited
		B.display(X.getNum());
	}
}
