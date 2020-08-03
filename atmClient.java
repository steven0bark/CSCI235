/**
 *Client to operate the ATM
 */

import java.util Scanner;

public class atmClient{

    atm account = new atm;
    Scanner unerInupt = new Scanner(System.in);
    String input;

    System.out.println("Welcome to the ATM, your current balance is $" + account.getBalance + ", please selesct an option" );
    System.out.println("w: withdraw money from the ATM");
    System.out.println("t: add twenties to the ATM");
    System.out.println("f: add fives to the ATM");
    System.out.println("q: quit");
    System.out.print("Your selection: ")
    
    input = keyboard.nextLine();
    input = input.toLowerCase;
    char i = input.charAt(0);
   
    switch (i)
	{
	case 'w':
	    break;

	case 't':
	    break;

	case 'f':
	    System.out.print("How many fives would you like to 
	    break;
	 
	case 'q':
	    break;
	
	default:
	    System.out.println("That was not an option, please try again");
    


}
