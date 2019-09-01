package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int numItems = scan.nextInt();
		
		//creates the list of items with their price and type of item
		String[] itemType = new String[numItems];
		double[] itemCost = new double[numItems];
		int[] customerBoughtCounter = new int[numItems];
		int[] howManyItemsBought = new int[numItems];
		
		//loop that assigns the positions of the above arrays
		for(int i = 0; i < numItems; i++) {
			itemType[i] = scan.next();
			itemCost[i] = scan.nextDouble();
		}
		
		int customers = scan.nextInt();
		String[] firstName = new String[customers];
		String[] lastName = new String[customers];
		int itemsBaught=0;
		
		
		//loop to create the arrays above
		for( int i = 0; i < customers; i++) {
			
			firstName[i] = scan.next();
			lastName[i] = scan.next();
			itemsBaught = scan.nextInt();
			boolean[] hasItem = new boolean[numItems];
			
			//loop to fill the item list: item amount is how many of an object , itemName is the item bought
			for( int j = 0; j < itemsBaught; j++) {
				
				int itemAmount = scan.nextInt();
				String itemName = scan.next();
				
				//loop to compare names of items to get total cost
				
				for( int k = 0; k < itemType.length; k++) {
					
					//compares the string to the array
					if(itemName.equals(itemType[k])) {
						howManyItemsBought[k] +=itemAmount;
						hasItem[k] = true;
					}	
				}
				
			}
			
			// checks the boolean array if the customer bought the item and increments that count by 1
			for(int b = 0; b<hasItem.length; b++) {
				if(hasItem[b]) {
					customerBoughtCounter[b] ++;
				}
			}
			
		}
		
		for(int i =0; i<numItems; i++) {
			if(howManyItemsBought[i] == 0) {
				System.out.println("No customers bought " + itemType[i]);
			}
			else {
				System.out.println(customerBoughtCounter[i] + " customers bought " +
									howManyItemsBought[i] + " " + itemType[i]);
			}
		}
	}
}
