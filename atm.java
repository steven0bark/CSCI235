/**
*atm.java
*
*Provides all methods and obejcts for the ATM to run.
*
*@author Steven Barker
*Wheaton College, CSCI235, Spring 2019
*Project 5
*3/29/19
*/

public class atm{

    /**
     *Keeps the total balance of the account
     */
    private int balance;
   
    /**
     *Keeps the amount of twenties in the account
     */
    private int twenties;
   
    /**
     *Keeps the amount of fives in the account
     */
    private int fives;
    
    /**
     *Constructor
     *Sets the inital balance and amount of twenties and fives to 0
     */
    public atm(){
	   balance = 0;
	   twenties = 0;
	   fives = 0;
    }
    
    /**
       addTwenty
       *Increases the amount of 5s in the account and increases the balance
       *Increases the balance by 20 times the specified amount of 20s
       *Increases the amount of 20s by the specified amount of of 20s
       *PRECONDITION: a must be an integer
       *POSTCONDITION: the balance will be increased by 20 times the amount of 20s deposited
       *and the amount of 20s is increased by the specified amount
       *@param a is the amount of 20s to be added
       */
    public void addTwenty(int a){
	   balance = balance + (a*20);//increases the balance by the specified amount of 20s
	   twenties = twenties + a; //increases the 20s by parameter
    }
    
    /**
     *addFives
     *Increases the amount of 5s in the account and increases the balance
     *Increases the balance by 5 times the specified amount of 5s
     *Increases the amount of 5s by the specified amount of of 5s
     *PRECONDITION: a must be an integer
     *POSTCONDITION: the balance will be increased by 5s times the amount of 5s deposited
     *and the amount of 5s is increased by the specified amount
     *@param a is the amount of 5s to be added
     */
    public void addFives(int a){
	   balance = balance + (a*5);//increases the balance by the specified 5s
	   fives = fives + a;//increases the 5s by the parameter
    }

    /**
     *withdrawal
     *Will withdraw from the balance
     *Tests if the withdrawal amount meets the precondtions
     *Tests if the program can withdrawal using twenties
     *Will withdrawal all the twenties possible first
     *Then tests if the withdrwl can use fives
     *Then will withdraw all the fives it can
     *If not all the fives were used, it will give twenties, fives, and balance thier original values
     *Then it will return whether the total withdraw was successful(0), if it could not be totally completed(-3), if
     *the withdrawal amount was not a multiple of 5(-1), or was more than the balance(-2)
     *PRECONDITION: Must be less than the current balance, and a multiple of 5
     *POSTCONDITION: Will either withdrawal all, or not withdrawal any
     *@param the amount to be withdrawaled
     *@return either 0,-1,-2, or -3 depending on the result of the transaction
     */
    public int withdrawal(int wAmount){
	int initialBal = balance;//hold the balance before the withdrawal
	int initialT = twenties;//hold the amount of 20s before the withdrawal
	int intialF = fives;//hold the amount of 5s before the withdrawal
	int wHolder = wAmount;//holds the withdrawal amount
	boolean fivesFlag = false;//used to tell if the fives are ever used
   		
	if(wAmount % 5 == 0 && wAmount <= balance){//checks the preconditions
	    if(wAmount >= 20 && twenties != 0){//checks if the 20s should be used
		    for(wHolder = wAmount; wHolder >= 20 && twenties > 0; wHolder -= 20){//takes 20s out until it cannot or runs out
		      balance -=20;
		      twenties -=1;
		    }
	    }

	    if (wHolder >= 5 && wHolder/5 <= fives) {//checks if the fives can be used
		    for(wHolder = wHolder; wHolder > 0 && fives > 0; wHolder -=5){
		      balance -= 5;
		      fives -=1;
		      fivesFlag = true;//flags if the fives gets used
		    }
	    }
   			
	    if(wHolder > 0 && !fivesFlag){//if the fives didn't get used, and  the deposit isn't complete
		  balance = initialBal;//returns balance back to original value
		  twenties = initialT;//returns twenties back to original value
		  fives = intialF;//return fives back to original value
		  return -3;//return message if the withdrawal is incomplete
	    }
	}else if(!(wAmount % 5 == 0)){
	    return -1;//return message if the input isnt a multiple of 5
	}else if(wAmount > balance){
	    return -2;//reutrn if the withdrawal amount is greater than the balance
	}
	return 0;//return if the whole withdrawal was successful
    }

    /**
     *toString
     *takes an int and makes it a string with a $
     *POSTCONDITION: Will return the balance in the account
     *@return a String of the current balance with the dollar amount and a $ in front
     */
    
    public String toString(){
        return "$" + balance;//puts a $ in front of the balance which is now a string
    }
}
