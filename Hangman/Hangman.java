/**
 * Title: Hangman.java
 * Abstract: This program reads in a file location and stores a specific word into an array
 * 			 then it creates a underscore array for the word's length and the player to solve.
 * 			 The program also allows for guess input and hint. Also, keeps track of repeated guesses.
 * Author: Eduardo Trejo
 * ID: 6787
 * Date: 09/12/2014
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hangman {
	
	public static void main(String[] args){
		System.out.println("--------- Welcome to Hangman ---------");
		
		System.out.print("Enter file name: ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.next();
		
		// Variables.
		String fullWord = null;		
		int badGuessCount = 0; 
		boolean finished = false;
		String usedBefore = "";
		String incorrectBefore = "";
		boolean hint = false;
		int increment = 0;
		boolean goodGuess = false;
		char testing = '\0';
		
		// Event handler.
		Scanner inputStream = null;		
		try{
			inputStream = new Scanner(new File(fileName));
			
		}catch(FileNotFoundException e){
			System.out.println("Error opening the file " + fileName);
			System.exit(0);	
			
		}	
		
		// While file still has words in it, word in file is put into fullWord.
		while(inputStream.hasNextLine()){
			fullWord = inputStream.nextLine();		
		}
		// Create a char array from the word.
		char[] charArray = fullWord.toCharArray();
		
		// Create an array with underscores.
		char[] underScore = new char[fullWord.length()];
		
		// Set up the underScore Array.
		for(int i = 0; i < charArray.length; i++){
			underScore[i] = '_';
		}
		
		// Will loop until finished is not false.
		while(!finished){
			
			// If hint was used.
			if(hint == true){
				// Displays how many incorrect guesses you have left.
				System.out.println("But since you used the hint, you can guess " + (4 - badGuessCount)  + " more times.\n");
			}
			
			// Displays the current characters and hidden word.
			System.out.print("So far the word is: ");
			for(int i = 0; i < charArray.length; i++){
				System.out.print(underScore[i] + " ");
			}
			
			// If hint was not used.
			if(hint == false){
				// Displays how many incorrect guesses you have left.
				System.out.println("\nYou have " + (4 - badGuessCount) + " incorrect guesses left.");
			}
			
			// Used for spacing.
			if(hint == true){
				System.out.println();
			}
			
			// Enter 1 for guessing and 2 for hint.
			System.out.print("Enter either 1 for guessing or 2 for hint: ");
			int choice = keyboard.nextInt();
		
			// Enter guess option.
			if(choice == 1){
				hint = false;
				// Enter char guess, will change to upper case.
				System.out.print("Enter your guess: ");
				String charGuess = keyboard.next();
				boolean flag = false;
				char userGuess = charGuess.toUpperCase().charAt(0);
				
				// To check valid guesses that have been made.
				if(usedBefore.contains(Character.toString(userGuess))){
					 // Adding at the correct input section.
					System.out.println("Not valid input. You already guessed " + userGuess + ".\n");
					flag = true;
				}
				
				// To check what incorrect guesses that have been made.
				if(incorrectBefore.contains(Character.toString(userGuess))){
					// Adding at the correct input section.
					System.out.println("Not valid input. You already guessed " + userGuess + ".\n");
					flag = true;
					badGuessCount++;			
				}
				
				// For loop to change underscore to a correct character.
				for(int h = 0; h < charArray.length; h++){
					if(userGuess == charArray[h]){
						underScore[h] = charArray[h];
						goodGuess = true;
						increment += 1;
					}
				}
				
				// If character is found in the word and not repeated.
				if(goodGuess == true && flag == false){
					System.out.println("That's right! " + userGuess + " is in the word.\n");
					usedBefore += Character.toString(userGuess);
				// Else if the character was not found in the word and not repeated.
				}else if(goodGuess == false && flag == false){
					System.out.println("Sorry, " + userGuess + " isn't in the word.\n");
					badGuessCount++;	
					incorrectBefore += Character.toString(userGuess);
				}
				goodGuess = false;
			}
			// Hint option.
			else{
				for(int i = 0; i < underScore.length; i++){
					if(underScore[i] == '_'){
						testing = fullWord.charAt(i);
						break;
					}			
				}
				for(int j = 0; j < underScore.length; j++){
					if(testing  == charArray[j]){
						underScore[j] = charArray[j];
						hint = true;
						increment += 1;
					}
				}
				System.out.println("OK! The hint is " + testing + ".");
				usedBefore += Character.toString(testing);
				badGuessCount++;
			}
			
			// If the word was solved.
			if(charArray.length == increment){
				if(hint == true){
					System.out.println();
				}
				System.out.print("Congratulations! The word was ");
				for(int i = 0; i < underScore.length; i++){
					System.out.print(underScore[i] + " ");
				}
				System.out.println();
				finished = true;
			// If you failed to solved.
			}if(badGuessCount == 4){
				if(hint == true){
					System.out.println();
				}
				System.out.print("You failed. The word was ");
				for(int i = 0; i < charArray.length; i++){
					System.out.print(charArray[i] + " ");
				}
				System.out.println();
				
				// Done.
				finished = true;
			}
		}		
		inputStream.close();
	}	
}
