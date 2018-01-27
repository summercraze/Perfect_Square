import java.util.ArrayList;
import java.util.Scanner;

public class main
{
	public static void main(String[] args)
	{
		int value;
		Scanner input  = new Scanner(System.in);
		System.out.print("Enter an integer m : ");
		value = input.nextInt();
		perfectSquare result = new perfectSquare(value);
//		pefectSquare result = new pefectSquare(value);
		System.out.println("The smallest number n for m*n to be perfect square is:" + result.getSmallestN());
		System.out.println("m * n is " + result.getPerfectSquare());
	}
}
