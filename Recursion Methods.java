package Testing;

public class Recursion Methods {
	
	public static int ArraySum(int[] array)
	{
		return sumHelper(array, 0);
	}
	
	public static int sumHelper(int[] array, int n)
	{
		if(n == array.length)
		{
			return 0;
		}
		return array[n] + sumHelper(array, n+1);
	}
	
	public static int exp(int base, int a)
	{
	    if(a == 0)
	    {
	        return 1;
	    }
	    return base * exp(base, a-1);
	}

	public static String dragon(int n)
	{
	    if(n == 0)
	    {
	        return "F-H";
	    }
	    String first = dragon(n-1).replaceAll("F", "F-S");
	    String second = first.replaceAll("H", "F+H");
	    String third = second.replaceAll("S", "H");
	    return third;
	}
	
	public static int maxPathLength(int[][] array)
	{
		/*boolean[][] visited = new boolean[array.length][array[0].length];
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array.length; j++)
			{
				visited[i][j] = false;
			}
		}*/
		return findPath(array, 0, 0);
	}
	
	public static int findPath(int[][] array, int row, int col)
	{
		if(array[row][col] == 0)
		{
			return 0;
		}
		
		//visited[row][col] = true;
		array[row][col] = 0;
		int up = 0;
		int down = 0;
		int right = 0;
		int left = 0;
		
		if(row < array.length - 1 && array[row+1][col] == 1)
		{
			up = findPath(array, row+1, col);
		}
		
		if(row > 0 && array[row-1][col] == 1)
		{
			down = findPath(array, row-1, col);
		}
		
		if(col > 0 && array[row][col-1] == 1)
		{
			left = findPath(array, row, col-1);
		}
		
		if(col < array[0].length -1 && array[row][col+1] == 1)
		{
			right = findPath(array, row, col+1);
		}
		
		array[row][col] = 1;
		return 1 + Math.max(up,(Math.max(down, Math.max(left, right))));
	}
	
	public static void main(String[] args) {
		int[] test = {1, 3, 9, 7};
		System.out.println(ArraySum(test));
		System.out.println(exp(2,5));
        System.out.println(dragon(2));
 
        int[][] blah=  {{1, 1, 0, 0, 0, 0},
        				{0, 1, 1, 0, 0, 0},
        				{0, 0, 1, 1, 1, 0},
        				{0, 0, 1, 0, 1, 0},
        				{0, 0, 1, 0, 1, 1},
        		
        };
        
        int[][] killme = {  {1, 0, 0, 0},
        					{1, 1, 1, 0},
        					{1, 1, 1, 0}};
        int[][] why = { {0, 0, 1, 1, 0}, 
        				{1, 0, 1, 1, 0},
        				{0, 1, 0, 0, 0},
        				{0, 0, 0, 0, 1}};
        				
        
        System.out.println(maxPathLength(blah));
        System.out.println(maxPathLength(killme));
        

	}

}
