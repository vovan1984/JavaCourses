package study.reflection;

import java.lang.annotation.Annotation;

public class PackageReader
{
	private static void test()
	{

		Exception e = new Exception();
		e.printStackTrace();		
	}

	public static void main(String[] args)
	{
		Package p = study.annotations.MyAnno.class.getPackage();
		
		for (Annotation a : p.getAnnotations())
			System.out.println(a);

		test();
		
		PackageReader pr = new PackageReader();
		try
		{
			PackageReader pr2 = (PackageReader) pr.clone();
			System.out.println(pr2);
		} catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
