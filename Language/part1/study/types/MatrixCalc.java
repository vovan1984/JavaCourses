package study.types;

public class MatrixCalc
{
	public static Matrix multiplyMatrices(Matrix first, Matrix second)
	{
		if(first.columns != second.rows) 
			throw new IllegalArgumentException("Input Matrices have incompatible dimensions!");
		
		Matrix result = new Matrix(first.rows, second.columns);
		
		for (int i = 0; i<result.rows; i++)
			for (int j=0; j < result.columns; j++)
			{
				int value = 0;
				
				// calculating result[i][j]
				for (int k=0; k<second.rows; k++)
					value += first.getData(i, k)*second.getData(k, j);
					
				result.setData(i, j, value); 
			}
		
		return result;
	}
}
