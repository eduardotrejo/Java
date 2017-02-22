/**
 * Title: DealNoDeal.java
 * Abstract: This program contains a simplified game of Deal or No Deal. Instead of
 * 			 the standard 26 cases, the player has a selection of 10 cases.
 * 			 When the game starts, a user should pick his/her case. Then, the program
 * 			 ask's the user to select three cases. After that, the banker
 * 			 makes an offer from the average of the remaining hidden cases.
 * 			 If there's a deal it exits the game, if no deal it continues giving the 
 * 			 chance to pick 2 more cases. After that you get the opportunity to select deal
 * 			 or no deal. If there's no deal player can continue picking 1 case until 1
 * 			 case is left or player takes the offer.
 * Author: Eduardo Trejo
 * ID: 6787
 * Date: 10/05/2014
 */

import java.util.Random;
import java.util.Scanner;

public class DealNoDeal {

	public static void main(String[] args) {
		
		// Variables used.
		int select, loop = 0, deal, original = 0, loop2 = 0, lastCase = 0, hidden = 0;
		double bankerAmount = 0, buffer = 0;
		
		// Set the cases.
		double []cases = {0.01, 1.00, 5.00, 10.00, 25.00, 50.00, 100.00, 200.00, 500.00, 1000.00};
		
		// Set casesSelected.
		boolean []casesSelected = new boolean[10];
		for(int i = 0; i < casesSelected.length; i++){
			casesSelected[i] = false;
		}
		// Set hiddenAmounts.
		boolean []hiddenAmounts = new boolean[10];
		for(int i = 0; i < casesSelected.length; i++){
			casesSelected[i] = false;
		}
		// Stores ascending amounts.
		double []remainingSort = new double[casesSelected.length];
		
		// Random number generator.
		Random rgen = new Random();  		
		
		// Randomize elements in the array.
		for(int i = 0; i < cases.length; i++){
			
		    int randomPosition = rgen.nextInt(cases.length);
		   	double temp = cases[i];
		   	cases[i] = cases[randomPosition];
		   	cases[randomPosition] = temp;
		}
		
		// Beginning of the game.
		System.out.println("========== Welcome to Deal or No Deal Game ========== ");
		
		// Show the hidden cases.
		System.out.print("\nHidden Cases: ");
		
		for(int i = 0; i < cases.length; i++){
			if(i < cases.length - 1){
				System.out.print((i + 1) + ", ");
			}else{
				System.out.print((i + 1) + "\n");
			}
		}
		
		// Player selects case.
		System.out.print("\nHi Player! Pick your case: ");
		Scanner keyboard = new Scanner(System.in);
		select = keyboard.nextInt();
		casesSelected[select - 1] = true;
		original = select;
		
		// Show the remaining hidden cases.
		System.out.print("\nHidden Cases: ");
		
		for(int i = 0; i < cases.length - 1; i++){
			if(casesSelected[i] != true){
				System.out.print((i + 1) + ", ");
			}
		}
		//System.out.print(i);
		System.out.println();
		// Loop 3 times.
		do{
			buffer = 0;
			do{
				System.out.print("\nPick a case: ");
				select = keyboard.nextInt();
				if(casesSelected[select - 1] == true){
					System.out.println("Please don't choose the same case again.");
				}
			}while(casesSelected[select - 1] == true);
			
			System.out.printf("Amount $%.2f\n", cases[select - 1]);
			casesSelected[select - 1] = true;
			hiddenAmounts[select - 1] = true;
			hidden++;
			loop++;
		}while(loop != 3);
	
		buffer = 0;
		// Stores the money amount into remainingSort array.
		for(int i = 0; i < remainingSort.length; i++){
			if(hiddenAmounts[i] != true){
				remainingSort[i] = cases[i];
			}else{
				remainingSort[i] = 0;
			}
		}
								
		// Sorts the amounts in ascending order.
		for(int i = 0; i < remainingSort.length; i++){
									
			for(int k = 0; k < remainingSort.length; k++){
				if(hiddenAmounts[i] != true){
					if(remainingSort[i] < remainingSort[k]){
						buffer = remainingSort[i];
						remainingSort[i] = remainingSort[k];
						remainingSort[k] = buffer; 
					}
				}
			}
		}
		// Prints out the remaining amounts.
		System.out.print("\nHidden Amounts: ");
		for(int i = 0; i < remainingSort.length; i++){
			if(hiddenAmounts[i] != true){
				System.out.printf("$%.2f ", remainingSort[i]);	
				bankerAmount += remainingSort[i];
			}
		}
		// Banker amount.
		bankerAmount /= remainingSort.length - hidden;
		System.out.printf("\n\nBanker Offer: $%.2f\n", bankerAmount);
		// Ask player deal or no deal.
		do{
			System.out.print("\nDeal (1) or No Deal (2): ");
			deal = keyboard.nextInt();
		}while(deal != 1 && deal != 2);
		
		// Deal.
		if(deal == 1){
			
			System.out.printf("\nOk! Your amount is $%.2f\n", bankerAmount);
			System.out.printf("Note that your original case number %d has $%.2f\n", original, cases[original - 1]);
			if(cases[original - 1] < bankerAmount){
				System.out.println("Thus, this is a good deal.");
			}else{
				System.out.println("Thus, this is a bad deal.");
			}
		// No deal.
		}else{
			
			// Show the remaining hidden cases.
			System.out.print("\nHidden Cases: ");
			
			for(int i = 0; i < casesSelected.length; i++){
				if(casesSelected[i] != true){
					System.out.print((i + 1) + " ");
				}
			}
			System.out.println();
			// Pick 2 cases.
			do{
				
				do{
					System.out.print("\nPick a case: ");
					select = keyboard.nextInt();
					if(casesSelected[select - 1] == true){
						System.out.println("Please don't choose the same case again.");
					}
				}while(casesSelected[select - 1] == true);
				
				System.out.printf("Amount $%.2f\n", cases[select - 1]);
				casesSelected[select - 1] = true;
				hiddenAmounts[select - 1] = true;
				hidden++;
				loop2++;
			}while(loop2 != 2);
			
			buffer = 0;
			// Stores the money amount into remainingSort array.
			for(int i = 0; i < remainingSort.length; i++){
				if(hiddenAmounts[i] != true){
					remainingSort[i] = cases[i];
				}else{
					remainingSort[i] = 0;
				}
			}
						
			// Sorts the amounts in ascending order.
			for(int i = 0; i < remainingSort.length; i++){
							
				for(int k = 0; k < remainingSort.length; k++){
					if(hiddenAmounts[i] != true){
						if(remainingSort[i] < remainingSort[k]){
							buffer = remainingSort[i];
							remainingSort[i] = remainingSort[k];
							remainingSort[k] = buffer; 
						}
					}
				}
			}
			// Reset banker amount.
			bankerAmount = 0;
			// Prints out the remaining amounts.
			System.out.print("\nHidden Amounts: ");
			for(int i = 0; i < remainingSort.length; i++){
				if(hiddenAmounts[i] != true){
					System.out.printf("$%.2f ", remainingSort[i]);	
					bankerAmount += remainingSort[i];
				}
			}
			// Banker amount.
			bankerAmount /= remainingSort.length - hidden;
			System.out.printf("\n\nBanker Offer: $%.2f\n", bankerAmount);
			
			do{
				// Ask player deal or no deal.
				do{
					System.out.print("\nDeal (1) or No Deal (2): ");
					deal = keyboard.nextInt();
				}while(deal != 1 && deal != 2);
					
				// Deal.
				if(deal == 1){
						
					System.out.printf("\nOk! Your amount is $%.2f\n", bankerAmount);
					System.out.printf("Note that your original case number %d has $%.2f\n", original, cases[original - 1]);
					if(cases[original - 1] < bankerAmount){
						System.out.println("Thus, this is a good deal.");
					}else{
						System.out.println("Thus, this is a bad deal.");
					}
					break;
				// No deal.
				}else{
					hidden++;
					if(cases.length - hidden != 1){
						buffer = 0;
						// Show the remaining hidden cases.
						System.out.print("\nHidden Cases: ");
							
						for(int i = 0; i < casesSelected.length; i++){
							if(casesSelected[i] != true){
								System.out.print((i + 1) + " ");
							}
						}
						System.out.println();
						
						do{
							System.out.print("\nPick a case: ");
							select = keyboard.nextInt();
							if(casesSelected[select - 1] == true){
								System.out.println("Please don't choose the same case again.");
							}
						}while(casesSelected[select - 1] == true);
						
						System.out.printf("Amount $%.2f\n", cases[select - 1]);
						casesSelected[select - 1] = true;
						hiddenAmounts[select - 1] = true;
					
						buffer = 0;
							
						// Stores the money amount into remainingSort array.
						for(int i = 0; i < remainingSort.length; i++){
							if(hiddenAmounts[i] != true){
								remainingSort[i] = cases[i];
							}else{
								remainingSort[i] = 0;
							}
						}
										
						// Sorts the amounts in ascending order.
						for(int i = 0; i < remainingSort.length; i++){
											
							for(int k = 0; k < remainingSort.length; k++){
								if(hiddenAmounts[i] != true){
									if(remainingSort[i] < remainingSort[k]){
										buffer = remainingSort[i];
										remainingSort[i] = remainingSort[k];
										remainingSort[k] = buffer; 
									}
								}
							}
						}
						// Reset banker amount.
						bankerAmount = 0;
						// Prints out the remaining amounts.
						System.out.print("\nHidden Amounts: ");
						for(int i = 0; i < remainingSort.length; i++){
							if(hiddenAmounts[i] != true){
								System.out.printf("$%.2f ", remainingSort[i]);	
								bankerAmount += remainingSort[i];
							}
						}
						// Banker amount.
						bankerAmount /= remainingSort.length - hidden;
						System.out.printf("\n\nBanker Offer: $%.2f\n", bankerAmount);
					}
					
				}	
			}while(cases.length - hidden != 1);
			
			if(cases.length - hidden == 1){
				System.out.println("\nOK! Since we have only one hidden case left, let’s open your original \ncase.");
				// Reset banker amount.
				buffer = 0;		
				hiddenAmounts[original - 1] = true;
				// Stores the money amount into remainingSort array.
				for(int i = 0; i < remainingSort.length; i++){
					if(hiddenAmounts[i] != true){
						remainingSort[i] = cases[i];
					}else{
						remainingSort[i] = 0;
					}
				}
											
				// Sorts the amounts in ascending order.
				for(int i = 0; i < remainingSort.length; i++){
												
					for(int k = 0; k < remainingSort.length; k++){
						if(hiddenAmounts[i] != true){
							if(remainingSort[i] < remainingSort[k]){
								buffer = remainingSort[i];
								remainingSort[i] = remainingSort[k];
								remainingSort[k] = buffer; 
							}
						}
					}
				}
				// Reset banker amount.
				bankerAmount = 0;
				// Prints out the remaining amounts.
				for(int i = 0; i < remainingSort.length; i++){
					if(hiddenAmounts[i] != true){
						bankerAmount += remainingSort[i];
						lastCase = i + 1;
					}
				}
				System.out.printf("Your amount is $%.2f\n", cases[original - 1]);
				System.out.printf("Note that the case number %d has $%.2f\n", lastCase, bankerAmount);
				if(bankerAmount > cases[original - 1]){
					System.out.println("Thus, this is a bad deal.");
				}else{
					System.out.println("Thus, this is a good deal.");
				}
			}		
		}
		System.out.println("\n========== Bye now. Thank you! ==========");	
	}
}
