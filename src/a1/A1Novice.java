package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		//total number of customers
		int numCustomers = scan.nextInt();

		String[] firstName = new String[numCustomers];
		String[] lastName = new String[numCustomers];
		double[] customerTotals = new double[numCustomers];
		
		
		//loop to give customer info for first name, last name, and number of items
		for(int i = 0; i< numCustomers; i++) {

			firstName[i] = scan.next();
			lastName[i] = scan.next();
			int numItems = scan.nextInt();
			for(int j = 0; j<numItems; j++ ) {
				int amount = scan.nextInt();
				String item = scan.next();
				double price = scan.nextDouble();
				customerTotals[i]+= amount * price;
			}
			
		}
		
		for(int i = 0; i< numCustomers; i++) {
			System.out.println(firstName[i].charAt(0) + ". " + 
								lastName[i] + ": " + String.format("%.2f", customerTotals[i]));
		
		}
		
	}
}
