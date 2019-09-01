package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Number of items in the store
		int numItems = scan.nextInt();
		
		//creates the list of items with their price and type of item
		String[] itemType = new String[numItems];
		double[] itemCost = new double[numItems];
		
		//loop that assigns the positions of the above arrays
		for(int i = 0; i < numItems; i++) {
			itemType[i] = scan.next();
			itemCost[i] = scan.nextDouble();
		}
		
		
		
		// number of customers
		int customers = scan.nextInt();
		
		// Arrays to contain the names of the customers and and int ro represent how many items are bought
		String[] firstName = new String[customers];
		String[] lastName = new String[customers];
		double[] shoppingCost = new double[customers];
		int itemsBaught=0;
		
		
		//loop to create the arrays above
		for( int i = 0; i < customers; i++) {
			
			firstName[i] = scan.next();
			lastName[i] = scan.next();
			itemsBaught = scan.nextInt();
			
			//loop to fill the item list: item amount is how many of an object , itemName is the item bought
			for( int j = 0; j < itemsBaught; j++) {
				
				int itemAmount = scan.nextInt();
				String itemName = scan.next();
				
				//loop to compare names of items to get total cost
				for( int k = 0; k < itemType.length; k++) {
					
					//compares the string to the array
					if(itemName.equals(itemType[k])) {
						shoppingCost[i] += itemAmount * itemCost[k];
					}
				}
			}	
		}
		
		
		System.out.println("Biggest: " + firstName[maxShopper(shoppingCost)] + " " + 
										lastName[maxShopper(shoppingCost)] + " (" +
										String.format("%.2f",shoppingCost[maxShopper(shoppingCost)]) + ")");
		System.out.println("Smallest: " + firstName[minShopper(shoppingCost)] + " " +
										lastName[minShopper(shoppingCost)] +  " (" +
										String.format("%.2f",shoppingCost[minShopper(shoppingCost)]) + ")");
		System.out.println("Average: " + String.format("%.2f",average(shoppingCost)));
		
	}
	
	//finds the index of the max shopper spending
	public static int maxShopper(double[] shoppingCost) {
		int max =0;
		double maxCost = shoppingCost[0];
		for( int i = 0; i<shoppingCost.length; i++) {
			for ( int j = i+1; j <shoppingCost.length; j++) {
				if( maxCost < shoppingCost[j]){
					maxCost = shoppingCost[j];
					max = j;
				}
			}
		}
		return max;
	}
	
	//finds the index of the minimum shopper spending
	public static int minShopper(double[] shoppingCost) {
		int min=0;
		double minCost =shoppingCost[0];
		for( int i = 0; i<shoppingCost.length; i++) {
			for ( int j = i+1; j <shoppingCost.length; j++) {
				if( minCost > shoppingCost[j]){
					minCost = shoppingCost[j];
					min=j;
				}
			}
		}
		return min;
	}
	
	//finds the average of the shoppers
	public static double average (double[] shoppingCost) {
		double total = 0;
		for(int i = 0; i < shoppingCost.length; i++) {
			total += shoppingCost[i];
		}
		return total / shoppingCost.length;
	}
}
