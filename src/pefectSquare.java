import java.util.ArrayList;

public class pefectSquare

{
	protected int number;
	ArrayList<Integer>factor;
	private int divisor,result,index;

	public pefectSquare()
	{
		number = 12;
		factor = new ArrayList<>();
	}
	public pefectSquare(int num)
	{
		this.number = num;
		factor = new ArrayList<>();
	}
	private int findDivisor(int num)
	{
		if(num%2 == 0)
		{
			return 2;
		}
		else if(num%3 == 0)
		{
			return 3;
		}
		else if(num%5 == 0)
		{
			return 5;
		}
		else
		{
			return 7;
		}
	}
	private ArrayList<Integer> factorList(int num)
	{
		while (num != 1)
		{
			divisor = this.findDivisor(num);
			num = num / divisor;
			this.factor.add(divisor);
		}

		return this.factor;
	}
	private ArrayList<Integer> sortFactor()
	{
		this.factor = this.factorList(this.number);
		java.util.Collections.sort(this.factor);
		
		for(int i = 0;i < this.factor.size();i++)
		{
			index = this.factor.lastIndexOf(this.factor.get(i));;
			if((i - index)%2 != 0)
			{
				for (int j = i;j < index;j++)
				{
					this.factor.remove(j);
				}
			}

		}
		return this.factor;
	}
	private ArrayList<Integer> refineFactor( ArrayList<Integer> fact)
	{
		for(int i = 1;i < fact.size();i++)
		{
			if(fact.get(i) == fact.get(i-1))
			{
				fact.remove(i);
			}
		}
		return fact;
	} 
	public int getSmallestN()
	{
		this.result = 1;
		this.factor = this.refineFactor(this.sortFactor());
		for(int i = 1;i < this.factor.size();i++)
		{

			this.result = result *  this.factor.get(i);

		}
		return this.result;
	}
	public int getPerfectSquare()
	{
		return result*number;
	}

}
