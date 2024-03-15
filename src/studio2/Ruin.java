package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter starting amount: ");
		double startAmount = in.nextDouble();
		
		System.out.print("Enter win chance: ");
		double winChance = in.nextDouble();
		
		System.out.print("Enter win limit: ");
		double winLimit = in.nextDouble();
		
		System.out.print("Enter number of simulations: ");
		int totalSimulations = in.nextInt();
		
		// game
		// number of simulations
		int simulationCounter = 0;
		int lossCounter = 0;
		double permanentStartAmount = startAmount;
		for (int i = 0; i<totalSimulations; i++)
		{
			// one day
			int dayCounter = 0;
			while ((startAmount < winLimit) && (startAmount != 0))
			{
				double random = Math.random();
				if (random < winChance)
				{
					startAmount++;
					dayCounter++;
				}
				else
				{
					startAmount--;
					dayCounter++;
				}
			}
			
			simulationCounter++;
			if (startAmount == 0)
			{
				System.out.println("Simulation " + simulationCounter + ": " + dayCounter + " LOSE");
				lossCounter++;
			}
				
			if (startAmount == winLimit)
			{
				System.out.println("Simulation " + simulationCounter + ": " + dayCounter + " WIN");
			}
			startAmount = permanentStartAmount;
		}
		System.out.println("Losses: " + lossCounter + " Simulations: " + simulationCounter);
		
		
		// calculating expected ruin
		double expectedRuin;
		double alpha = ((1.0-winChance)/winChance);
		if (winChance == 0.5)
		{
			expectedRuin = 1.0 - (startAmount/winLimit);
		}
		else
		{
			expectedRuin = ((Math.pow(alpha, startAmount)) - (Math.pow(alpha, winLimit)))/(1.0-Math.pow(alpha, winLimit));
		}
		System.out.println("Ruin Rate from Simulation: " + (double)lossCounter/(double)simulationCounter + " Expected Ruin Rate: " + expectedRuin);
	}

}
