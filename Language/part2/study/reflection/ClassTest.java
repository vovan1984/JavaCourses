// display all constructors of a class
package study.reflection;

import java.lang.reflect.Constructor;

public class ClassTest
{

	public static void main(String[] args)
	{
		Constructor<?>[] cArr;

		System.out.println(ClassTest.class.getModule());
		
		cArr = A.class.getConstructors();
		System.out.println("\nConstructors of A: ");
		for (Constructor<?> c : cArr)
			System.out.println(c);
		
		cArr = B.class.getDeclaredConstructors();
		System.out.println("\nAll constructors of B: ");
		for (Constructor<?> c : cArr)
			System.out.println(c);
	}

}
