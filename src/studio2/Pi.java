package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the number of darts to throw: ");
		int totalDarts = in.nextInt();
		
		int dartsInQuarterCircle = 0;
		double x;
		double y;
		
		// simulate each dart throw for the total number of darts
		for (int i = 0; i < totalDarts; i++) {
			x = Math.random();
			y = Math.random();
			if (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= 1) {	// checks if dart landed within the quarter-circle (its radius is 1)
				dartsInQuarterCircle++;
			}
		}
		
		double pi = 4.0*((double)dartsInQuarterCircle/totalDarts);		// radio of darts in circle to total darts is proportional to area of circle (pi*r^2/4 = pi/4) to the area of the square (1*1=1)
		System.out.println(pi);

	}

}
