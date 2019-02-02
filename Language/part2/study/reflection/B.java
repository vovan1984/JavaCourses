package study.reflection;

public class B extends A
{
	double z;
	
	public B()
	{
		z = 0.0;
	}
	
	public B(double z)
	{
		this.z = z;
	}
	
	protected B(int k, double z)
	{
		super(k);
		this.z = z;
	}
}