public class Rod
{
	private static Integer[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
	private static Integer[] best = {0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,};
	
	public static int cut(int size)
	{
		int max = prices[size];
		for (int i = 0; i < size; i++)
		{
			max = Math.max(max, cut(size-i) + prices[i]);
		}
		return max;
	}
	
	public static int dynamicCut(int size)
	{
		for (int i = 1; i < size; i++)
		{
		
		}
	}
}
