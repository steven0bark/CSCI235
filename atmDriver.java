/**
*atmDriver.java
*
 *Client to operate the ATM. Makes deposits and withdrawls.
 *
 *@author Steven Barker
 *Wheaton College, CSCI235, Spring 2019
 *Project 5
 *3/29/19
 */

import java.util.Scanner;//to take user input
import java.util.InputMismatchException;//to handle potential errors

public class atmDriver{

    public static void main(String []args){
    
	atm account = new atm();//makes a new account
	Scanner userInput = new Scanner(System.in);


	for(;;){//creates an infinte loop so the program will run until the user quits
		//this is what the user interacts with
	    System.out.println("Welcome to the ATM, your current balance is " + account);
	    System.out.println("w: withdraw money from the ATM");
	    System.out.println("t: add twenties to the ATM");
	    System.out.println("f: add fives to the ATM");
	    System.out.println("q: quit");
	    System.out.print("Your selection--> ");
    
	    String str = userInput.nextLine();//holds the user input as a string
	    str = str.toLowerCase();//makes the input case insensitive
	    
	    char selection = str.charAt(0);//takes the character of the string
			
	    
   
	    if(selection == 'q'){//for the user to quit
	    	break;
	    }
	    

	    switch (selection) {
	
	    case 'w'://to withdrawl
		Scanner withdrawal = new Scanner(System.in);//for taking user input in the withdrawal
		int w = 0;
			
				
				try//just in case an integer is not entered
				{
					System.out.print("How much would you like to withdrawal?-->");
					w = withdrawal.nextInt();	
				}
				catch(InputMismatchException e){
					System.out.println("Please enter an integer");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}

		int finalOutput = account.withdrawal(w);//the int that is returned telling what happened
		
		if(finalOutput == 0){//if the withdrawal was successful
		    //Message saying if the withdraw was successful and the remaining balance
		    System.out.println("You withdrew $" + w + ", you current balance is " + account);
		    System.out.println("Thank you for visiting the ATM");//exit message
		    break;
		
		}else if(finalOutput == -1){//if the withdrawal amount is a mutliple of 5
		    System.out.println("I'm sorry, you must withdraw a multiple of 5");
		    System.out.println("Please try again");
		    break;

		}else if(finalOutput == -2){//if the withdrawal amount was more than the balance
		    System.out.println("I'm sorry you do not have that much in your account.");
		    System.out.println("Please try again.");
		    break;
		}else if(finalOutput == -3){//if the withdrawal could not be completed
		    System.out.println("I'm sorry, you do not have the right bills to complete the withdrawal");//error message saying nothing was withdrawaled
		    System.out.println("Your balance is still " + account);
		    System.out.println("Please try again");
		    break;
		}
			
	    case 't'://to add twenties
		Scanner depositTwenties = new Scanner(System.in);//to take in the amount of twenties to be deposited
		int twenties = 0;//hold the amount of 20s deposited
		
		try//handle expections
		{
		System.out.print("How many twenties would you like to deposit?-->");
		twenties = depositTwenties.nextInt();//holds the user input
		}
		catch(InputMismatchException e){
			System.out.println("Please enter an integer");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	    

		account.addTwenty(twenties);//adds the twenties to the account
		//message saying what was deposited and the current balance
		System.out.println("You deposited $" + twenties*20 + ". Your current balance is " + account);
		break;

	    case 'f'://adds fives
		Scanner depositFives = new Scanner(System.in);//to take the amount of fives
		int fives = 0;
		
		try//handle exceptions
		{
		System.out.print("How many fives would you like to deposit?-->");
		fives = depositFives.nextInt();//holds the user input
		}
		catch(InputMismatchException e){
			System.out.println("Please enter an integer");
			break;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			break;
		}

		account.addFives(fives);//adds the fives

		//message saying how much was despoited and the current balance
		System.out.println("You depositied $" + fives*5 + ". Your current balance is " + account);
		break;

	    default://in case the input was invalid
		System.out.println("That was not an option, please try again");//error message
	    
	    }

	}
 	System.out.println("Have a nice day.");//exit message

    }

}

