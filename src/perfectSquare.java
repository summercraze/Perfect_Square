import java.util.ArrayList;

public class perfectSquare 
{
	//parameter
	private int number;
	ArrayList<Integer>factor,sort;
	private int divisor,result,index;

	//constructor
	public perfectSquare()
	{
		number = 12;
		factor = new ArrayList<>();
	}
	public perfectSquare(int num)
	{
		number = num;
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

	//helper method to figure out which divisor to return
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

	//this factor out all the number and put them in a list
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

	//this sort out all the factor
	private ArrayList<Integer> sortFactor()
	{
		//put all factor in a list and sort it from max to min
		this.factor = this.factorList(this.number);
		java.util.Collections.sort(this.factor);

		//this figure out which number show out even time and remove the number
		sort = new ArrayList<>();
		for(int i = 0;i < this.factor.size();i++)
		{
			index = this.factor.lastIndexOf(this.factor.get(i));;
			if((index - i)%2 == 0 && !sort.contains(this.factor.get(i)))
			{
				//put it in sort arrayList
				sort.add(this.factor.get(i));
			}
			i = index;
		}
		return this.sort;
	}

	//return the smallest n
	public int getSmallestN()
	{
		this.result = 1;
		this.factor = this.sortFactor();
		for(int i = 0;i < this.factor.size();i++)
		{
			this.result = result *  this.factor.get(i);
		}
		return this.result;
	}

	//return m*n
	public int getPerfectSquare()
	{
		return result*number;
	}
}
