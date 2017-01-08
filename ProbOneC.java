
// Problem 1 Part C

import java.util.Scanner;

public class ProbOneC
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double base;
		double exponent;

		System.out.print("Enter base floating point number: ");
		base = input.nextDouble();

		System.out.print("Enter exponent floating point number: ");
		exponent = input.nextDouble();

		System.out.printf("%.2f raised to the power %.2f is %.2f", base, exponent, power(base, exponent));
	}

	public static double power(double base, double exponent)
	{
		// assume exponent is greater than or equal to 1
		if (exponent < 1.0) // catch input errors
		{
			System.out.println("Exponent must be 1 or greater.");
			return 0.0;
		}

		if (exponent == 1.0) // base case
			return base;
		else
			return base * power(base, exponent - 1.0);
	}
}