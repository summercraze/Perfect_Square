import java.util.ArrayList;

public class pefectSquare
{
	//parameter
	private int number;
	ArrayList<Integer>factor;
	private int divisor,result,index;

	//constructor
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

	//setter and getter for number
	public void setNumber(int num)
	{
		number = num;
	}
	public int getNumber()
	{
		return this.number;
	}
	
	//private method to find which factor
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
	
	//this method save all factor in one list
	private ArrayList<Integer> factorList(int num)
	{
		while (num != 1)
		{
			divisor = findDivisor(num);
			num = num / divisor;
			factor.add(divisor);
		}

		return factor;
	}
	
	//this sort out the factor and put them into an array list
	private ArrayList<Integer> sortFactor()
	{
		//sort out the factor in the list
		this.factor = this.factorList(this.number);
		java.util.Collections.sort(this.factor);
        
		//loop through the factor list and remove the even time appeared number
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
	
	//this only figure out which number in the list show up once and save it in list
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
	
	//get the n
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
	
	//get the m*n
	public int getPerfectSquare()
	{
		return result*number;
	}
}
