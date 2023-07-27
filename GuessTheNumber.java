package Oasis;

import java.util.Scanner;
import java.util.Random;

class Guess 
{
	int systemInput; 
	int userInput; 
	int noOfGuesses = 1; 
	int range = 100; 
	
	Guess() 
	{ 
		Random random = new Random(); 
		this.systemInput = random.nextInt(100) + 1; 
	} 
	
	public boolean takeUserInput() 
	{ 
		if (noOfGuesses <=8) 
		{ 
			System.out.print("Guess the number: "); 
			this.userInput = GuessTheNumber.takeIntegerInput(100); 
			noOfGuesses++; 
			return false; 
		} 
		
		else 
		{ 
			System.out.println("Attempts are finished.\n Better luck for next time!!\n"); 
			return true; 
			} 
		} 
	
	public boolean isGuessCorrect() 
	{ 
		if (systemInput == userInput) 
		{ 
			System.out.println("\nWow!!,it's correct " + " in " +( noOfGuesses-1) + " guesses."); 
		
			
			switch(noOfGuesses) 
			{
			case 1: System.out.println("Your score is 100."); 
			break; 
			case 2: System.out.println("Your score is 90."); 
			break; 
			case 3: System.out.println("Your score is 80."); 
			break; 
			case 4: System.out.println("Your score is 70."); 
			break; 
			case 5: System.out.println("Your score is 60."); 
			break; 
			case 6: System.out.println("Your score is 50."); 
			break; 
			case 7: System.out.println("Your score is 40."); 
			break; 
			case 8: System.out.println("Your score is 30."); 
			break; 
			
			} 
			
			System.out.println(); 
			return true; 
		} 
		
		else if (noOfGuesses <= 8 && userInput > systemInput) 
		{ 
			if (userInput - systemInput > 10) 
			{ 
				System.out.println("Too High"); 
			} 
			else 
			{ 
				System.out.println("Little High"); 
			} 
		} 
		
		else if (noOfGuesses <= 8 && userInput < systemInput) 
		{ 
			if (systemInput - userInput > 10) 
			{ 
				System.out.println("Too low"); 
			} 
			else 
			{
				System.out.println("Little low"); 
			} 
		} 
		
		return false; 
	}
} 

public class GuessTheNumber 
{ 
	public static int takeIntegerInput(int limit) 
	{ 
		int input = 0; 
		boolean flag = false; 
		
		while (!flag) 
		{ 
			try 
			{
				Scanner s = new Scanner(System.in); 
				input = s.nextInt(); 
				flag = true; 
				if (flag && input > limit || input < 1) 
				{ 
					System.out.println("Choose the number between 1 and" + limit+"."); 
					flag = false; 
				} 
			} 
			
			catch (Exception E) 
			{ 
				System.out.println("Enter only integer value."); 
				flag = false; 
			} 
		}; 
		
		return input; 
	} 

	public static void main(String args[]) 
	{  
		System.out.println("Welcome to Guessing the Number Game!");
	    System.out.println("You have 8 attempts to guess the number.\nGood luck!");
		System.out.println("1.Start the Game\n2.Exit"); 
		System.out.print("Enter your choice: "); 
		int choice = takeIntegerInput(2); 
		int i=1;
		System.out.println("\n-----*****Start Guessing" + "*****-----");
		if (choice == 1) 
		{ 
			while (i<2) 
			{ 
				Guess game = new Guess(); 
				boolean isMatched = false; 
				boolean isLimitCross = false; 
				
			 
				while (!isMatched && !isLimitCross) 
				{ 
					isLimitCross = game.takeUserInput(); 
					isMatched = game.isGuessCorrect(); 
				} 
				
			i++;
			} 
		} 
		
		else 
		{ 
			System.exit(0); 
		} 
	}
}