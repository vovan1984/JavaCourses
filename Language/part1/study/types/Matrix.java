package study.types;

public class Matrix
{
	private int [][] data;
	int rows, columns;
	
	// create data using input array
	public Matrix(int[][] data)
	{
		if (data == null || data.length == 0 || data[0].length == 0)
			throw new IllegalArgumentException("Wrong matrix dimensions!");
		
		this.data = data;
		rows = data.length;
		columns = data[0].length;
	}
	
	// create zero filled matrix
	public Matrix(int rows, int columns)
	{
		if (rows <= 0 || columns <= 0)
			throw new IllegalArgumentException("Wrong matrix dimensions!");
		
		data = new int[rows][columns];
		this.rows = rows;
		this.columns = columns;
		
		for (int i=0; i<rows; i++)
			for (int j=0; j<columns; j++)
				data[i][j] = 0;
	}
	
	public int getData(int i, int j)
	{
		return data[i][j];
	}
	
	public void setData(int i, int j, int value)
	{
		data[i][j]=value;
	}
	
	public void show()
	{
		for (int i=0; i<rows; i++)
		{
			for (int j=0; j<columns; j++)
				System.out.print(data[i][j] + " ");
			System.out.println();
		}
	}
}