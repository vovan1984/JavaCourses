package study.annotations;

import java.lang.reflect.Method;

public class AnnotationTest
{
	@MyAnno(str="Program additional function", val = 1)
	public static void showHello()
	{
		System.out.println("Hello, Vova!");
	}
	
	@MyAnno(str="Program start function", val = 1)
	public static void main(String[] args)
	{
		Class<?> mainClass = AnnotationTest.class;
//		Class<?> charClass = char.class;
		
		try
		{
			Method meth = mainClass.getMethod("main", args.getClass());
			MyAnno anno = meth.getAnnotation(MyAnno.class);
			System.out.println(anno);
		} catch (NoSuchMethodException | SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showHello();
	}

}
