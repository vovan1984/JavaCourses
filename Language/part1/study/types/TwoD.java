package study.types;

public class TwoD<T>
{
	protected T x, y;
	
	public TwoD(T x, T y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString()
	{
		return String.format("length = %s, width = %s", x, y);
	}
}
