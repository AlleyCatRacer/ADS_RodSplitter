import java.util.HashMap;

public class Rod
{
	private static final HashMap<Integer, Integer> bestPrice = new HashMap<>();
	private static final int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
	// Length:	0	1	2	3	5	6	7	8	9	10
	// Price:	0	1	5	8	9	10	17	17	20	24
	
	public int bruteForceCut(int size)
	{
		int max = prices[size];
		
		if (size == 1)
		{
			return prices[1];
		}
		
		for (int i = 1; i < size; i++)
		{
			// Too smart to be first step max = Math.max(max, bruteForceCut(size-i) + prices[i]);
			int value = bruteForceCut(size - i);
			if (prices[i] + value > max)
			{
				max = prices[i] + value;
			}
		}
		return max;
	}
	
	public int recursiveCut(int size)
	{
		System.out.println("I went recursive.");
		if (size <= 1)
		{
			return prices[size];
		}
		
		int max = prices[size];
		
		for (int i = 2; i < prices.length + 1 && i < size; i++)
		{
			int value;
			
			if (bestPrice.get(size - i) == null)
			{
				value = recursiveCut(size - i);
				bestPrice.put(size - i, value);
			}
			else
			{
				value = bestPrice.get(size - i);
			}
			if (prices[i] + value > max)
			{
				max = prices[i] + value;
			}
		}
		
		return max;
	}
	
	public int dynamicCut(int size)
	{
		if (bestPrice.containsKey(size))
		{
			return bestPrice.get(size);
		}
		
		int max = recursiveCut(size);
		
		bestPrice.put(size, max);
		
		return max;
	}
}
