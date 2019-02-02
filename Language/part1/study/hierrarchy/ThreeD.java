package study.hierrarchy;

public class ThreeD extends study.types.TwoD<Integer>
{
	private int z;
	
	ThreeD(int x, int y, int z)
	{
		super(x, y);
		this.z = z;
	}

	int volume ()
	{	
		return x * y * z;
	}
	
	@Override
	public String toString()
	{
		String str = String.format("%s, length = %d", super.toString(), z);
		
		return str;
	}
}
